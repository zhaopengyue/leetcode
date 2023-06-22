package leetcode.editor.cn.t_560_和为_k_的子数组
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
//
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 x
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 1950 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  def subarraySum(nums: Array[Int], k: Int): Int = {
    /* */
    var res = 0
    // 计算前缀和
    val pre = new Array[Int](nums.length)
    pre(0) = nums(0)
    var i = 1
    while (i < nums.length) {
      pre(i) = pre(i-1) + nums(i)
      i += 1
    }

    for (i <- nums.indices) {
      for (j <- 0 until i) {
        if (pre(j) + k == pre(i)) {
          res += 1
        }
      }
    }

    res
  }

  def main(args: Array[String]): Unit = {
    subarraySum(Array(1, 1, 1), 2)
  }
}
//leetcode submit region end(Prohibit modification and deletion)
