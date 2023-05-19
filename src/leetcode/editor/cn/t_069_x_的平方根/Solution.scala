package leetcode.editor.cn.t_069_x_的平方根
//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1126 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def mySqrt(x: Int): Int = {
       var i = 0
       var j = x
       // ans用于记录上一个i
       var ans = i
       while (i <= j) {
           val middle = (i + j) >> 1
           val v = BigDecimal(middle) * middle
           if (! v.isValidInt) {
               j = middle - 1
           } else {
               if (v == x) {
                   return middle
               } else if (v < x) {
                   ans = middle
                   i = middle + 1
               } else {
                   j = middle - 1
               }
           }
       }
       ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)
