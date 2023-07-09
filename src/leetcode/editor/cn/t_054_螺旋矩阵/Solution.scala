package leetcode.editor.cn.t_054_螺旋矩阵
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1416 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import leetcode.editor.cn.utils.Utils

import scala.collection.mutable.ListBuffer
object Solution {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    val rs = new ListBuffer[Int]()

    var i, j = 0
    var top = -1
    var floor = matrix.length
    var left = -1
    var right = matrix.head.length

    while (i > top && i < floor && j > left && j < right) {
      // left -> right
      while (j < right) {
        rs += matrix(i)(j)
        j += 1
      }
      j = right - 1
      i += 1
      top += 1

      // top -> floor
      while (i < floor) {
        rs += matrix(i)(j)
        i += 1
      }
      i = floor - 1
      j -= 1
      right -= 1

      // right -> left
      while (j > left) {
        rs += matrix(i)(j)
        j -= 1
      }
      j = left + 1
      i -= 1
      floor -= 1

      // floor -> top
      while (i > top) {
        rs += matrix(i)(j)
        i -= 1
      }
      i = top + 1
      j += 1
      left += 1

    }

    rs.toList
  }

  def main(args: Array[String]): Unit = {
    val arr = Utils.mk_two_dimensional_arr(3, 4, 1 to 12: _*)
    spiralOrder(arr)
  }
}
//leetcode submit region end(Prohibit modification and deletion)
