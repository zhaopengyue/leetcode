package leetcode.editor.cn.t_279_完全平方数
//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数学 动态规划 👍 1844 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def numSquares(n: Int): Int = {
        // status[i]表示达到i所需要的最小平方数
        val status = new Array[Int](n + 1)

        // 计算平方数数组
        val sqrtNums = new Array[Int](math.sqrt(n).toInt)
        sqrtNums.zipWithIndex.foreach(f => {
            val num = (f._2 + 1) * (f._2 + 1)
            sqrtNums(f._2) = num
            status(num) = 1
        })

        if (status(n) != 0) return 1

        for (i <- 1 to n) {
            if (status(i) == 0) {
                var minCount = Int.MaxValue
                var isBreak = false
                for (sqrtNum <- sqrtNums if ! isBreak) {
                    val remainNum = i - sqrtNum
                    // status[i] = math.min(status[i-[每一个平方数]] + 1)
                    if (remainNum > 0) {
                        minCount = math.min(minCount, status(remainNum) + 1)
                    } else {
                        isBreak = true
                    }
                }
                status(i) = minCount
            }
        }

        status(n)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
