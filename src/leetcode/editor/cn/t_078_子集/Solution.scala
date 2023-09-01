package leetcode.editor.cn.t_078_子集

import leetcode.editor.cn.utils.Utils._

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2127 👎 0

/**
 * 解答成功:
	执行耗时:472 ms,击败了95.00% 的Scala用户
	内存消耗:54.9 MB,击败了45.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable.ListBuffer
object Solution {
    def subsets(nums: Array[Int]): List[List[Int]] = {
        val rs = new ListBuffer[List[Int]]()
        val line = new ListBuffer[Int]()
        dp(0, nums, line, rs)
        rs.toList
    }

    private def dp(no: Int, nums: Array[Int], line: ListBuffer[Int], rs: ListBuffer[List[Int]]): Unit = {
        if (no == nums.length) {
            rs += line.toList
            return
        }
        // 不选择当前元素
        dp(no + 1, nums, line, rs)
        // 选择当前元素
        line += nums(no)
        dp(no + 1, nums, line, rs)
        // 退出时移除当前元素
        line.remove(line.size-1)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
