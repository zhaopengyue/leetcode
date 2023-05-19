package leetcode.editor.cn.t_056_合并区间
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 1627 👎 0

/*
* 解答成功:
	执行耗时:644 ms,击败了80.00% 的Scala用户
	内存消耗:59.3 MB,击败了100.00% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.Comparator
import scala.collection.mutable.ListBuffer
object Solution {
    def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
        if (intervals.length == 1) return intervals
        // 先按照区间左侧排序
        java.util.Arrays.sort(intervals, new Comparator[Array[Int]] {
            override def compare(o1: Array[Int], o2: Array[Int]): Int = o1.head - o2.head
        })
        val rs = new ListBuffer[Array[Int]]
        var left = intervals(0)(0)
        var right = intervals(0)(1)
        for (i <- intervals.tail) {
            val iLeft = i(0)
            val iRight = i(1)
            if (iLeft <= right) {
                // 下述操作尽量扩大区间
                if (iLeft < left) {
                    left = iLeft
                }
                // 检查右侧是否大于当前right
                if (iRight > right) {
                    right = iRight
                }
            } else {
                // 将当前区间放入结果集
                rs += Array(left, right)
                left = iLeft
                right = iRight
            }
        }
        // 将最后一组放入结果集
        rs += Array(left, right)
        rs.toArray
    }
}
//leetcode submit region end(Prohibit modification and deletion)
