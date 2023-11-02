package leetcode.editor.cn.t_064_最小路径和

import leetcode.editor.cn.utils.Utils._

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 200 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1597 👎 0

/*
解答成功:
	执行耗时:608 ms,击败了20.00% 的Scala用户
	内存消耗:58.6 MB,击败了20.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def minPathSum(grid: Array[Array[Int]]): Int = {

        /*
        // 回溯
        MIN_SUM = Int.MaxValue
        byBT(0, 0, grid, 0)
        MIN_SUM
        */
        byDP(grid)
    }

    private def byDP(grid: Array[Array[Int]]): Int = {

        val row = grid.length
        val col = grid.head.length

        val statusRow = new Array[Int](row)
        val statusCol = new Array[Int](col)

        // 初始化状态
        var tempSum = 0
        for (i <- 0 until row) {
            tempSum += grid(i)(0)
            statusRow(i) = tempSum
        }

        tempSum = 0
        for (i <- 0 until col) {
            tempSum += grid(0)(i)
            statusCol(i) = tempSum
        }

        // 计算状态
        for (i <- 1 until row; j <- 1 until col) {
            val v = grid(i)(j)
            val sum = math.min(statusCol(j) + v, statusRow(i) + v)
            statusCol(j) = sum
            statusRow(i) = sum
        }

        statusCol(col - 1) // statusRow(row - 1)也一样
    }

    var MIN_SUM: Int = Int.MaxValue

    // 回溯算法
    private def byBT(i: Int, j: Int, grid: Array[Array[Int]], currSum: Int): Unit = {
        // 若当前和已经大于计算出的最小值, 则直接剪枝
        if (currSum >= MIN_SUM) return
        if (i == grid.length - 1 && j == grid.head.length - 1) {
            MIN_SUM = math.min(MIN_SUM, currSum + grid(grid.length - 1)(grid.head.length - 1))
            return
        }
        // 越界直接退出
        if (i == grid.length || j == grid.head.length) return

        // 决策1: 向右
        byBT(i, j + 1, grid, currSum + grid(i)(j))
        // 决策2: 向下
        byBT(i + 1, j, grid, currSum + grid(i)(j))
    }
}
//leetcode submit region end(Prohibit modification and deletion)
