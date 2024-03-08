package leetcode.editor.cn.t_399_除法求值

import leetcode.editor.cn.utils.Utils._

//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 
//values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替
//代这个答案。 
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
//注意：x 是未定义的 => -1.0 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], 
//queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],[
//"a","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 数组 最短路 👍 1078 👎 0

/**
 * 解答成功:
 * 执行耗时:648 ms,击败了0.00% 的Scala用户
 * 内存消耗:57.5 MB,击败了0.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
object Solution {

    case class Relation(graph: Graph, weight: Double)

    class Graph(_value: String) {
        val value: String = _value
        var visited: Boolean =  false // 是否已经访问过
        val relations = new mutable.HashMap[String, Relation]()

        override def toString: String = value
    }

    def calcEquation(equations: List[List[String]], values: Array[Double], queries: List[List[String]]): Array[Double] = {
        // 存储元素与其元素pos
        val pos = new mutable.HashMap[String, Graph]()
        equations.indices.foreach(index => {
            val a = equations(index).head
            val b = equations(index)(1)
            val weight = values(index)

            // 更新a -> b的邻接表及其权重
            pos.getOrElseUpdate(a, new Graph(a)).relations += (b -> Relation(pos.getOrElseUpdate(b, new Graph(b)), weight))
            // 更新b -> a的反向权重
            pos(b).relations += (a -> Relation(pos(a), 1 / weight))
            // 自身到自身权重皆为1
            pos(a).relations += (a -> Relation(pos(a), 1.0))
            pos(b).relations += (b -> Relation(pos(b), 1.0))
        })

        val rs = Array.fill(queries.length)(-1.0)

        queries.zipWithIndex.foreach({
            case (List(a, b, _*), index) if pos.contains(a) && pos.contains(b) =>
                process(pos(a), pos(b), index, rs, pos, 1)
            case _ =>
        })

        rs
    }

    // 寻找从start节点开始到end节点的权重值
    private def process(start: Graph, end: Graph, index: Int, rs: Array[Double], pos: mutable.HashMap[String, Graph], currWeigh: Double): Unit = {
        if (start.visited) return // 若访问过, 则直接返回
        // 存在权重, 直接返回
        if (start.relations.contains(end.value)) {
            rs(index) = start.relations(end.value).weight * currWeigh
            return
        }
        // 设置为访问过当前节点
        start.visited = true
        // 不存在则基于深度优先进行探查
        start.relations.values.foreach(relation => {
            process(relation.graph, end, index, rs, pos, currWeigh * relation.weight) // 基于深度优先继续探查
        })
        // 退出时重置为false
        start.visited = false
    }
}
//leetcode submit region end(Prohibit modification and deletion)
