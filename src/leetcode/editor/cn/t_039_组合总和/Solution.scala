package leetcode.editor.cn.t_039_组合总和

import leetcode.editor.cn.utils.Utils._

//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// candidates 的所有元素 互不相同 
// 1 <= target <= 40 
// 
//
// Related Topics 数组 回溯 👍 2592 👎 0

/**
 * 解答成功:
	执行耗时:532 ms,击败了90.00% 的Scala用户
	内存消耗:59.2 MB,击败了60.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable.ListBuffer
object Solution {
    def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
        // 先做一个逆序, 方便更快剪枝
        val nums = candidates.sortBy(-_)
        val line = new ListBuffer[Int]()
        val rs = new ListBuffer[List[Int]]()

        dp(0, 0, nums, 0, line, rs, target)

        rs.toList
    }

    def dp(no: Int, curIndex: Int, nums: Array[Int], currSum: Int, line: ListBuffer[Int], rs: ListBuffer[List[Int]], target: Int): Unit = {
        if (no == 150 || currSum > target || curIndex >= nums.length) return // 无结果
        if (currSum == target) {
            rs += line.toList
            return
        }
        // 放自己
        if (currSum + nums(curIndex) <= target) {
            line += nums(curIndex)
            dp(no + 1, curIndex, nums, currSum + nums(curIndex), line, rs, target)
            // 退出时清错本次状态
            line.remove(line.length - 1)
        }
        // 不放自己
        dp(no, curIndex + 1, nums, currSum, line, rs, target)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
