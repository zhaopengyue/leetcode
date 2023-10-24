package leetcode.editor.cn.t_131_分割回文串

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1615 👎 0

/**
 * 解答成功:
	执行耗时:852 ms,击败了100.00% 的Scala用户
	内存消耗:84.1 MB,击败了83.33% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable.ListBuffer

object Solution {
  def partition(s: String): List[List[String]] = {
    val status = getStatus(s)
    val rs = new ListBuffer[List[String]]()
    dp(0, s, status, new ListBuffer[String](), rs)
    rs.toList
  }

  // 递归处理从i开始的子串
  private def dp(i: Int, s: String, status: Array[Array[Boolean]], item: ListBuffer[String], res: ListBuffer[List[String]]): Unit = {
    if (i == s.length) {
      res += item.toList
      return
    }

    for (j <- i until s.length) {
      if (status(i)(j)) {
        item += s.substring(i, j + 1)
        dp(j + 1, s, status, item, res)
        item.remove(item.length - 1)
      }
    }

  }

  /**
   * 获取字符串s对应的回文串的状态列表. 状态列表定义如下:
   * status[i][j]: 表示s的子串s[i:j]是否回文, 1-回文, 0-非回文
   * 其中status[i][j]的动态规范方程为:
   * status[i][j] =
   *  1. 0                                       i > j
   *  2. status[i+1][j-1] && s[i] == s[j]        i <= j
   *     初始时status[i][i]一定为true
   *
   * @param s 待计算状态字符串
   * @return
   */
  private def getStatus(s: String): Array[Array[Boolean]] = {
    val status = new Array[Array[Boolean]](s.length)
    // 初始化状态
    for (i <- 0 until s.length) {
      status(i) = new Array[Boolean](s.length)
      status(i)(i) = true
      if (i < s.length - 1) {
        status(i)(i + 1) = s.charAt(i) == s.charAt(i + 1)
      }
    }

    // 计算状态
    for (i <- (0 until s.length - 2).reverse) {
      for (j <- i + 2 until s.length) {
        status(i)(j) = status(i + 1)(j - 1) && s.charAt(i) == s.charAt(j)
      }
    }

    status
  }
}
//leetcode submit region end(Prohibit modification and deletion)
