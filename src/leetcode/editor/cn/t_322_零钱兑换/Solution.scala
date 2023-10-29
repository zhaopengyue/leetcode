package leetcode.editor.cn.t_322_零钱兑换
//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2609 👎 0

/**
 * 解答成功:
 * 执行耗时:612 ms,击败了33.33% 的Scala用户
 * 内存消耗:55 MB,击败了33.33% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def coinChange(coins: Array[Int], amount: Int): Int = {
        if (amount == 0) return 0

        val status = new Array[Int](amount + 1)
        coins.foreach(i => if (i <= amount) status(i) = 1)

        if (status(amount) == 1) return 1

        for (i <- 1 to amount if status(i) == 0) {
            var minCount = Int.MaxValue
            for (coin <- coins) {
                val remainAmount = i - coin
                if (remainAmount > 0 && status(remainAmount) > 0) {
                    minCount = math.min(status(remainAmount) + 1, minCount)
                }
            }
            if (minCount == Int.MaxValue) minCount = -1
            status(i) = minCount
        }

        status(amount)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
