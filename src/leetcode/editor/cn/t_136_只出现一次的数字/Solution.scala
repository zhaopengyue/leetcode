package leetcode.editor.cn.t_136_只出现一次的数字

import leetcode.editor.cn.utils.Utils._

//给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。 
//
// 
// 
// 
// 
// 
//
// 示例 1 ： 
//
// 
//输入：nums = [2,2,1]
//输出：1
// 
//
// 示例 2 ： 
//
// 
//输入：nums = [4,1,2,1,2]
//输出：4
// 
//
// 示例 3 ： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 除了某个元素只出现一次以外，其余每个元素均出现两次。 
// 
//
// Related Topics 位运算 数组 👍 3045 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def singleNumber(nums: Array[Int]): Int = {
        // 基于异或:
        // 1. 对任意的 a, b, x ，如果x = a ^ b， 那么肯定有 x ^ a = b, x ^ b = a, 即异或满足交换律
        // 2. 相同数异或结果为0,0和任何数异或即为任何数
        // 3. 基于上述结果, 我们可以假设nums中的结果经过了交换, 具有两个相同值的元素异或后为0,剩余一个单数与0异或结果为该单数，故求得
        nums.reduce((a, b) => a ^ b)
    }

    /**
     * 排序方案:
     * 解答成功:
      执行耗时:540 ms,击败了78.57% 的Scala用户
      内存消耗:56.5 MB,击败了7.14% 的Scala用户

     * @return
     */
    private def bySort(nums: Array[Int]): Int = {
        java.util.Arrays.sort(nums)

        for (i <- nums.indices) {
            if ((i - 1 < 0 || nums(i - 1) != nums(i)) && (i + 1 == nums.length || nums(i + 1) != nums(i))) {
                return nums(i)
            }
        }
        -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)
