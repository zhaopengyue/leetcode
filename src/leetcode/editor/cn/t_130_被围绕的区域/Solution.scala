package leetcode.editor.cn.t_130_被围绕的区域

import leetcode.editor.cn.utils.Utils._

//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1092 👎 0

/**
 * > 2024/03/05 20:31:55
 * 解答成功:
 * 执行耗时:728 ms,击败了50.00% 的Scala用户
 * 内存消耗:58.6 MB,击败了50.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def solve(board: Array[Array[Char]]): Unit = {
        val xLen = board.length
        val yLen = board.head.length

        // 上下
        (0 until yLen).foreach(y => {
            if (board(0)(y) == 'O') process(board, 0, y)
            if (board(xLen - 1)(y) == 'O') process(board, xLen - 1, y)
        })
        // 左右--去除上下顶点
        (1 until xLen - 1).foreach(x => {
            if (board(x)(0) == 'O') process(board, x, 0)
            if (board(x)(yLen - 1) == 'O') process(board, x, yLen - 1)
        })

        // 重置
        for (x <- 0 until xLen; y <- 0 until yLen) {
            board(x)(y) = board(x)(y) match {
                case 'O' => 'X'
                case 'T' => 'O'
                case _ => board(x)(y)
            }
        }
    }

    /*
    * 处理完后的数据集中的字符:
    * X-->不变
    * O-->被围绕的O
    * T-->未被围绕的O
    * */
    private def process(board: Array[Array[Char]], x: Int, y: Int): Unit = {
        board(x)(y) = 'T'
        for ((increaseX, increaseY) <- List((-1, 0), (1, 0), (0, -1), (0, 1))) {
            val nx = increaseX + x
            val ny = increaseY + y
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board.head.length && board(nx)(ny) == 'O') {
                process(board, nx, ny)
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
