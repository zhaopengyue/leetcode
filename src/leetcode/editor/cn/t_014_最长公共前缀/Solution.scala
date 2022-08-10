package leetcode.editor.cn.t_014_最长公共前缀

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 👍 2383 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import scala.util.control.Breaks
object Solution {
  def longestCommonPrefix(strs: Array[String]): String = {
    var isBreak = false
    var i = 0
    // 以第一个字符为基准
    val firstStr = strs.head
    if (firstStr.isEmpty) return ""

    val stringBuilder = new StringBuilder
    // i小于first长度才会有效
    while (i < firstStr.length && !isBreak) {
      val loop = new Breaks
      loop.breakable {
        for (str <- strs.tail) {
          if (str.isEmpty || i >= str.length || str.charAt(i) != firstStr.charAt(i)) {
            isBreak = true
            loop.break()
          }
        }
      }
      if (!isBreak) {
        stringBuilder.append(firstStr.charAt(i).toString)
      }
      i += 1
    }
    stringBuilder.toString()
  }
}
//leetcode submit region end(Prohibit modification and deletion)
