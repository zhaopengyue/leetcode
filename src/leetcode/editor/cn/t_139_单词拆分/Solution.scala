package leetcode.editor.cn.t_139_单词拆分
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2327 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {

    def wordBreak(s: String, wordDict: List[String]): Boolean = {
        // 构建dict
        val wordMap = wordDict.toSet

        // status[i]表示[0~i)的字符串是否可拆分
        val status = Array.fill(s.length + 1)(false)

        // 确保s[0:1]经过了wordDict判断
        status(0) = true

        for (i <- 1 to s.length) {
            var isBreak = false
            for (j <- (0 until i).reverse if ! isBreak) {
                if (wordMap.contains(s.substring(j, i)) && status(j)) {
                    status(i) = true
                    // 表示0~i已经可以拆分为单词了，则结束当前i
                    isBreak = true
                }
            }
        }

        status(s.length)

    }
}
//leetcode submit region end(Prohibit modification and deletion)
