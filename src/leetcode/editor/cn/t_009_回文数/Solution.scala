package leetcode.editor.cn.t_009_回文数
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
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
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics 数学 👍 2126 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  def isPalindrome(x: Int): Boolean = {
    // 负数一定不是回文数
    if (x < 0) {
      return false
    }
    /* 方法1：转化为字符串后通过双指针方式解决
    val xS = x.toString
    if (xS.length <= 1) return true
    // 转化为字符串，采用双指针
    var i = 0
    var j = xS.length - 1
    while (i <= j) {
      if (xS.charAt(i) != xS.charAt(j)) {
        return false
      }
      i += 1
      j -= 1
    }
    true
     */
    /*
    * 方法2：通过逆向计算然后比较计算结果来判断
    * */
    var rs = 0
    var temp = x
    while (temp != 0) {
      // 获取最后一位并计算和
      rs = rs * 10 + temp % 10
      temp = temp / 10
    }
    rs == x
  }
}
//leetcode submit region end(Prohibit modification and deletion)
