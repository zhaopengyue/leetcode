package leetcode.editor.cn.t_010_正则表达式匹配
//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
//
// Related Topics 递归 字符串 动态规划 👍 3135 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  def isMatch(s: String, p: String): Boolean = {
    val sLen = s.length
    val pLen = p.length

    var i = 0
    var j = 0

    while (i < sLen && j < pLen) {
      val sc = s.charAt(i).toString
      val pc = p.charAt(j).toString
      var pcNext = ""
      if (j + 1 < pLen) {
        pcNext = p.charAt(j + 1).toString
      }
      if (sc == pc && pcNext != "*") {
        // i == j 且 j的下一位不是*
        i += 1
        j += 1
      } else if (sc == pc && pcNext == "*") {
        // i == j 且 j的下一位是*，仅移动i
        i += 1
        // i位移到了最后一位，将i进行回朔，并对齐
        if (i == sLen) {
          // j位移2位
          j += 2
          i = sLen - (pLen - j)
        }
      } else if (sc != pc) {
        if (pc == "." && pcNext != "*") {
          i += 1
          j += 1
        } else if (pc == "." && pcNext == "*") {
          // .*时直接将i重置到和j剩余位数一致, j向后移1位
          j += 2
          i = sLen - (pLen - j)
        } else {
          if (pcNext == "*") {
            j += 2
          } else {
            return false
          }
        }
      }
    }
    if (i == sLen && j >= pLen) {
      true
    } else {
      false
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
