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
        val arrLen = math.max(a.length, b.length)
        val ans = new Array[Char](arrLen)

        var sum = 0

        (1 to arrLen).foreach(i => {
            ans(arrLen - i) = {
                val ac = c2i(if (i <= a.length) a.charAt(a.length - i) else '0')
                val bc = c2i(if (i <= b.length) b.charAt(b.length - i) else '0')
                // 计算当前位置sum
                val data = i2c(ac ^ bc ^ sum)
                sum = if (ac + bc + sum > 1) 1 else 0
                data
            }
        })

        (if (sum == 1) "1" else "") + String.valueOf(ans)
    }

    private def c2i(c: Char): Int = if (c == '0') 0 else 1
    private def i2c(c: Int): Char = if (c == 0) '0' else '1'
}
//leetcode submit region end(Prohibit modification and deletion)
