package leetcode.editor.cn.t_283_移动零
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2028 👎 0

/**
 * 解答成功:
	执行耗时:608 ms,击败了52.38% 的Scala用户
	内存消耗:55.1 MB,击败了19.05% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def moveZeroes(nums: Array[Int]): Unit = {
        var i, j = 0
        while (i < nums.length) {
            if (nums(i) != 0) {
                nums(j) = nums(i)
                j += 1
            }
            i += 1
        }
        while (j < nums.length) {
            nums(j) = 0
            j += 1
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
