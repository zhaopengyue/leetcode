package leetcode.editor.cn.t_209_长度最小的子数组

import leetcode.editor.cn.utils.Utils._

//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返
//回其长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1994 👎 0

/**
 * 解答成功:
 * 执行耗时:712 ms,击败了73.33% 的Scala用户
 * 内存消耗:78.6 MB,击败了93.33% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def minSubArrayLen(target: Int, nums: Array[Int]): Int = {
        if (nums(0) >= target) return 1
        // 计算前缀和
        val sumArr = new Array[Int](nums.length)
        sumArr(0) = nums(0)
        // 计算前缀和
        for (i <- 1 until nums.length) {
            if (nums(i) >= target) return 1
            sumArr(i) = sumArr(i - 1) + nums(i)
        }

        // 基于滑动窗口进行计算
        var i = 0
        var j = 0

        var minSize = Int.MaxValue


        while (j <= nums.length - 1 && i <= j) {
            // [i:j]的数组和
            val sum = sumArr(j) - sumArr(i) + nums(i)

            if (sum >= target) {
                // 记录一次当前size
                minSize = math.min(minSize, j - i + 1)
                if (i < j) {
                    // 扩充左边界
                    i += 1
                } else {
                    j += 1
                }
            } else {
                j += 1
            }
        }

        if (minSize == Int.MaxValue) 0 else minSize
    }
}
//leetcode submit region end(Prohibit modification and deletion)
