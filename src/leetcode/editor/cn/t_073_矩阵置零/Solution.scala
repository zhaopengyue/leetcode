package leetcode.editor.cn.t_073_矩阵置零
//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -2³¹ <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
//~~
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 893 👎 0

/*
* 解答成功:
  执行耗时:592 ms,击败了100.00% 的Scala用户
  内存消耗:56.4 MB,击败了100.00% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    val rows = new Array[Int](matrix.length)
    val cols = new Array[Int](matrix.head.length)

    for (i <- matrix.indices) {
      for (j <- matrix.head.indices) {
        val num = matrix(i)(j)
        if (num == 0) {
          rows(i) = 1
          cols(j) = 1
        }
      }
    }

    for ((row, index) <- rows.zipWithIndex if row == 1) {
      for (i <- cols.indices) {
        matrix(index)(i) = 0
      }
    }

    for ((col, index) <- cols.zipWithIndex if col == 1) {
      for (i <- rows.indices) {
        matrix(i)(index) = 0
      }
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
