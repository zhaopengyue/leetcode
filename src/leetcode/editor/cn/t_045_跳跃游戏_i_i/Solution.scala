package leetcode.editor.cn.t_045_跳跃游戏_i_i

import leetcode.editor.cn.utils.Utils._

//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2322 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def jump(nums: Array[Int]): Int = {
        var start = 0
        var end = 1
        var ans = 0
        while (end <= nums.length - 1) {
            var maxPos = 0
            // 计算本次跳跃的最远跳跃距离
            for (i <- start until end) {
                maxPos = math.max(maxPos, nums(i) + i)
            }
            // 下一次起跳从上一次起跳的最远位置开始
            start = end
            // 下一次起跳点范围结束的格子
            end = maxPos + 1
            ans += 1
        }
        ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)
