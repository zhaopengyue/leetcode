package leetcode.editor.cn.t_029_两数相除
//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
//
// Related Topics 位运算 数学 👍 958 👎 0

/*
* 解答成功:
	执行耗时:420 ms,击败了100.00% 的Scala用户
	内存消耗:50.9 MB,击败了87.50% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def divide(dividend: Int, divisor: Int): Int = {
        // 特殊状态下会溢出，此处特殊处理
        if (dividend == Int.MinValue && divisor == -1) return Int.MaxValue
        // 检测是否同号
        val k = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)
        // 若m为Int.MinValue，则其绝对值仍然为Int.MinValue, 其负值仍然为Int.MinValue，为保证同号运算，这里统一采用负数计算
        var m = -Math.abs(dividend)
        val n = -Math.abs(divisor)
        var rs = 0
        while (m <= n) {
            var tmp = n
            // c用来记录减了多少个tmp
            var c = 1
            // 检查最多能减多大的tmp
            while (m - tmp <= tmp) {
                tmp = tmp << 1
                c = c << 1
            }
            m -= tmp
            rs += c
        }
        // 进行结果判断
        if (k) rs else -rs
    }
}
//leetcode submit region end(Prohibit modification and deletion)
