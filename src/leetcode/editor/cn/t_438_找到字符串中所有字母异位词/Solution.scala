package leetcode.editor.cn.t_438_找到字符串中所有字母异位词
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1192 👎 0

/**
 * 解答成功:
	执行耗时:648 ms,击败了60.00% 的Scala用户
	内存消耗:54.9 MB,击败了60.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
object Solution {
  def findAnagrams(s: String, p: String): List[Int] = {
    val s_flag = new Array[Int](26)
    val p_flag = new Array[Int](26)
    val rs = new mutable.ListBuffer[Int]

    if (p.length > s.length) return List.empty[Int]

    // 初始化p
    for (i <- p.indices) {
      p_flag(p.charAt(i) - 'a') += 1
    }

    for (i <- s.indices) {
      s_flag(s.charAt(i) - 'a') += 1
      val j = i - p.length
      if (j >= 0) {
        s_flag(s.charAt(j) - 'a') -= 1
      }
      if (compare(s_flag, p_flag)) {
        rs += j + 1
      }
    }
    rs.toList
  }

  def compare(s_flag: Array[Int], p_flag: Array[Int]): Boolean = {
    var break = false
    for (i <- 0 until 26 if !break) {
      if (s_flag(i) != p_flag(i)) {
        break = true
      }
    }
    !break
  }

  def main(args: Array[String]): Unit = {
    findAnagrams("cbaebabacd", "abc")
  }
}
//leetcode submit region end(Prohibit modification and deletion)
