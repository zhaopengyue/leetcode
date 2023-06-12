package leetcode.editor.cn.t_049_字母异位词分组
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1504 👎 0


/**
解答成功:
	执行耗时:616 ms,击败了100.00% 的Scala用户
	内存消耗:60.4 MB,击败了86.67% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    val zhishu = Array[Int](2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101)
    // 用doule勉强能过
    val rsMap: mutable.HashMap[Double, mutable.ListBuffer[String]] = new mutable.HashMap()
    val rs = new mutable.ListBuffer[List[String]]
    for (str <- strs) {
        var tmp = 1.0
        for (char <- str) {
            tmp *= zhishu(char - 'a')
        }
        if (!rsMap.contains(tmp)) {
            rsMap += (tmp -> new ListBuffer[String])
        }
        rsMap(tmp) += str
    }
    for ((_, v) <- rsMap) {
        rs += v.toList
    }
    rs.toList
  }
}
//leetcode submit region end(Prohibit modification and deletion)
