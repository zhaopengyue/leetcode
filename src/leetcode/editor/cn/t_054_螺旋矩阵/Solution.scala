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

/*
* 解答成功:
  执行耗时:464 ms,击败了80.00% 的Scala用户
  内存消耗:53.9 MB,击败了100.00% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)

import scala.collection.mutable.ListBuffer

object Solution {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    val rs = new ListBuffer[Int]()

    var top = 0
    var floor = matrix.length - 1
    var left = 0
    var right = matrix.head.length - 1
    var numFlag = matrix.length * matrix.head.length

    while (numFlag >= 1) {
      // left -> right
      for (i <- left to right if numFlag >= 1) {
        rs += matrix(top)(i)
        numFlag -= 1
      }
      top += 1

      // top -> floor
      for (i <- top to floor if numFlag >= 1) {
        rs += matrix(i)(right)
        numFlag -= 1
      }
      right -= 1

      // right -> left
      for (i <- (left to right).reverse if numFlag >= 1) {
        rs += matrix(floor)(i)
        numFlag -= 1
      }
      floor -= 1

      // floor -> top
      for (i <- (top to floor).reverse if numFlag >= 1) {
        rs += matrix(i)(left)
        numFlag -= 1
      }
      left += 1
    }

    rs.toList
  }
}
//leetcode submit region end(Prohibit modification and deletion)
