package leetcode.editor.cn.t_416_分割等和子集

import leetcode.editor.cn.utils.Utils._

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1915 👎 0

/**
 * 解答成功:
	执行耗时:640 ms,击败了100.00% 的Scala用户
	内存消耗:54.6 MB,击败了100.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)

object Solution {
    def canPartition(nums: Array[Int]): Boolean = {
        val sum = nums.sum

        if ((sum & 1) != 0) return false

        // 回溯会导致超时
        //dp(0, nums, 0, sum >> 1)
        val avgSum = sum >> 1

        /*
            基于0-1背包问题, status[i]表示nums[0~x]之间的元素之和能是否能达到i
            当所有元素状态计算完成后, 只需要判断status[avgSum]是否为true即可表示nums[0-x]之间的元素的是否可以加和为avgSum
        */
        val status = new Array[Boolean](avgSum + 1)

        // 初始化status
        status(0) = true
        // 初始化第一个元素的status
        if (nums.head < avgSum) {
            status(nums.head) = true
        }

        for (i <- 1 until nums.length) {
            for (j <- (0 to avgSum).reverse) {
                if (status(j)) {
                    // 若上一状态可达, 则计算本层状态, 分两种方式决策
                    // 决策1: 本层不处理, 不影响状态, 故跳过
                    // 决策2: 处理本层, 计算状态
                    if (nums(i) + j <= avgSum) {
                        status(nums(i) + j) = true
                    }
                }
            }
        }

        status(avgSum)
    }

    /*
    def dp(i: Int, nums: Array[Int], currSum: Int, avgSum: Int): Boolean = {
        if (i == nums.length || currSum >= avgSum) return currSum == avgSum

        val v = nums(i)
        // 决策1: 不选当前元素  决策2: 选择当前元素
        dp(i + 1, nums, currSum, avgSum) ||
          dp(i + 1, nums, currSum + v, avgSum)
    }
    */

}
//leetcode submit region end(Prohibit modification and deletion)
