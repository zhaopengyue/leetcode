package leetcode.editor.cn.t_219_存在重复元素_i_i

import leetcode.editor.cn.utils.Utils._

//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 672 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 解答成功:
 * 执行耗时:1024 ms,击败了100.00% 的Scala用户
 * 内存消耗:72.2 MB,击败了33.33% 的Scala用户
 */
import scala.collection.mutable
object Solution {
    def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
        val map = mutable.HashMap[Int, Int]()
        nums.indices.foreach(i => {
            val num = nums(i)
            if (map.contains(num) && i - map(num) <= k) {
                return true
            }
            map += (num -> i)
        })
        false
    }
}
//leetcode submit region end(Prohibit modification and deletion)
