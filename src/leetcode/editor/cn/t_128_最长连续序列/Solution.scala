package leetcode.editor.cn.t_128_最长连续序列
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 1673 👎 0

/**
 * 解答成功:
	执行耗时:996 ms,击败了72.73% 的Scala用户
	内存消耗:79.2 MB,击败了31.82% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
object Solution {
    def longestConsecutive(nums: Array[Int]): Int = {
        val map = new mutable.HashMap[Int, Int]()
        var maxLen = 0
        for (num <- nums) {
            if (!map.contains(num)) {
                // 获取左右节点当前的连续长度, 不存在时表示对应侧暂时没有节点
                val left = map.getOrElse(num - 1, 0)
                val right = map.getOrElse(num + 1, 0)
                val currLen = left + right + 1
                maxLen = Math.max(maxLen, currLen)
                map(num) = currLen
                // 更新当前左右边界节点的长度
                map(num - left) = currLen
                map(num + right) = currLen
            }
        }
        maxLen
    }
}
//leetcode submit region end(Prohibit modification and deletion)
