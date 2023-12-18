package leetcode.editor.cn.t_028_找出字符串中第一个匹配项的下标

import leetcode.editor.cn.utils.Utils._

//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2078 👎 0

/**
 * 解答成功:
 * 执行耗时:444 ms,击败了76.92% 的Scala用户
 * 内存消耗:52.3 MB,击败了76.92% 的Scala用户
 *
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def strStr(haystack: String, needle: String): Int = {
        if (haystack.length < needle.length) return -1
        // 構建pmt数组
        val pmt = getPMT(needle)

        // 基于pmt构建
        var i = 0
        var j = 0
        while (i < haystack.length && j < needle.length) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i += 1
                j += 1
            } else {
                j = pmt(j)
            }
        }

        if (j == needle.length) return i - j else -1
    }

    private def getPMT(needle: String): Array[Int] = {
        val pmt = new Array[Int](needle.length)

        pmt(0) = -1
        var i = 1
        var j = 0
        while (i < needle.length - 1) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pmt(j)
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j += 1
            }
            i += 1
            pmt(i) = j
        }

        pmt
    }
}
//leetcode submit region end(Prohibit modification and deletion)
