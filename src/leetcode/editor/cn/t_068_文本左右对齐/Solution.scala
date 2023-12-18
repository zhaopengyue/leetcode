package leetcode.editor.cn.t_068_文本左右对齐

import leetcode.editor.cn.utils.Utils._

//给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
//
// 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
// 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 注意: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: words = ["This", "is", "an", "example", "of", "text", "justification."], 
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 
//输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 
//输入:words = ["Science","is","what","we","understand","well","enough","to",
//"explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 2
//0
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= words.length <= 300 
// 1 <= words[i].length <= 20 
// words[i] 由小写英文字母和符号组成 
// 1 <= maxWidth <= 100 
// words[i].length <= maxWidth 
// 
//
// Related Topics 数组 字符串 模拟 👍 390 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable.ListBuffer

/**
 * 解答成功:
 * 执行耗时:480 ms,击败了100.00% 的Scala用户
 * 内存消耗:53.9 MB,击败了100.00% 的Scala用户
 */
object Solution {
    def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
        val rs = new ListBuffer[String]

        var startI = 0
        while (startI < words.length) {
            var wordLen = 0
            var endI = startI - 1

            while (endI + 1 < words.length && ((endI + 1 - startI) + wordLen + words(endI + 1).length) <= maxWidth) {
                endI += 1
                wordLen += words(endI).length
            }

            val lineBuffer = new StringBuffer()
            if (endI == words.length - 1) {
                // 最后一行
                lineBuffer.append((startI to endI).map(i => words(i)).mkString(" "))
                if (lineBuffer.length() < maxWidth) {
                    lineBuffer.append(" " * (maxWidth - lineBuffer.length())) // 补全缺失的空格
                }
            } else {
                // 计算需要空格数
                val needSpaceNum = maxWidth - wordLen
                val spaceCount = endI - startI
                if (spaceCount == 0) {
                    // 仅有一个单词
                    lineBuffer.append(words(startI) + " " * needSpaceNum)
                } else {
                    val avgSpaceLen = needSpaceNum / spaceCount
                    val remainSpaceLen = needSpaceNum % spaceCount
                    // 构建分配数组
                    val spaceNumArr = Array.fill(spaceCount)(avgSpaceLen)
                    // 将余数分配给前n个
                    (0 until remainSpaceLen).foreach(i => spaceNumArr(i) += 1)
                    // 第一个单词
                    lineBuffer.append(words(startI))
                    (0 until spaceCount).foreach(i => {
                        lineBuffer.append(" " * spaceNumArr(i))
                        lineBuffer.append(words(startI + i + 1))
                    })
                }
            }
            rs += lineBuffer.toString
            startI = endI + 1
        }

        rs.toList
    }
}
//leetcode submit region end(Prohibit modification and deletion)
