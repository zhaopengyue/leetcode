package leetcode.editor.cn.t_062_不同路径

import leetcode.editor.cn.utils.Utils._

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
// 
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10⁹ 
// 
//
// Related Topics 数学 动态规划 组合数学 👍 1921 👎 0

/*
解答成功:
  执行耗时:428 ms,击败了23.53% 的Scala用户
  内存消耗:51.5 MB,击败了11.76% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {

    var ans = 0

    def uniquePaths(m: Int, n: Int): Int = {
        // 重置ans
        /*ans = 0
        byReverse(0, 0, m, n)
        ans*/
        byDP2(m, n)
    }

    // 空间复杂度优化版本DP
    private def byDP2(m: Int, n: Int): Int = {
        val status = Array.fill(n)(1)
        for (_ <- 1 until m; j <- 1 until n) {
            // status[j] = status[j] + status[j-1], 此处第二个status[j]表示上一行同列的值,status[j-1]表示同一行上一列的值
            status(j) += status(j - 1)
        }
        status(n - 1)
    }

    private def byDP(m: Int, n: Int): Int = {
        // 构建二维状态数组, status[i][j]表示走到(i,j)共有多少种走法
        val status = Array.fill(m)(Array.fill(n)(0))
        // 初始化status, 对于初始行和列的元素来说, 走到对应位置只有一种走法
        for (i <- 0 until m) {
            status(i)(0) = 1
        }
        for (i <- 0 until n) {
            status(0)(i) = 1
        }

        for (i <- 1 until m; j <- 1 until n) {
            status(i)(j) = status(i - 1)(j) + status(i)(j - 1)
        }

        status(m - 1)(n - 1)
    }

    // 基于回溯方式计算
    private def byReverse(i: Int, j: Int, m: Int, n: Int): Unit = {
        if (i == m - 1 && j == n - 1) {
            ans += 1
            return
        }
        // 仅有一者满足则直接退出
        if (i == m || j == n) return

        // 决策1: 向右
        byReverse(i, j + 1, m, n)
        // 决策2: 向下
        byReverse(i + 1, j, m, n)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
