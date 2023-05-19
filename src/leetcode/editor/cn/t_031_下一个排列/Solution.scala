package leetcode.editor.cn.t_031_下一个排列
//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排re为字典序最小的排列（即，其元素按升序排列）。
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 双指针 👍 1868 👎 0

/*
* 解答成功:
	执行耗时:512 ms,击败了71.43% 的Scala用户
	内存消耗:53.5 MB,击败了14.29% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def nextPermutation(nums: Array[Int]): Unit = {
        if (nums.length == 1) return
        var i = nums.length - 2
        var isBreak = false
        // 从后往前寻找第一个升序序列，循环后i的位置即为尽可能大的小数
        while (i >= 0 && ! isBreak) {
            if (nums(i) < nums(i + 1)) {
                isBreak = true
            } else {
                i -= 1
            }
        }
        if (isBreak) {
            // 找到升序队列
            // i+1到nums.length-1的序列皆为降序，在该序列中寻找尽可能小的大数
            var j = nums.length - 1
            isBreak = false
            while (j >= i + 1 && ! isBreak) {
                if (nums(j) > nums(i)) {
                    isBreak = true
                } else {
                    j -= 1
                }
            }
            // 交换i和j
            swap(nums, i, j)
        }
        // 未找到升序队列，说明本身即为降序队列，直接反转即可
        // 交换后的j后续的元素[i+1:nums.length-1]仍然为降序，这里进行反转（处理为升序），
        reverse(nums, i + 1, nums.length - 1)
    }

    def swap(nums: Array[Int], i: Int, j: Int): Unit = {
        val tmp = nums(i)
        nums(i) = nums(j)
        nums(j) = tmp
    }

    def reverse(nums: Array[Int], i: Int, j: Int): Unit = {
        var ti = i
        var tj = j
        while (ti < tj && ti <= j && tj >= i) {
            swap(nums, ti, tj)
            ti += 1
            tj -= 1
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
