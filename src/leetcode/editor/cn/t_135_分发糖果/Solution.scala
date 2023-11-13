package leetcode.editor.cn.t_135_分发糖果

import leetcode.editor.cn.utils.Utils._

//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。 
//
// 你需要按照以下要求，给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻两个孩子评分更高的孩子会获得更多的糖果。 
// 
//
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。 
//
// 
//
// 提示： 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 1388 👎 0

/**
 * 解答成功:
	执行耗时:672 ms,击败了50.00% 的Scala用户
	内存消耗:57.3 MB,击败了50.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def candy(ratings: Array[Int]): Int = {
        if (ratings.length == 1) return 1

        val len = ratings.length

        // 初始每人一个糖果
        val left = Array.fill(len)(1)

        // 满足左规则
        for (i <- 1 until len) {
            val curr = ratings(i)
            val last = ratings(i - 1)
            if (last < curr) left(i) = left(i - 1) + 1
        }

        var preRight = 1
        var ans = left(len - 1)

        // 满足右规则
        for (i <- (0 until len - 1).reverse) {
            val curr = ratings(i)
            val next = ratings(i + 1)
            if (curr > next) preRight += 1 else preRight = 1
            ans += math.max(left(i), preRight)
        }

        ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)
