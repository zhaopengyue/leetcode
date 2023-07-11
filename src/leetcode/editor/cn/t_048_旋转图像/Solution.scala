package leetcode.editor.cn.t_048_旋转图像

import leetcode.editor.cn.utils.Utils
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics 数组 数学 矩阵 👍 1669 👎 0

/*
 * 解答成功:
	执行耗时:480 ms,击败了66.67% 的Scala用户
	内存消耗:54.2 MB,击败了46.67% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  def rotate(matrix: Array[Array[Int]]): Unit = {
    val len = matrix.length
    // step1: 转置(行转列) 下述语法为双层for的简单写法
    for (x <- matrix.indices; y <- x until len) {
      val tmp = matrix(x)(y)
      matrix(x)(y) = matrix(y)(x)
      matrix(y)(x) = tmp
    }

    // step2: 左右对调, 中间列不变换
    for (x <- matrix.indices; y <- 0 until len / 2) {
      val tmp = matrix(x)(y)
      matrix(x)(y) = matrix(x)(len-y-1)
      matrix(x)(len-y-1) = tmp
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
