package leetcode.editor.cn.t_290_单词规律

import leetcode.editor.cn.utils.Utils._

//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 
//
// 示例1: 
//
// 
//输入: pattern = "abba", s = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 
//输入:pattern = "abba", s = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 
//输入: pattern = "aaaa", s = "dog cat cat dog"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= pattern.length <= 300 
// pattern 只包含小写英文字母 
// 1 <= s.length <= 3000 
// s 只包含小写英文字母和 ' ' 
// s 不包含 任何前导或尾随对空格 
// s 中每个单词都被 单个空格 分隔 
// 
//
// Related Topics 哈希表 字符串 👍 624 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
import java.util.UUID
object Solution {
    def wordPattern(pattern: String, s: String): Boolean = {
        val sArr = s.split(' ')
        if (sArr.length != pattern.length) return false
        val patternMap = mutable.HashMap[String, Int]() // 记录每个字符的编号
        val sMap = mutable.HashMap[String, Int]() // 记录每个字符的编号
        var startP = 0
        var startS = 0
        for (i <- pattern.indices) {
            val pc = pattern.charAt(i).toString
            val pNum = {
                if (patternMap.contains(pc)) patternMap(pc) else {
                    startP += 1
                    startP
                }
            }
            patternMap += (pc -> pNum)
            val sc = UUID.nameUUIDFromBytes(sArr(i).getBytes()).toString
            val sNum = {
                if (sMap.contains(sc)) sMap(sc) else {
                    startS += 1
                    startS
                }
            }
            if (sNum != pNum) return false
            sMap += (sc -> sNum)
        }

        true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
