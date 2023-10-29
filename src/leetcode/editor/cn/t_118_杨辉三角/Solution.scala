package leetcode.editor.cn.t_118_杨辉三角

import leetcode.editor.cn.utils.Utils._

//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 1082 👎 0

/**
 * 解答成功:
 * 执行耗时:424 ms,击败了100.00% 的Scala用户
 * 内存消耗:51.6 MB,击败了66.67% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable.ListBuffer
object Solution {
    def generate(numRows: Int): List[List[Int]] = {
        val rs = new ListBuffer[List[Int]]
        rs += List(1)
        val line = new ListBuffer[Int]
        for (i <- 1 until numRows) {
            line.clear()
            for (j <- 0 to i) {
                if (j == 0 || j == i) {
                    line += 1
                } else {
                    line += rs(i - 1)(j - 1) + rs(i - 1)(j)
                }
            }
            rs += line.toList
        }
        rs.toList
    }
}
//leetcode submit region end(Prohibit modification and deletion)
