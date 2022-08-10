package leetcode.editor.cn.t_007_整数反转
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3582 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  def reverse(x: Int): Int = {
    var curr = x
    var rs = 0
    while (curr != 0) {
      // 获取当前某位的数字
      val num = curr % 10
      // 提前一轮检测下是否溢出
      var isFill = false
      if (x < 0) {
        isFill = (Int.MinValue - num) / 10 > rs
      } else {
        isFill =(Int.MaxValue - num) / 10 < rs
      }
      if (isFill) {
        // 存在溢出，退出循环
        return 0
      } else {
        rs = rs * 10 + num
        curr = curr / 10
      }
    }
    rs
  }
}
//leetcode submit region end(Prohibit modification and deletion)
