package leetcode.editor.cn.t_015_三数之和

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1-1,-1,2],[,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 5051 👎 0

/*
* 解答成功:
	执行耗时:704 ms,击败了100.00% 的Scala用户
	内存消耗:60 MB,击败了80.00% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable.ListBuffer

object Solution {
    def threeSum(nums: Array[Int]): List[List[Int]] = {
        val orderedData = nums.sorted
        // 若都是正数，其加和必不可能为0
        if (orderedData.isEmpty || orderedData(0) > 0 || orderedData.length < 3) {
            return List.empty[List[Int]]
        }

        var k = 0
        val buffer = new ListBuffer[List[Int]]
        // 固定一个指针，遍历负数到0的部分
        while (k < orderedData.length - 2 && orderedData(k) <= 0) {
            // 跳过重复值
            if ((k >= 1 && orderedData(k) != orderedData(k-1)) || k == 0) {
                // 构建两个指针，一个从k到右，一个从右到左。注意，i必须从k右侧开始取值，否则会重复
                var i = k + 1
                var j = orderedData.length - 1
                while (i < j) {
                    val sum = orderedData(k) + orderedData(i) + orderedData(j)
                    if (sum > 0) {
                        // 正数偏大，向左移，减少j对应的数字
                        j -= 1
                    } else if (sum < 0) {
                        // 负数偏小，向右移，增加i对应的数字
                        i += 1
                    } else {
                        // 相等, 首先跳过所有重复值
                        while (i < j && orderedData(i+1) == orderedData(i)) {
                            i += 1
                        }
                        while (i < j && orderedData(j-1) == orderedData(j)) {
                            j -= 1
                        }
                        buffer += List(orderedData(k), orderedData(i), orderedData(j))
                        i += 1
                        j -= 1
                    }
                }
            }
            k += 1
        }
        buffer.toList
    }
}
//leetcode submit region end(Prohibit modification and deletion)
