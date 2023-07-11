package leetcode.editor.cn.t_240_搜索二维矩阵_i_i

//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
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
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 分治 矩阵 👍 1301 👎 0

/*
解答成功:
	执行耗时:588 ms,击败了87.50% 的Scala用户
	内存消耗:64 MB,击败了25.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val m = matrix.length
    if (m == 0) return false

    val n = matrix.head.length

    // 左下角的元素是这一行中最小的元素，同时又是这一列中最大的元素。
    var i = m - 1
    var j = 0

    while (i >= 0 && j <= n - 1) {
      val num = matrix(i)(j)

      // 若左下角元素等于目标，则找到
      if (num == target) return true

      // 若左下角元素小于目标，则目标不可能存在于当前矩阵的第一列，因为当前列最大的元素都比target小，故
      // 问题规模可以减小为在去掉第一列的子矩阵中寻找目标
      if (num < target) {
        j += 1
      }  else {
        // 若左下角元素大于目标，则目标不可能存在于当前矩阵的最后一行，因为当前行最小的元素都比target大，故
        // 问题规模可以减小为在去掉最后一行的子矩阵中寻找目标
        i -= 1
      }

    }
    // 若遍历结束仍然没找到，则返回false
    false
  }
}
//leetcode submit region end(Prohibit modification and deletion)
