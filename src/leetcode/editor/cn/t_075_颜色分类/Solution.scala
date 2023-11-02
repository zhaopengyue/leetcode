package leetcode.editor.cn.t_075_颜色分类

import leetcode.editor.cn.utils.Utils._

//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1685 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def sortColors(nums: Array[Int]): Unit = {
        // 基于双指针处理
       var p0 = 0
       var p1 = 0

       for (i <- nums.indices) {
           val v = nums(i)

           if (v == 1) {
               swap(nums, i, p1)
               p1 += 1
           } else if (v == 0) {
               swap(nums, i, p0)
               if (p0 < p1) {
                   swap(nums, p1, i)
               }
               p0 += 1
               p1 += 1
           }
       }
    }

    private def swap(nums: Array[Int], i: Int, j: Int): Unit = {
        val tmp = nums(i)
        nums(i) = nums(j)
        nums(j) = tmp
    }
}
//leetcode submit region end(Prohibit modification and deletion)
