package leetcode.editor.cn.t_210_课程表_i_i

import leetcode.editor.cn.utils.Utils._

//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 
//prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。 
//
// 
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。 
// 
//
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：[0,1]
//解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
// 
//
// 示例 2： 
//
// 
//输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出：[0,2,1,3]
//解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。 
//
// 示例 3： 
//
// 
//输入：numCourses = 1, prerequisites = []
//输出：[0]
// 
//
// 
//提示：
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// 所有[ai, bi] 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 926 👎 0

/**
 * 解答成功:
 * 执行耗时:765 ms,击败了75.00% 的Scala用户
 * 内存消耗:61.1 MB,击败了0.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
object Solution {
    def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {

        /**
         * 基于kahn方案, 先处理入度为0的节点, 然后处理依赖, 最后再判断
         */

        // key: 课程, value: 表示完成课程key后可以完成哪些课程了
        val nodeMap = new mutable.HashMap[Int, mutable.ListBuffer[Int]]()
        val queue = new mutable.Queue[Int]()
        // 统计所有节点的入度
        val inDegree = new Array[Int](numCourses)
        var rs = new Array[Int](numCourses)

        // [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1, 则图为1->0
        prerequisites.foreach {
            case Array(now, dep, _*) =>
                // 更新关系
                nodeMap.getOrElseUpdate(dep, new mutable.ListBuffer[Int]) += now
                // dep节点入度+1
                inDegree(now) += 1
            case _ =>
        }

        inDegree.zipWithIndex.filter(_._1 == 0).foreach(x => queue.enqueue(x._2)) // 将索引加入

        var index = 0
        while (queue.nonEmpty) {
            val dep = queue.dequeue()
            nodeMap
              .getOrElse(dep, mutable.ListBuffer.empty[Int])
              .foreach(node => {
                  inDegree(node) -= 1
                  if (inDegree(node) == 0) {
                      queue.enqueue(node)
                  }
              })
            rs(index) = dep
            index += 1
        }

        if (index != inDegree.length) rs = Array.empty[Int]

        rs
    }
}
//leetcode submit region end(Prohibit modification and deletion)
