package leetcode.editor.cn.t_016_最接近的三数之和
//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1214 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    val orderNums = nums.sorted
    var min = Int.MaxValue
    var minSum = 0

    var k = 0
    // k 最大为倒数第三个元素
    while (k < orderNums.length - 2) {
      // 将k定义为target左边的数值
      var i = k + 1
      var j = orderNums.length - 1
      while (i < j) {
        // 计算加和及差距
        val sum = orderNums(i) + orderNums(j) + orderNums(k)
        val diff = target - sum
        val diffAbs = Math.abs(diff)
        if (diffAbs < min) {
          min = diffAbs
          minSum = sum
        }
        if (diff > 0) {
          i += 1
        } else {
          j -= 1
        }
      }
      k += 1
    }
    minSum
  }
}
//leetcode submit region end(Prohibit modification and deletion)
