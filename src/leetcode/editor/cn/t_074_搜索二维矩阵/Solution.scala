package leetcode.editor.cn.t_074_搜索二维矩阵

import leetcode.editor.cn.utils.Utils._

//给你一个满足下述两条属性的 m x n 整数矩阵： 
//
// 
// 每行中的整数从左到右按非递减顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 840 👎 0

/**
 * 解答成功:
	执行耗时:496 ms,击败了66.67% 的Scala用户
	内存消耗:54.1 MB,击败了100.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import scala.util.control.Breaks
object Solution {
    def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
        val firstArr = matrix.map(_.head)

        // step1: 计算第一个小于target的索引位置
        var i = 0
        var j = firstArr.length - 1
        val loop = new Breaks()
        // 默认为最后一个
        var firstLineIndex = 0
        loop.breakable {
            while (i <= j) {
                val mid = (i + j) >> 1
                val midV = firstArr(mid)
                if (midV <= target) {
                    if (mid == firstArr.length - 1 || firstArr(mid + 1) > target) {
                        firstLineIndex = mid
                        loop.break()
                    } else {
                        i = mid + 1
                    }
                } else {
                    j = mid - 1
                }
            }
        }

        // step2: 基于二分查找从firstLineIndex所在寻找target
        val data = matrix(firstLineIndex)
        i = 0
        j = data.length - 1

        while (i <= j) {
            val mid = (i + j) >> 1
            val midV = data(mid)
            if (midV == target) {
                return true
            } else if (midV < target) {
                i = mid + 1
            } else {
                j = mid - 1
            }
        }
        false
    }
}
//leetcode submit region end(Prohibit modification and deletion)
