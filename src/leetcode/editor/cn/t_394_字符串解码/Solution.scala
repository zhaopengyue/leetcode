package leetcode.editor.cn.t_394_字符串解码

import leetcode.editor.cn.utils.Utils._

//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics 栈 递归 字符串 👍 1606 👎 0

/**
 * 解答成功:
	执行耗时:512 ms,击败了100.00% 的Scala用户
	内存消耗:55.6 MB,击败了100.00% 的Scala用户
 */

//leetcode submit region begin(Prohibit modification and deletion)
object Solution {

    val numStack = new scala.collection.mutable.Stack[String]()
    val strStack = new scala.collection.mutable.Stack[String]()

    def decodeString(s: String): String = {
        numStack.clear()
        strStack.clear()

        // 初始时填入一个空字符,最终计算结果会合并到该层
        strStack.push("")

        var tmpNumStr = ""
        // 统一字符串格式
        s"1[$s]".foreach(c => {
            if (c >= 'a' && c <= 'z') {
                strStack.push(strStack.pop() + c.toString)
            } else if (c >= '0' && c <= '9') {
                tmpNumStr = tmpNumStr + c.toString
            } else if (c == '[') {
                numStack.push(tmpNumStr)
                strStack.push("")
                tmpNumStr = ""
            } else {
                // c == ]
                val num = numStack.pop().toInt
                val str = strStack.pop()
                strStack.push(strStack.pop() + str * num)
            }
        })
        strStack.head
    }

}
//leetcode submit region end(Prohibit modification and deletion)
