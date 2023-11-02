package leetcode.editor.cn.t_1143_最长公共子序列

import leetcode.editor.cn.utils.Utils._

//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
//
// Related Topics 字符串 动态规划 👍 1452 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {

    def longestCommonSubsequence(text1: String, text2: String): Int = {
        dp(text1, text2)
    }
    def dp(text1: String, text2: String): Int = {

        /**
         * status[i][j] = n 表示text1[0~i]和text2[0~j]之间最长公共序列长度为n
         * 基于此: 状态转移方程应该为:
         * status[i][j] = {
         *    status[i-1][j-1] + 1 ==> 当text1[i] == text2[j]
         *    status[i-1][j-1] ==> 当text1[i] != text2[j]
         *    status[i-1][j],
         *    status[i][j-1]
         * }.max
         */
        val status = Array.fill(text1.length, text2.length)(0)

        status(0)(0) = if (text1.head == text2.head) 1 else 0
        // step1: 初始化边界
        for (i <- 1 until text1.length) {
            status(i)(0) = math.max(if (text1.charAt(i) == text2.head) 1 else 0, status(i - 1)(0))
        }
        for (i <- 1 until text2.length) {
            status(0)(i) = math.max(if (text2.charAt(i) == text1.head) 1 else 0, status(0)(i - 1))
        }


        // step2: 从斜对角开始计算
        for (i <- 1 until text1.length) {
            for (j <- 1 until text2.length) {
                val tempV = if (text1.charAt(i) == text2.charAt(j)) status(i-1)(j-1) + 1 else status(i-1)(j-1)
                status(i)(j) = List(tempV, status(i - 1)(j), status(i)(j - 1)).max
            }
        }

        status(text1.length - 1)(text2.length - 1)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
