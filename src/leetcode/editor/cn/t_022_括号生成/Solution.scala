package leetcode.editor.cn.t_022_括号生成


//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()(())"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 2803 👎 0

/*
* 解答成功:
	执行耗时:456 ms,击败了70.00% 的Scala用户
	内存消耗:51.7 MB,击败了60.00% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable.ListBuffer
object Solution {
    def generateParenthesis(n: Int): List[String] = {
        /* 方法：回朔 */
        recall(n)
    }

    def recall(n: Int): List[String] = {
        // n = 1直接返回
        if (n == 1) return List("()")
        val rs = new Array[String](2 * n)
        val buffer = new ListBuffer[String]

        recallFunc(0, n, 0, 0, rs, buffer)
        buffer.toList
    }

    /**
     * 处理第i阶段决策
     * @param i 当前处于第几阶段
     * @param n 括号对数
     * @param rLen 左括号个数
     * @param rs 每阶段的决策结果
     * @param buffer 结果集合
     */
    def recallFunc(i: Int, n: Int, lLen: Int, rLen: Int, rs: Array[String], buffer: ListBuffer[String]): Unit = {
        if (i == 2 * n) {
            buffer.append(rs.mkString(""))
            return
        }
        // 决策1：当前层放入左括号，左括号放入前不允许超过限定的对数
        if (lLen < n) {
            rs(i) = "("
            recallFunc(i + 1, n, lLen + 1, rLen, rs, buffer)
        }

        // 决策2：当前层放入右括号，需要确保还有可配对的左括号
        if (lLen > rLen) {
            rs(i) = ")"
            recallFunc(i + 1, n, lLen, rLen + 1, rs, buffer)
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
