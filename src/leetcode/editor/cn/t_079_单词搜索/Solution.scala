package leetcode.editor.cn.t_079_单词搜索

import leetcode.editor.cn.utils.Utils._

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 回溯 矩阵 👍 1669 👎 0

/**
 * 解答成功:
	执行耗时:600 ms,击败了85.71% 的Scala用户
	内存消耗:55.9 MB,击败了42.86% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def exist(board: Array[Array[Char]], word: String): Boolean = {
        // step0: 构建状态数组 0-未访问 1-访问过
        val status = Array.fill[Array[Int]](board.length)(Array.fill[Int](board.head.length)(0))

        // step1: 寻找第一个匹配的元素
        for ((line, i) <- board.zipWithIndex; (c, j) <- line.zipWithIndex) {
            if (c == word.head) {
                status(i)(j) = 1
                val rs =  dp(i, j, 1, status, board, word)
                if (rs) {
                    return true
                }
                status(i)(j) = 0
            }
        }
        false
    }

    private def dp(i: Int, j: Int, no: Int, status: Array[Array[Int]], board: Array[Array[Char]], word: String): Boolean = {
        if (no == word.length) return true


        status(i)(j) = 1
        val wordChar = word.charAt(no)
        var isFind = false
        // 从i和j的上下左右开始寻找
        // 上
        if (i - 1 >= 0 && board(i-1)(j) == wordChar && status(i-1)(j) == 0) isFind |= dp(i-1, j, no + 1, status, board, word)
        // 下
        if (i + 1 < board.length && board(i+1)(j) == wordChar && status(i+1)(j) == 0) isFind |= dp(i+1, j, no + 1, status, board, word)
        // 左
        if (j - 1 >= 0 && board(i)(j - 1) == wordChar && status(i)(j - 1) == 0) isFind |= dp(i, j - 1, no + 1, status, board, word)
        // 右
        if (j + 1 < board.head.length && board(i)(j + 1) == wordChar && status(i)(j + 1) == 0) isFind |= dp(i, j + 1, no + 1, status, board, word)

        status(i)(j) = 0

        isFind
    }
}
//leetcode submit region end(Prohibit modification and deletion)
