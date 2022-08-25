package leetcode.editor.cn.t_018_四数之和

//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1327 👎 0

/*
* 解答成功:
	执行耗时:568 ms,击败了100.00% 的Scala用户
	内存消耗:54.2 MB,击败了71.43% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable.ListBuffer
object Solution {
    def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
        if (nums.length < 4) {
            return List.empty[List[Int]]
        }
        // step1: 先进行排序
        val orderNums = nums.sorted
        val numLen = nums.length
        var p = 0
        val buff = new ListBuffer[List[Int]]

        while (p < numLen - 3) {
            // 跳过重复p,第一个p不进行判断
            if ((p >= 1 && orderNums(p - 1) != orderNums(p)) || p == 0) {
                var k = p + 1
                // k下标的合法性由p保证,k仅和自身判重，故第一个k不做判断
                while (k < numLen - 2) {
                    if (orderNums(k - 1) != orderNums(k) || k == p + 1) {
                        var i = k + 1
                        var j = numLen - 1
                        while (i < j) {
                            // 将第一位转化为long，防止加和溢出
                            val sum = orderNums(p).toLong + orderNums(k) + orderNums(i) + orderNums(j)
                            if (sum < target) {
                                i += 1
                            } else if (sum > target) {
                                j -= 1
                            } else {
                                buff.append(List(orderNums(p), orderNums(k), orderNums(i), orderNums(j)))
                                // 跳过重复i及j
                                while (i < j && orderNums(i) == orderNums(i+1)) {
                                    i += 1
                                }
                                while (i < j && orderNums(j) == orderNums(j-1)) {
                                    j -= 1
                                }
                                i += 1
                                j -= 1
                            }
                        }
                    }
                    k += 1
                }
            }
            p += 1
        }
        buff.toList
    }
}
//leetcode submit region end(Prohibit modification and deletion)
