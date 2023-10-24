package leetcode.editor.cn.t_033_搜索旋转排序数组
//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 2282 👎 0

/**
 * 解答成功:
	执行耗时:484 ms,击败了85.71% 的Scala用户
	内存消耗:54.3 MB,击败了57.14% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def search(nums: Array[Int], target: Int): Int = {
      var i = 0
      var j = nums.length - 1

      while (i <= j) {
        val mid = (i + j) >> 1
        val midV = nums(mid)

        if (midV == target) return mid

        if (midV < nums(0)) {
          // 0 ~ mid为无序区间, mid~nums(j)为有序区间
          if (target > midV && target >= nums(0)) {
            j = mid - 1
          } else if (target > midV && target < nums(0)) {
            i = mid + 1
          } else {
            // target < midV < nums(0), 只能有左侧最大值~mid之间
            j = mid - 1
          }
        } else {
          // 0~mid为有序区间, mid~nums(j)可能为无序区间
          if (target < midV && target >= nums(0)) {
            j = mid - 1
          } else if (target < midV && target < nums(0)) {
            i = mid + 1
          } else {
            // target > midV >= num(0)
            i = mid + 1
          }
        }
      }
      -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)
