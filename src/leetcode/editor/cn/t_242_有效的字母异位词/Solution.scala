package leetcode.editor.cn.t_242_有效的字母异位词

import leetcode.editor.cn.utils.Utils._

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 874 👎 0

/**
 * 解答成功:
 * 执行耗时:532 ms,击败了78.57% 的Scala用户
 * 内存消耗:54.1 MB,击败了85.71% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def isAnagram(s: String, t: String): Boolean = {
        if (s.length != t.length) return false
        val arr = new Array[Int](26)
        s.foreach(c => arr(c-'a') += 1)
        t.foreach(c => arr(c-'a') -= 1)
        arr.foreach(i => if (i != 0) return false)
        true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
