package leetcode.editor.cn.t_238_除自身以外数组的乘积
//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
//
// Related Topics 数组 前缀和 👍 1475 👎 0

/**
 * 解答成功:
	执行耗时:632 ms,击败了94.74% 的Scala用户
	内存消耗:64.4 MB,击败了68.42% 的Scala用户
 * 原数组：       [1       2       3       4]
    左部分的乘积：   1       1      1*2    1*2*3
    右部分的乘积： 2*3*4    3*4      4      1
    结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def productExceptSelf(nums: Array[Int]): Array[Int] = {
        var left, right = 1
        val rs = new Array[Int](nums.length)

        rs(0) = 1
        rs(nums.length-1) = 1

        for (i <- 1 until nums.length) {
            left *= nums(i - 1)
            rs(i) = left
        }

        for (i <- (0 to nums.length -2 ).reverse) {
            right *= nums(i + 1)
            rs(i) *= right
        }

        rs
    }
}
//leetcode submit region end(Prohibit modification and deletion)
