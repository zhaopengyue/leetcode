package leetcode.editor.cn.t_046_全排列

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2204 👎 0

/*
* 解答成功:
	执行耗时:524 ms,击败了48.00% 的Scala用户
	内存消耗:53 MB,击败了100.00% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable.ListBuffer
object Solution {
    def permute(nums: Array[Int]): List[List[Int]] = {
        val buffer = new ListBuffer[List[Int]]
        val rs = new Array[Int](nums.length)
        val flag = new Array[Int](nums.length)
        f(0, nums, rs, flag, buffer)
        buffer.toList
    }

    def f(no: Int, nums: Array[Int], rs: Array[Int], flag: Array[Int], rsList: ListBuffer[List[Int]]): Unit = {
        if (no == nums.length) {
            rsList += rs.toList
            return
        }
        for (item <- flag.zipWithIndex) {
            if (item._1 == 0) {
                // 保存结果
                rs(no) = nums(item._2)
                flag(item._2) = 1
                f(no + 1, nums, rs, flag, rsList)
                // 还原
                flag(item._2) = 0
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
