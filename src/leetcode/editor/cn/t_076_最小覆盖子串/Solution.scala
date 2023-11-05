package leetcode.editor.cn.t_076_最小覆盖子串
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
// Related Topics 哈希表 字符串 滑动窗口 👍 2732 👎 0

/**
 * 解答成功:
 * 执行耗时:536 ms,击败了85.71% 的Scala用户
 * 内存消耗:54.8 MB,击败了57.14% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
import scala.util.control.Breaks
object Solution {
    def minWindow(s: String, t: String): String = {
        if (s.length < t.length) return ""

        val need = new mutable.HashMap[Char, Int]()

        t.foreach(c => {
            if (need.contains(c)) {
                need(c) += 1
            } else {
                need(c) = 1
            }
        })

        var needNums = t.length

        var minI = 0
        var minJ = -1
        var minLen = Int.MaxValue

        var i = 0
        var j = 0

        while (j < s.length) {
            var c = s.charAt(j)
            // step1: 寻找满足所有字符的串
            if (need.contains(c)) {
                // need(c)可以为负数,确保重置i时多余的字符可以被剔除
                need(c) -= 1
                if (need(c) >= 0) needNums -= 1
            }

            if (needNums == 0) {
                val loop = new Breaks()

                // step2: 尽可能缩减i, 使得以i开头的串为一个当前满足所有条件的最小串
                loop.breakable {
                    while (true) {
                        c = s.charAt(i)
                        if (need.contains(c)) {
                            if (need(c) == 0) loop.break()
                            need(c) += 1
                        }
                        i += 1
                    }
                }
                // step3: 计算当前长度
                if (j - i + 1 < minLen) {
                    minI = i
                    minJ = j
                    minLen = j - i + 1
                }
                // step4: 此时i一定指向了t中的元素, 剔除当前元素, 开始step1
                need(s.charAt(i)) += 1
                i += 1
                needNums += 1
            }
            j += 1
        }

        s.substring(minI, minJ + 1)

    }
}
//leetcode submit region end(Prohibit modification and deletion)
