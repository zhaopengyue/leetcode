package leetcode.editor.cn.t_003_无重复字符的最长子串

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 7893 👎 0

/*
* 优化方案后map解法
* 解答成功:
	执行耗时:528 ms,击败了65.00% 的Scala用户
	内存消耗:52.9 MB,击败了85.00% 的Scala用户
	*
* 优化方案后数组解法
* 解答成功:
	执行耗时:508 ms,击败了86.67% 的Scala用户
	内存消耗:52.5 MB,击败了95.00% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
import scala.util.control._

object Solution {
    /*
    解答成功:
      执行耗时:600 ms,击败了21.67% 的Scala用户
      内存消耗:53.1 MB,击败了68.33% 的Scala用户
    该方案可以进一步简化，即没有必要删除map中重复字符前的下标，同时可以用数组替换hash表
    def lengthOfLongestSubstring(s: String): Int = {
        if (s.isEmpty) {
            return 0
        }
        if (s.length == 1) {
            return 1
        }
        // key为字符, value为该元素的索引
        val charMap = new mutable.LinkedHashMap[Char, Int]()
        // 将第一位存储map，作为初始序列
        charMap.put(s.charAt(0), 0)
        // 当前记录的非重复子串的开始下标
        var i = 0
        // 正在遍历的字符的下标
        var j = 1
        var maxLen = 1

        while (j <= s.length - 1) {
            val currChar = s.charAt(j)
            // 计算当前长度
            // 当前字符在子串中存在，先计算下目前的子串的最大长度
            if (charMap.contains(currChar)) {
                maxLen = Math.max(maxLen, j - i)
                // 获取重复字符对应的下标
                val repeatCharIndex = charMap(currChar)
                // 移除该下标及其之前的所有元素
                val loop = new Breaks
                loop.breakable {
                    for ((k, v) <- charMap) {
                        charMap.remove(k)
                        if (v == repeatCharIndex) {
                            loop.break()
                        }
                    }
                }
                // 将新的非重复子串的开始索引赋值为重复字符下标+1
                i = repeatCharIndex + 1
            } else {
                maxLen = Math.max(maxLen, j - i + 1)
            }
            charMap.put(currChar, j)
            j += 1
        }
        maxLen
    }*/

    // 优化版
    def lengthOfLongestSubstring(s: String): Int = {
        if (s.isEmpty) {
            return 0
        }
        if (s.length == 1) {
            return 1
        }
        // 使用数组替换，并初始化值为-1
        //val charMap = new mutable.HashMap[Char, Int]()
        val charMap = Array.fill(128)(-1)
        // 将第一位存储map，作为初始序列
        charMap(s.charAt(0)) = 0
        //charMap.put(s.charAt(0), 0)
        // 当前记录的非重复子串的开始下标
        var i = 0
        // 正在遍历的字符的下标
        var j = 1
        var maxLen = 1

        while (j <= s.length - 1) {
            val currChar = s.charAt(j)
            // 获取重复字符对应的下标, 不存在为-1
            //val repeatCharIndex = charMap.getOrElse(currChar, -1)
            val repeatCharIndex = charMap(currChar)
            // 若当前字符存在，且下标位于i~j-1中，则说明重复了，可以计算下目前的子串的最大长度
            if (repeatCharIndex >= i) {
                maxLen = Math.max(maxLen, j - i)
                // 将新的非重复子串的开始索引赋值为重复字符下标+1
                i = repeatCharIndex + 1
            } else {
                maxLen = Math.max(maxLen, j - i + 1)
            }
            // 将当前字符放入
            //charMap.put(currChar, j)
            charMap(currChar) = j
            j += 1
        }
        maxLen
    }
}
//leetcode submit region end(Prohibit modification and deletion)