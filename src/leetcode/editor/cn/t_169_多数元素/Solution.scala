package leetcode.editor.cn.t_169_多数元素

import leetcode.editor.cn.utils.Utils._

//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 2022 👎 0

/**
 * 解答成功:
	执行耗时:552 ms,击败了81.48% 的Scala用户
	内存消耗:58.5 MB,击败了74.07% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def majorityElement(nums: Array[Int]): Int = {
        // 方案1: 排序 + 取中位数
        // 方案2: 摩尔投票法
        var ans = 0
        var cnt = 0
        nums.foreach(i => {
            if (cnt == 0) ans = i
            cnt += (if (ans == i) 1 else -1)
        })
        ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)
