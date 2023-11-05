package leetcode.editor.cn.t_207_课程表
//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1819 👎 0

import leetcode.editor.cn.utils.Utils._

/**
 * 解答成功:
 * 执行耗时:568 ms,击败了80.00% 的Scala用户
 * 内存消耗:55.8 MB,击败了100.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util
import scala.collection.JavaConverters._
object Solution {
    def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {

        /**
         * 基于kahn方案, 先处理入度为0的节点, 然后处理依赖, 最后再判断
         */

        val inDegree = new Array[Int](numCourses)
        val queue = new util.LinkedList[Int]()
        val depMap = new util.HashMap[Int, util.ArrayList[Int]]()

        // 统计各个课程入度
        prerequisites.foreach(arr => {
            val now = arr(0)
            // 依赖
            val dep = arr(1)
            if (! depMap.containsKey(dep)) {
                depMap.put(dep, new util.ArrayList[Int]())
            }
            depMap.get(dep).add(now)
            inDegree(now) += 1
        })


        // 入度为0节点加入队列
        inDegree.zipWithIndex.filter(_._1 == 0).foreach(x => queue.add(x._2))

        while (! queue.isEmpty) {
            val dep = queue.remove()
            // 将其他依赖当前节点的入度-1
            if (depMap.containsKey(dep)) {
                depMap.get(dep).asScala.foreach(now => {
                    inDegree(now) -= 1
                    if (inDegree(now) == 0) {
                        queue.add(now)
                    }
                })
            }
        }

        for (i <- inDegree if i > 0) return false
        true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
