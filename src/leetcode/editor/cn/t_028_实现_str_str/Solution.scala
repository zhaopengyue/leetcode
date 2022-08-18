package leetcode.editor.cn.t_028_实现_str_str
//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 1548 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def strStr(haystack: String, needle: String): Int = {
        if (needle.isEmpty) return 0
        if (needle.length == 1) {
            for (i <- haystack.zipWithIndex) {
                if (i._1.toString == needle) {
                    return i._2
                }
            }
            return -1
        }
        // 多余1位的计算基于KMP算法寻找
        val next = getNext(needle)
        var i = 0
        var j = 0
        while (i < haystack.length && j < needle.length) {
            // j为-1时，表示子串需要重头开始匹配
            if (j == -1 || haystack.charAt(i) == needle(j)) {
                i += 1
                j += 1
            } else {
                // i不变, j回溯至上一个位置
                j = next(j)
            }
        }
        if (j == needle.length) i - j else -1
    }

    // 计算next数组
    def getNext(needle: String): Array[Int] = {
        var i = 1
        var j = 0
        val next: Array[Int] = new Array[Int](needle.length)
        next(0) = -1
        while (i < needle.length - 2) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next(j)
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j += 1
            }
            i += 1
            next(i) = j
        }
        next
    }
}
//leetcode submit region end(Prohibit modification and deletion)
