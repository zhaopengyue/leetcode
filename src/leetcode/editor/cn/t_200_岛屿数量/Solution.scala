package leetcode.editor.cn.t_200_岛屿数量

import leetcode.editor.cn.utils.Utils._
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2342 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {

    def numIslands(grid: Array[Array[Char]]): Int = {
        byDFS(grid)
    }

    /**
     * 解答成功:
     * 执行耗时:596 ms,击败了100.00% 的Scala用户
     * 内存消耗:60.6 MB,击败了100.00% 的Scala用户
     *
     */
    def byDFS(grid: Array[Array[Char]]): Int = {
        var count = 0
        for (i <- grid.indices; j <- grid.head.indices if grid(i)(j) == '1') {
            count += 1
            reverse(i, j, grid)
        }
        count
    }

    private def reverse(x: Int, y: Int, grid: Array[Array[Char]]): Unit = {
        if (grid(x)(y) == '0' || grid(x)(y) == '2') return
        // 标记当前节点被访问过
        grid(x)(y) = '2'
        // 遍历四次
        for (_ <- 0 until 4) {
            if (x - 1 >= 0) reverse(x - 1, y, grid) // 上
            if (x + 1 < grid.length) reverse(x + 1, y, grid) // 下
            if (y - 1 >= 0) reverse(x, y - 1, grid) // 左
            if (y + 1 < grid.head.length) reverse(x, y + 1, grid) // 右
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
