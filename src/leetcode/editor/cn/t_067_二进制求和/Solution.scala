package leetcode.editor.cn.t_067_二进制求和
//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1172 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def addBinary(a: String, b: String): String = {
        // 结果集最大长度
        val maxLen = math.max(a.length, b.length)
        val ans = new Array[Char](maxLen + 1)

        val sum = '0'
        var startOffset = 0



        String.valueOf(ans, startOffset, ans.length - startOffset)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
