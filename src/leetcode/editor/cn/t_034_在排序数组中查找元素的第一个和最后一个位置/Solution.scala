package leetcode.editor.cn.t_034_在排序数组中查找元素的第一个和最后一个位置

import leetcode.editor.cn.utils.Utils._

//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2455 👎 0

/**
 * 解答成功:
	执行耗时:540 ms,击败了42.86% 的Scala用户
	内存消耗:57 MB,击败了19.05% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.util.control.Breaks
object Solution {
    def searchRange(nums: Array[Int], target: Int): Array[Int] = {
        // 查找第一个等于target的值
        var i = 0
        var j = nums.length - 1
        val loop = new Breaks()
        var firstIndex = -1

        loop.breakable {
            while (i <= j) {
                val mid = (i + j) >> 1
                val midV = nums(mid)

                if (midV == target) {
                    if (mid == 0 || nums(mid - 1) < target) {
                        firstIndex = mid
                        loop.break()
                    } else {
                        j = mid - 1
                    }
                } else if (midV < target) {
                    i = mid + 1
                } else {
                    j = mid - 1
                }
            }
        }

        if (firstIndex == -1) return Array(-1, -1)

        // 从前向后遍历
        var endIndex = firstIndex
        for (end <- firstIndex until nums.length if nums(end) == target) {
            endIndex = end
        }
        Array(firstIndex, endIndex)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
