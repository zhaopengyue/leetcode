package leetcode.editor.cn.t_125_验证回文串

import leetcode.editor.cn.utils.Utils._

//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。 
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s 仅由可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 721 👎 0


/**
 * 解答成功:
 * 执行耗时:476 ms,击败了100.00% 的Scala用户
 * 内存消耗:54.3 MB,击败了40.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def isPalindrome(s: String): Boolean = {
        var i = 0
        var j = s.length - 1

        while (i <= j) {
            val ic = s.charAt(i)
            val jc = s.charAt(j)
            var isBreak = false
            if (! isWord(ic)) {
                i += 1
                isBreak = true
            }
            if (!isWord(jc)) {
                j -= 1
                isBreak = true
            }
            if (! isBreak) {
                if (format(ic) != format(jc)) return false
                i += 1
                j -= 1
            }
        }
        true
    }

    private def isWord(c: Char): Boolean = {
        (c >= 'a' && c <= 'z' ) || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')
    }

    private def format(c: Char): Char = if (c >= 'A' && c <= 'Z') (c + 32).toChar else c
}
//leetcode submit region end(Prohibit modification and deletion)
