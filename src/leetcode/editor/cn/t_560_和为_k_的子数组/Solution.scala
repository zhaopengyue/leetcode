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
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 1952 👎 0

/*
* 解答成功:
  执行耗时:644 ms,击败了71.43% 的Scala用户
  内存消耗:60.5 MB,击败了14.29% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
object Solution {
    def subarraySum(nums: Array[Int], k: Int): Int = {
        // 构建pre数组, 定义pre[i]为[0.....i]元素的和

        var res = 0

        /*
        * 根据逻辑, 若要满足[j....i]的元素之和为(0<=j<=i), 即要满足:
        * pre[i] - pre[j-1] = k // 注: pre[j]包含nums[j], 故此处使用pre[j-1]
        * 移项后: pre[j-1] = pre[i] - k
        * */

        /* =========================前缀和的非优化算法, 复杂度O(n^2)===================== */
/*        val pre = new Array[Int](nums.length)
        // 始化pre数组
        pre(0) = nums(0)
        for (i <- 1 until nums.length) {
            pre(i) = pre(i-1) + nums(i)
        }

        for (i <- nums.indices) {
            for (j <- 0 to i) {
                var preNum = 0
                if (j > 0) {
                    preNum = pre(j-1)
                }
                if (preNum == pre(i) - k) {
                    res += 1
                }
            }
        }*/
        /* 前缀和基于hash优化 */
        // 含义为: pre为k的元素有多少个
        val preMap = new mutable.HashMap[Int, Int]()

        // 初始化意义表示pre为0的元素有1个
        preMap(0) = 1
        var preNum = 0
        for (i <- nums.indices) {
            if (preMap.contains(preNum+nums(i) - k)) {
                res += preMap(preNum + nums(i) - k)
            }
            preMap(preNum + nums(i)) = preMap.getOrElseUpdate(preNum + nums(i), 0) + 1
            preNum += nums(i)
        }
        res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
