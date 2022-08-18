package leetcode.editor.cn.t_072_编辑距离
//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 2538 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  def minDistance(word1: String, word2: String): Int = {
    if (word1.isEmpty) return word2.length
    if (word2.isEmpty) return word1.length
    /*
    * 初始化状态数组
    * 状态数组dp[i][j]表示要使字符子串[0:i]和[0:j]相同需要的最小编辑距离
    * */
    val dp = Array.fill(word1.length, word2.length)(0)
    // step1:初始化状态数组
    dp(0)(0) = if (word1.charAt(0) == word2.charAt(0)) 0 else 1
    // 1.A 初始化行: 表示要将word2(0)转化为word1[0~i]需要的编辑次数
    for (i <- 1 until word1.length) {
      dp(i)(0) = {
        // 若一致，为保证相同，则将该元素之前的全部删除；若不一致，则采用添加或删除方式来保持一致，即上一个编辑距离+1
        if (word1.charAt(i) == word2.charAt(0)) i else dp(i - 1)(0) + 1
      }
    }
    // 1.B 初始化列
    for (j <- 1 until word2.length) {
      dp(0)(j) = {
        if (word2.charAt(j) == word1.charAt(0)) j else dp(0)(j - 1) + 1
      }
    }
    // step2: 按照递归公式处理
    for (i <- 1 until word1.length) {
      for (j <- 1 until word2.length) {
        if (word1.charAt(i) == word2.charAt(j)) {
          dp(i)(j) = Array(
            dp(i - 1)(j - 1), // 无需处理
            dp(i - 1)(j) + 1, // 删除word1[i]
            dp(i)(j - 1) + 1 // 删除word2[j]
          ).min
        } else {
          dp(i)(j) = Array(
            dp(i - 1)(j - 1) + 1, // 替换
            dp(i - 1)(j) + 1, // 删除word1[i]
            dp(i)(j - 1) + 1 // 删除word2[j]
          ).min
        }
      }
    }
    dp(word1.length - 1)(word2.length - 1)
  }
}
//leetcode submit region end(Prohibit modification and deletion)
