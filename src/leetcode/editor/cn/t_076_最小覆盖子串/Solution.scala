package leetcode.editor.cn.t_076_最小覆盖子串

import leetcode.editor.cn.utils.Utils._

import java.util

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2730 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
object Solution {
    def minWindow(s: String, t: String): String = {

        if (s.length < t.length) return ""
        if (s == t) return s

        val tMap = new mutable.HashMap[Char, Int]()
        val sMap = new mutable.TreeMap[Char, Int]()

        // 构建map
        t.foreach(c => {
            if (tMap.contains(c)) {
                tMap(c) += 1
            } else {
                tMap(c) = 1
            }
        })

        var minI = 0
        var minJ = -1
        var minLen = Int.MaxValue

        var i = 0
        var j = 0

        while (j <= s.length - 1) {
            val c = s.charAt(j)
            if (sMap.contains(c)) {
                sMap(c) += 1
            } else {
                sMap(c) = 1
            }

            if (compactor(sMap, tMap)) {
                if (j - i < minLen) {
                    minI = i
                    minJ = j
                    minLen = j - i + 1
                }

                // 重置i
                sMap(s.charAt(i)) -= 1
                i += 1
                var isBreak = false
                while (i <= j && ! isBreak) {
                    if (tMap.contains(s.charAt(i)) && sMap(s.charAt(i)) == tMap(s.charAt(i))) {
                        isBreak = true
                    } else {
                        sMap(s.charAt(i)) -= 1
                        i += 1
                    }
                }
            }
            j += 1
        }


        s.substring(minI, minJ + 1)
    }

    def compactor(map1: mutable.TreeMap[Char, Int], map2: mutable.HashMap[Char, Int]): Boolean = {
        for ((k, v) <- map2) {
            if (! map1.contains(k) || map1(k) < v) {
                return false
            }
        }
        true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
