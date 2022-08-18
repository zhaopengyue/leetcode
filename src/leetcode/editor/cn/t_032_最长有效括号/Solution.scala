package leetcode.editor.cn.t_032_最长有效括号

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 1960 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
* 栈：
* 解答成功:
	执行耗时:540 ms,击败了66.67% 的Scala用户
	内存消耗:54.7 MB,击败了20.00% 的Scala用户
* 动态规划：
*
* */
import scala.collection.mutable
object Solution {
    def longestValidParentheses(s: String): Int = {
        // 栈
        byStack(s)
    }

    def byStack(s: String): Int = {
        val stack = new mutable.Stack[Int]()
        var maxCount = 0
        // 栈顶元素始终为未匹配的字符下标
        stack.push(-1)
        for (i <- s.indices) {
            val cs = s.charAt(i).toString
            if (cs == "(") {
                // 左括号直接入队
                stack.push(i)
            } else {
                // 出栈一个元素
                val index = stack.pop()
                if (index >= 0 && s.charAt(index).toString == "(") {
                    maxCount = Math.max(maxCount, i - stack.head)
                } else {
                    // 右括号未匹配，将其压入栈底
                    stack.push(i)
                }
            }
        }
        maxCount
    }
}
//leetcode submit region end(Prohibit modification and deletion)
