package leetcode.editor.cn.t_053_最大子数组和
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 5231 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {

    def maxSubArray(nums: Array[Int]): Int = {
        maxSubArrayByDp(nums)
    }

    def maxSubArrayByDp(nums: Array[Int]): Int = {
        // dp表示以i为结尾的连续子串的最大和
        val dp = new Array[Int](nums.length)
        // 初始化
        dp(0) = nums(0)
        // 转移方程
        // dp[i] = dp[i-1] + nums[i] where nums[i-1] > 0
        // dp[i] = nums[i]           where nums[i-1] <= 0
        for (i <- 1 until nums.length) {
           dp(i) = Math.max(dp(i-1) + nums(i), nums(i))
        }
        dp.max
    }
}
//leetcode submit region end(Prohibit modification and deletion)
