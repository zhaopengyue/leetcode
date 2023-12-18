package leetcode.editor.cn.t_036_有效的数独

import leetcode.editor.cn.utils.Utils._

//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 空白格用 '.' 表示。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字（1-9）或者 '.' 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 1187 👎 0

/**
 * 解答成功:
 * 执行耗时:552 ms,击败了100.00% 的Scala用户
 * 内存消耗:56 MB,击败了80.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
object Solution {
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {
        val set = new mutable.HashSet[String]()
        for (row <- 0 until 9; col <- 0 until 9) {
            val c = board(row)(col)
            if (c != '.') {
                val rowKey = getRowKey(row, c)
                val colKey = getColKey(col, c)
                val celKey = getCelKey(row, col, c)
                if (set.contains(rowKey)) {
                    return false
                }
                if (set.contains(colKey)) {
                    return false;
                }
                if (set.contains(celKey)) {
                    return false
                }
                set += rowKey
                set += colKey
                set += celKey
            }
        }
        true
    }

    /** 获取指定行对应的key*/
    private def getRowKey(row: Int, c: Char): String = s"row-$row-$c"

    private def getColKey(col: Int, c: Char): String = s"col-$col-$c"

    private def getCelKey(row: Int, col: Int, c: Char): String = {
        def getIndex(n: Int): Int = {
            if (n >= 6) {
                2
            } else if (n >= 3) {
                1
            } else {
                0
            }
        }
        val newRow = getIndex(row)
        val newCol = getIndex(col)
        s"cel-$newRow-$newCol-$c"
    }
}
//leetcode submit region end(Prohibit modification and deletion)
