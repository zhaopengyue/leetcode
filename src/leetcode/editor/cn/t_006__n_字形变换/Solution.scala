package leetcode.editor.cn.t_006__n_字形变换
//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
//
// Related Topics 字符串 👍 2146 👎 0

/**
 * 解答成功:
	执行耗时:516 ms,击败了100.00% 的Scala用户
	内存消耗:55.1 MB,击败了84.62% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)

import scala.util.control._

object Solution {
  def convert(s: String, numRows: Int): String = {
    if (s.length < numRows || numRows == 1) return s

    val strBuilder = new StringBuilder()

    for (level <- 0 until numRows) {
      // 首字符
      strBuilder.append(s.charAt(level))

      var index = level
      val break = new Breaks()

      break.breakable {
        while (true) {
          // 中间字符
          val mid = index + (numRows - level - 1) * 2
          if (mid != index && mid < s.length) {
            strBuilder.append(s.charAt(mid))
          } else if (mid >= s.length) {
              break.break()
          }
          // 右侧字符
          val right = mid + level * 2
          if (right != mid && right < s.length) {
            strBuilder.append(s.charAt(right))
          } else if (right >= s.length) {
              break.break()
          }
          if (right == index) break.break()
          index = right
        }
      }

    }

    strBuilder.toString()
  }
}
//leetcode submit region end(Prohibit modification and deletion)
