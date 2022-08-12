package leetcode.editor.cn.t_020_有效的括号
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3449 👎 0

/*
* 解答成功:
	执行耗时:472 ms,击败了83.33% 的Scala用户
	内存消耗:54.3 MB,击败了20.83% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
object Solution {
    def isValid(s: String): Boolean = {
        if (s.length <= 1) return false
        val stack = new mutable.Stack[String]()
        // 第一个字符入栈
        stack.push(s.charAt(0).toString)
        for (c <- s.tail) {
            val cs = c.toString
            if (cs == "(" || cs == "[" || cs == "{") {
                // 左括号时入队
                stack.push(cs)
            } else {
                // 若栈顶为空，表示无匹配，直接返回
                if (stack.isEmpty) return false
                val stackHead = stack.head
                cs match {
                    case "]" => if (stackHead == "[") stack.pop() else return false
                    case ")" => if (stackHead == "(") stack.pop() else return false
                    case "}" => if (stackHead == "{") stack.pop() else return false
                    case _ => //忽略其他字符
                }
            }
        }
        stack.isEmpty
    }
}
//leetcode submit region end(Prohibit modification and deletion)
