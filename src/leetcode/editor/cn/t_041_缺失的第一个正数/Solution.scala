package leetcode.editor.cn.t_041_缺失的第一个正数
//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为 
//O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 数组 哈希表 👍 1972 👎 0

/**
 * 解答成功:
 * 执行耗时:708 ms,击败了33.33% 的Scala用户
 * 内存消耗:79.5 MB,击败了33.33% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def firstMissingPositive(nums: Array[Int]): Int = {
        // 利用元素数组作为hash表
        val len = nums.length
        // step1: 将所有大于len及小于等于0的数标记为len+1
        for (i <- nums.indices if nums(i) > len || nums(i) <= 0) nums(i) = len + 1
        // step2: 为对应位置的元素的值标记为负数
        for (i <- nums.indices if math.abs(nums(i)) <= len) nums(math.abs(nums(i)) - 1) = -math.abs(nums(math.abs(nums(i)) - 1))
        // step3: 遇到的第一个负数则直接返回
        for (i <- nums.indices if nums(i) > 0) return i + 1
        len + 1
    }

    // 该方案时间复杂度不符合需求
    def method1(nums: Array[Int]): Int = {
        val len = nums.length

        /**
         * 基本思路：
         * 要找到缺失的整数，可以将现有数组中的每一个正整数都放到对应的位置(大于数组长度的数字（若存在大于数组长度的数，则说明现有数组中一定缺少1~len中的某一个和多个）
         * 和小于等于0的数字无需处理)，
         * 比如[-1, 2, 3, 5]处理完成后应该为[-1, 2, 3, 5]，当处理完成后，再遍历一次数组，若第i处(从0开始)元素不等于i+1，那么就说明缺少i+1，
         * 若遍历后发现所有元素都满足，则说明缺少的最小整数应该为长度+1。
         *
         * 如何将对应的元素放到对应位置？
         * 正确的元素顺序应该为1开始，然后依次排列。故当遍历到某个元素时，若当前元素应该放到的位置与当前位置不符，那么我们就去查找其理论放置元素的值，若
         * 该值小于0或者大于len，那么我们可以直接赋值；若该值也是一个合法值且与理论位置不符，那么我们按照上一轮思路继续处理，知道元素理论和实际位置一致。基于该理论，举个
         * 栗子，假设当前元数组为[-1,3,4,2]:
         * 第一轮: 3理论放置到i=2位置, 但当前i=2的值为4，属于合法值, 那么先将i=2放置为3，我们继续处理4，此时数组为[-1,3,3,2]
         * 第二轮：4理论放置与i=3位置，但当前i=3的值为2，属于合法值，那么先将i=3放置为4，我们继续处理2，此时数组为[-1,3,3,4]
         * 第三轮：2理论放置与i=1位置，但当前i=1的值为3，属于合法值，那么先将i=1放置为2，我们继续处理3，此时数组为[-1,2,3,4]
         * 第四轮：3理论放置与i=2位置，且当前i=2的值就是3，那么我们退出循环即可
         */
        for (i <- nums.indices if nums(i) > 0 && nums(i) <= len) {
            val v = nums(i)
            var next = v - 1
            var prev = i
            while (prev != next) {
                val nextV = nums(next)
                nums(next) = next + 1
                prev = next
                if (nextV <= len && nextV > 0) {
                    next = nextV - 1
                }
            }
        }

        for (i <- nums.indices) {
            if (nums(i) != i + 1) return i + 1
        }
        // 若数组中所有皆符合，则返回长度即可
        len + 1
    }
}
//leetcode submit region end(Prohibit modification and deletion)
