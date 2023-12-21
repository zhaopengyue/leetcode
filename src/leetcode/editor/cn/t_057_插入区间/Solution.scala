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

        var lastL = -1 // 上一个左边界
        var lastR = -1 // 上一个右边界

        // 插入的元素是否已经处理过了
        var isDeal = false

        intervals.foreach(interval => {
            var left = interval(0)
            var right = interval(1)

            if (lastR < left) {
                // 当前左边界大于上一个右边界, 将上一个范围添加到结果集中
                rs += Array(lastL, lastR)
            } else {
                // 区间存在交叉, 重新计算节点的左右边界
                left = math.min(lastL, left)
                right = math.max(lastR, right)
            }
            // 根据当前节点的左右边界与待添加节点,来判断当前节点的状态
            if (! isDeal) {
                // 若未处理新增的元素
                if ((addL >= left && addL <= right) || (addR >= left && addR <= right) || (addL <= left && addR >= right)) {
                    // 新增的元素与当前元素有交集
                    isDeal = true
                    lastL = math.min(left, addL)
                    lastR = math.max(right, addR)
                } else if (addL > lastR && addR < left) {
                    // 新增的元素正好位于前一个元素和当前元素之间
                    rs += Array(addL, addR)
                    isDeal = true
                    lastL = left
                    lastR = right
                } else {
                    // 无任何交集
                    lastL = left
                    lastR = right
                }
            } else {
                lastL = left
                lastR = right
            }
        })

        rs += Array(lastL, lastR)
        if (! isDeal) {
            // 若未被处理, 则直接添加到末尾
            rs += Array(addL, addR)
        }

        // 去除第一个初始化值
        val ans = new Array[Array[Int]](rs.length - 1)
        (1 until rs.length).foreach(i => ans(i-1) = rs(i))
        ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)
