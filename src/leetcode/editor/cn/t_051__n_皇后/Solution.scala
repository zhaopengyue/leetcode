package leetcode.editor.cn.t_051__n_皇后

//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 1888 👎 0

/**
 * 解答成功:
	执行耗时:608 ms,击败了100.00% 的Scala用户
	内存消耗:60.7 MB,击败了100.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable.ListBuffer
object Solution {
    def solveNQueens(n: Int): List[List[String]] = {
        val rs = new ListBuffer[List[String]]
        dp(0, n, new Array[Int](n), new Array[String](n), rs)
        rs.toList
    }

    private def dp(i: Int, n: Int, status: Array[Int], line: Array[String], rs: ListBuffer[List[String]]): Unit = {
        if (i == n) {
            rs += line.toList
            return
        }
        // 决策第i层
        for (col <- 0 until n) {
            status(i) = col
            if (isValidly(i, col, n, status)) {
                line(i) = "." * col + "Q" + "." * (n - col - 1)
                dp(i + 1, n, status, line, rs)
            }
        }
    }

    def isValidly(row: Int, col: Int, n: Int, status: Array[Int]): Boolean = {
        if (row == 0) return true // 第1层无需验证
        for (i <- 0 until row) {
            // 正下
            if (status(i) == col) return false
            // 左斜
            if (col - (row - i) >= 0 && status(i) == col - (row - i)) return false
            // 右斜
            if (col + (row - i) < n && status(i) == col + (row - i)) return false
        }
        true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
