package leetcode.editor.cn.t_055_跳跃游戏

import leetcode.editor.cn.utils.Utils._

//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2557 👎 0

/**
 * 解答成功:
	执行耗时:680 ms,击败了53.33% 的Scala用户
	内存消耗:56.5 MB,击败了26.67% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def canJump(nums: Array[Int]): Boolean = {
        // k表示最远能跳到的下标
        var k = 0
        nums.zipWithIndex.foreach(item => {
            // 若当前下标大于k,表示当前无法跳到当前下标,即其无法到达目的的
            if (item._2 > k) return false
            // 计算从当前节点开始最远能跳多少
            k = math.max(k, item._1 + item._2)
        })
        true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
