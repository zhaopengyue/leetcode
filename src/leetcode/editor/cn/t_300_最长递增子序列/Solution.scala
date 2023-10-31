package leetcode.editor.cn.t_300_最长递增子序列
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2：  n
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics 数组 二分查找 动态规划 👍 2740 👎 0

/**
 * 解答成功:
	执行耗时:500 ms,击败了100.00% 的Scala用户
	内存消耗:54.5 MB,击败了100.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def lengthOfLIS(nums: Array[Int]): Int = {

        // tail是一个非递减数组，其中tail[k]表示递增子序列长度为k+1的末尾元素值
        // eg: 对于tail=[1,3,5]中的tail[2]=5表示递增子序列长度为3的元素的末尾值为5
        val tail = new Array[Int](nums.length)
        var res = 0

        nums.foreach(v => {
            var l = 0
            var r = res
            // 寻找第一个大于等于v的值
            while (l < r) {
                val m = (l + r) >> 1
                if (tail(m) < v) l = m + 1 else r = m
            }
            tail(l) = v
            if (l == res) res += 1
        })

        res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
