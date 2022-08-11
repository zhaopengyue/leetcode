package leetcode.editor.cn.t_017_电话号码的字母组合

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2048 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable.ListBuffer
object Solution {

  def letterCombinations(digits: String): List[String] = {
    // 长度为空, 直接返回
    if (digits.isEmpty) return List.empty[String]

    val numMap = Map(
      '2' -> List("a", "b", "c"),
      '3' -> List("d", "e", "f"),
      '4' -> List("g", "h", "i"),
      '5' -> List("j", "k", "l"),
      '6' -> List("m", "n", "o"),
      '7' -> List("p", "q", "r", "s"),
      '8' -> List("t", "u", "v"),
      '9' -> List("w", "x", "y", "z")
    )

    // 长度为1, 直接返回本身
    if (digits.length == 1) return numMap(digits.charAt(0))

    val rs = new Array[String](digits.length)
    val buffer = new ListBuffer[String]()
    select(digits, 0, numMap, rs, buffer)
    buffer.toList
  }

  /*
  * 基于回溯思想，递归每一层处理一个字符，穷举出所有组合
  * */
  private def select(digits: String, index: Int, numMap: Map[Char, List[String]], rs: Array[String], buffer: ListBuffer[String]): Unit = {
    // 递归终止条件
    if (index == digits.length) {
      buffer += rs mkString ""
      return
    }
    for (str <- numMap(digits.charAt(index))) {
      // 将当前层赋值为当前字符
      rs(index) = str
      // 处理下一层
      select(digits, index + 1, numMap, rs, buffer)
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
