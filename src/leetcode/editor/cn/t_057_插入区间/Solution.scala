package leetcode.editor.cn.t_057_插入区间

import leetcode.editor.cn.utils.Utils._

//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵ 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 10⁵ 
// 
//
// Related Topics 数组 👍 845 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable.ListBuffer
object Solution {
    def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
        if (intervals.isEmpty) return Array(newInterval)
        val rs = new ListBuffer[Array[Int]]()

        val addL = newInterval(0)
        val addR = newInterval(1)

        var currL = math.min(intervals.head(0), addL) // 当前左边界
        var currR = math.max(intervals.head(1), addR) // 当前右边界

        for (item <- intervals.tail) {
            val l = item(0)
            val r = item(1)

            // currL一定小于l
            if (currR  < l) {
                // 添加上一部分到结果集中
                rs += Array(currL, currR)
            }
            // 基于当前节点重新节点currL及currR
            if (addL <= r && addL >= currR) {
                // 左边界位于范围内才重新计算
                currL = math.min(addL, l)
                currR = math.min(addR, r)
            }
        }

        rs.toArray
    }
}
//leetcode submit region end(Prohibit modification and deletion)
