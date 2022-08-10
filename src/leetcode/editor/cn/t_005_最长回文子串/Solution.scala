package leetcode.editor.cn.t_005_最长回文子串

//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 5498 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  def longestPalindrome(s: String): String = {
    /*
    * 计算状态数组分为三步：
    * 1. 构建一个二维动态数组,然后定义status[x][y]=z表示子串[x:y]，z==1表示为回文子串，z==0表示非回文子串
    * 2. 确定状态转换方程：基本思想为若子串[x:y]为回文子串，则若s[x-1] == s[y+1]，则[x-1:y+1]也为回文子串.
    * 3. 确定初始值：a. 子串只有一个字符(x==y)时，其一定是回文的。 b 子串只有两个字符时，若s[x]==s[y]，则其一定是回文的，否则不是回文
    * 如何根据状态数组确定最长回文子串：
    * 构建的时候每次都记录当前记录到的最大的子串的开始和技术索引
    * */
    if (s.length <= 1) {
      return s
    }
    if (s.length == 2) {
      return String.valueOf(if (s.charAt(0) == s.charAt(1)) s else s(0))
    }
    val status = Array.fill(s.length, s.length)(false)

    var maxI = 0
    var maxLen = 1
    /* 初始化开始 */
    for (i <- 0 until s.length - 1) {
      // 本身必定回文，且长度为1
      status(i)(i) = true
      // 两个字符仅需要比较元素是否相同
      if (s.charAt(i) == s.charAt(i + 1)) {
        status(i)(i + 1) = true
        maxLen = 2
        maxI = i
      }
    }
    status(s.length - 1)(s.length - 1) = true
    /* 初始化结束 */
    for (i <- (0 until s.length - 2).reverse) {
      for (j <- i + 2 until s.length) {
        val lastStatusV = status(i+1)(j-1)
        // i == j, 且上一状态为回文子串
        if (s.charAt(i) == s.charAt(j) && lastStatusV) {
          status(i)(j) = true
          // 计算新长度
          val newLen = j - i + 1
          if (newLen > maxLen) {
            maxLen = newLen
            maxI = i
          }
        } else {
          status(i)(j) = false
        }
      }
    }

    //for (line <- status) {
    //  for (s <- line) {
    //    print(s"$s ")
    //  }
    //  println()
    //}
    s.substring(maxI, maxI + maxLen)
  }
}
//leetcode submit region end(Prohibit modification and deletion)
