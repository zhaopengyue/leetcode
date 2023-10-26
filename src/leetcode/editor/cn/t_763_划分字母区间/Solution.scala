package leetcode.editor.cn.t_763_划分字母区间
//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。 
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。 
//
// 返回一个表示每个字符串片段的长度的列表。 
//
// 
//示例 1：
//
// 
//输入：s = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
//
// 示例 2： 
//
// 
//输入：s = "eccbbbbdec"
//输出：[10]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 1045 👎 0

/**
 * 解答成功:
 * 执行耗时:508 ms,击败了100.00% 的Scala用户
 * 内存消耗:54.5 MB,击败了100.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
object Solution {
    def partitionLabels(s: String): List[Int] = {
        val map = new mutable.HashMap[Char, Array[Int]]()
        val rs = new ListBuffer[Int]
        // 计算每个字符串的开始和结束位置
        s.zipWithIndex.foreach(item => {
            val c = item._1
            val i = item._2
            if (! map.contains(c)) {
                map += (c -> Array(i, i))
            } else {
                map(c)(1) = i
            }
        })

        var currLeft = 0
        var currRight = 0
        s.foreach(c => {
            val cLeft = map(c)(0)
            val cRight = map(c)(1)

            // 若边界无交叉, 则当前字符作为新左边界
            if (cLeft > currRight) {
                rs += (currRight - currLeft + 1)
                currLeft = map(c)(0)
                currRight = map(c)(1)
            } else if (cRight > currRight) {
                // 若边界有交叉, 则向右扩充右边界
                currRight = cRight
            }
        })

        // 将最后一部分填入
        rs += (currRight - currLeft + 1)

        rs.toList
    }
}
//leetcode submit region end(Prohibit modification and deletion)
