package leetcode.editor.cn.t_383_赎金信

import leetcode.editor.cn.utils.Utils._

//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 821 👎 0

/**
 * 解答成功:
 * 执行耗时:524 ms,击败了85.71% 的Scala用户
 * 内存消耗:54.6 MB,击败了85.71% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def canConstruct(ransomNote: String, magazine: String): Boolean = {
        val arr = new Array[Int](26)
        magazine.foreach(c => arr(c - 'a') += 1)

        ransomNote.foreach(c => {
            if (arr(c - 'a') == 0) return false
            arr(c - 'a') -= 1
        })
        true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
