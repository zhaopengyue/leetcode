package leetcode.editor.cn.t_392_判断子序列

import leetcode.editor.cn.utils.Utils._

//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
//"aec"不是）。 
//
// 进阶： 
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？ 
//
// 致谢： 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc", t = "ahbgdc"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "axc", t = "ahbgdc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// 两个字符串都只由小写字符组成。 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 978 👎 0

/**
 * 解答成功:
 * 执行耗时:480 ms,击败了12.50% 的Scala用户
 * 内存消耗:53.4 MB,击败了62.50% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def isSubsequence(s: String, t: String): Boolean = {
        if (s.length > t.length) return false

        // 双指针法
        var i = 0
        var j = 0
        while (i < s.length && j < t.length) {
            if (s.charAt(i) == t.charAt(j)) {
                i += 1
            }
            j += 1
        }
        i == s.length
    }
}
//leetcode submit region end(Prohibit modification and deletion)
