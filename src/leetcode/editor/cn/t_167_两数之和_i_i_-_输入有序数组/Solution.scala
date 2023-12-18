package leetcode.editor.cn.t_167_两数之和_i_i__输入有序数组

import leetcode.editor.cn.utils.Utils._

//给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这
//两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.
//length 。 
//
// 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。 
//
// 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。 
//
// 你所设计的解决方案必须只使用常量级的额外空间。 
//
// 示例 1： 
//
// 
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。 
//
// 示例 2： 
//
// 
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
//解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。 
//
// 示例 3： 
//
// 
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
//解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 3 * 10⁴ 
// -1000 <= numbers[i] <= 1000 
// numbers 按 非递减顺序 排列 
// -1000 <= target <= 1000 
// 仅存在一个有效答案 
// 
//
// Related Topics 数组 双指针 二分查找 👍 1159 👎 0

/**
 * 解答成功: 二分法
 * 执行耗时:548 ms,击败了50.00% 的Scala用户
 * 内存消耗:56.6 MB,击败了60.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
        var i = 0
        var j = numbers.length - 1
        while (i <= j) {
            val sum = numbers(i) + numbers(j)
            if (sum == target) return Array(i + 1, j + 1)
            if (sum < target) {
                // 左边太小, 寻找第一个大于等于的索引, 以便于缩减左边界
                i = findFirstGeIndex(numbers, i, j - 1, numbers(j), target)
            } else {
                // 右边太大, 寻找最后一个小于等于的索引, 尽可能缩减右边界
                j = findLastLeIndex(numbers, i + 1, j, numbers(i), target)
            }
        }
        Array(-1, -1)
    }

    /**
     * 寻找第一个大于等于target的值
     */
    private def findFirstGeIndex(nums: Array[Int], start: Int, end: Int, currInt: Int, target: Int): Int = {
        var i = start
        var j = end
        while (i <= j) {
            val mid = (i + j) >> 1
            val currSum = currInt + nums(mid)
            if (currSum >= target) {
                if (mid == start || currInt + nums(mid - 1) < target) {
                    return mid
                } else {
                    j = mid - 1
                }
            } else {
                i = mid + 1
            }
        }
        -1
    }

    private def findLastLeIndex(nums: Array[Int], start: Int, end: Int, currInt: Int, target: Int): Int = {
        var i = start
        var j = end
        while (i <= j) {
            val mid = (i + j) >> 1
            val currSum = currInt + nums(mid)
            if (currSum <= target) {
                if (mid == end || currInt + nums(mid + 1) > target) {
                    return mid
                } else {
                    i = mid + 1
                }
            } else {
                j = mid - 1
            }
        }
        -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)
