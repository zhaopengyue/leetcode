package leetcode.editor.cn.t_152_乘积最大子数组

import leetcode.editor.cn.utils.Utils._

//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2130 👎 0

/**
* 解答成功:
	执行耗时:588 ms,击败了50.00% 的Scala用户
	内存消耗:55 MB,击败了83.33% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def maxProduct(nums: Array[Int]): Int = {
        // status[i]分别存放当前最小值和最大值
        var preMin = nums.head
        var preMax = nums.head

        var maxV = preMax

        // 基本思路: 利用最大值动规时记录最小值，防止遇见负数导致符号转换, 然后比较当前值/和最大值乘积/和最小值乘积的结果, 最终计算出当前
        // 节点的最小值和最大值.当所有节点计算完成后, 从status中找出最大值即可
        for (i <- 1 until nums.length) {
            val v = nums(i)
            val multiply1 = v * preMin
            val multiply2 = v * preMax
            preMin = List(v, multiply1, multiply2).min
            preMax = List(v, multiply1, multiply2).max
            maxV = math.max(maxV, preMax)
        }

        maxV
    }
}
//leetcode submit region end(Prohibit modification and deletion)
