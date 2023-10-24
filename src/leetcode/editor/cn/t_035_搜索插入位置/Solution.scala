package leetcode.editor.cn.t_035_搜索插入位置

import leetcode.editor.cn.utils.Utils._

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 2138 👎 0

/**
 * 解答成功:
	执行耗时:488 ms,击败了100.00% 的Scala用户
	内存消耗:54.2 MB,击败了81.25% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def searchInsert(nums: Array[Int], target: Int): Int = {
        var i = 0
        var j = nums.length - 1

        // 该题等价于寻找第一个大于等于target的值所在的索引
        while (i <= j) {
            val mid = (i + j) >> 1
            val midV = nums(mid)
            if (midV >= target) {
                if (mid == 0 || nums(mid - 1) < target) {
                    return mid
                } else {
                    j = mid - 1
                }
            } else {
                i = mid + 1
            }
        }
        // 未找到时插入到所有元素之后
        nums.length
    }

    def main(args: Array[String]): Unit = {
        println(searchInsert(Array(1, 3, 5, 6), 4))
        println(searchInsert(Array(1, 3, 5, 8, 9), 6))
    }
}
//leetcode submit region end(Prohibit modification and deletion)
