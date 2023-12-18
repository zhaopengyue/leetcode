package leetcode.editor.cn.t_030_串联所有单词的子串

import leetcode.editor.cn.utils.Utils._

//给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。 
//
// s 中的 串联子串 是指一个包含 words 中所有字符串以任意顺序排列连接起来的子串。 
//
// 
// 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，
//"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。 
// 
//
// 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
//子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
//子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
//输出顺序无关紧要。返回 [9,0] 也是可以的。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
//解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
//s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
//所以我们返回一个空数组。
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
//解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
//子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
//子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
//子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 和 s 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1030 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks

object Solution {
  def findSubstring(s: String, words: Array[String]): List[Int] = {
    val rs = new ListBuffer[Int]

    val wordLen = words.head.length
    val wordNum = words.length
    val sLen = s.length


    val loop = new Breaks
    loop.breakable {
      for (i <- 0 until wordLen) {
        if (i + wordLen * wordNum > s.length) {
          loop.break()
        }
        val diff = new mutable.HashMap[String, Int]()
        // step1: 从i开始, 将s[i:i+wordNum*wordLen]分割为长度为wordLen的串，并记录diff值
        for (j <- 0 until wordNum) {
          val word = s.substring(i + j * wordLen, i + (j + 1) * wordLen)
          diff += (word -> (diff.getOrElse(word, 0) + 1))
        }
        // step2: 根据words调整diff
        for (word <- words) {
          diff += (word -> (diff.getOrElse(word, 0) - 1))
          if (diff(word) == 0) {
            diff.remove(word)
          }
        }
        // step3: 开始向右滑动窗口
        var start = i
        while (start < sLen - wordLen * wordNum + 1) {
          if (start != i) {
            // 右侧单词滑入
            var word = s.substring(start + wordLen * (wordNum - 1), start + wordLen * wordNum)
            diff += (word -> (diff.getOrElse(word, 0) + 1))
            if (diff(word) == 0) diff.remove(word)
            // 左侧单词滑出
            word = s.substring(start - wordLen, start)
            diff += (word -> (diff.getOrElse(word, 0) - 1))
            if (diff(word) == 0) diff.remove(word)
          }
          if (diff.isEmpty) {
            rs += start
          }
          start += wordLen
        }
      }
    }

    rs.toList
  }
}
//leetcode submit region end(Prohibit modification and deletion)
