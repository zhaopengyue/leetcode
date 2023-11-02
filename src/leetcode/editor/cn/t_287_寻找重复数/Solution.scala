package leetcode.editor.cn.t_287_寻找重复数

import leetcode.editor.cn.utils.Utils._

//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。 
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
//
// Related Topics 位运算 数组 双指针 二分查找 👍 2284 👎 0

/**
 * 解答成功:
	执行耗时:756 ms,击败了100.00% 的Scala用户
	内存消耗:81.7 MB,击败了100.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def findDuplicate(nums: Array[Int]): Int = {

        // 参考循环链表建立映射 i -> nums[i]
        var slow = 0
        var fast = 0
        // step1: 先判断是否有环(本题一定有)
        // 长度为n的数组中最大元素值为n-1,故下述数组不会越界
        /*
         为啥i->num[i]不会产生自循环？
         如果x在第x上的话，指针永远不会访问到它.( 只有它自己能读到自己), 像 [3, 1, 4, 2, 2]这里面的1，
         快指针的走法为fast = nums[nums[fast]], 慢指针为 slow = nums[slow], 快慢指针在遇到第一个3的时候，就会跑到第三个数字(2)上去了，
         1是不会被访问到的
         */
        do {
            slow = nums(slow)
            fast = nums(nums(fast))
        } while (nums(slow) != nums(fast))

        var p = 0

        while (nums(slow) != nums(p)) {
            slow = nums(slow)
            p = nums(p)
        }

        nums(p)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
