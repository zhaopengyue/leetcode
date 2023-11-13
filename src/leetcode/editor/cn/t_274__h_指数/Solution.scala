package leetcode.editor.cn.t_274__h_指数

import leetcode.editor.cn.utils.Utils._

//给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。 
//
// 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次
//。如果 h 有多种可能的值，h 指数 是其中最大的那个。 
//
// 
//
// 示例 1： 
//
// 
//输入：citations = [3,0,6,1,5]
//输出：3 
//解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
//     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。 
//
// 示例 2： 
//
// 
//输入：citations = [1,3,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == citations.length 
// 1 <= n <= 5000 
// 0 <= citations[i] <= 1000 
// 
//
// Related Topics 数组 计数排序 排序 👍 420 👎 0

/**
 * 解答成功:
	执行耗时:488 ms,击败了94.44% 的Scala用户
	内存消耗:54.3 MB,击败了83.33% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def hIndex(citations: Array[Int]): Int = {
        java.util.Arrays.sort(citations)

        var h = 0
        val len = citations.length
        for (i <- citations.indices.reverse) {
            val v = citations(i)
            val num = len - i // 表示大于等于v的元素有num个
            if (v >= num) h = num // 若当前引用数大于等于个数,则记录h为个数,然后向左扩充h
        }
        h
    }
}
//leetcode submit region end(Prohibit modification and deletion)
