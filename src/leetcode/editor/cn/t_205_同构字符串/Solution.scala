package leetcode.editor.cn.t_205_同构字符串

import leetcode.editor.cn.utils.Utils._

//给定两个字符串 s 和 t ，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s 和 t 由任意有效的 ASCII 字符组成 
// 
//
// Related Topics 哈希表 字符串 👍 681 👎 0

/**
 * 解答成功:
 * 执行耗时:540 ms,击败了50.00% 的Scala用户
 * 内存消耗:54.6 MB,击败了50.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
object Solution {
    def isIsomorphic(s: String, t: String): Boolean = {
        val numArr = new Array[Int](s.length)
        val map = mutable.HashMap[Char, Int]() // 记录每个字符的编号
        var startNum = 0
        for (i <- s.indices) {
            val c = s.charAt(i)
            val num = {
                if (map.contains(c)) map(c) else {
                    startNum += 1
                    startNum
                }
            }
            map += (c -> num)
            numArr(i) = num
        }
        startNum = 0
        map.clear()
        // 开始计算t的arr
        for (i <- t.indices) {
            val c = t.charAt(i)
            val num = {
                if (map.contains(c)) map(c) else {
                    startNum += 1
                    startNum
                }
            }
            map += (c -> num)
            if (num != numArr(i)) return false
        }

        true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
