package leetcode.editor.cn.t_994_腐烂的橘子

import leetcode.editor.cn.utils.Utils._
//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 771 👎 0

/**
 * 解答成功:
 * 执行耗时:632 ms,击败了100.00% 的Scala用户
 * 内存消耗:55.5 MB,击败了100.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util
object Solution {

    def orangesRotting(grid: Array[Array[Int]]): Int = {

        val queue = new util.LinkedList[(Int, Int)]()
        // 初始化烂橘子及好橘子个数
        var goodNum = 0
        for (i <- grid.indices; j <- grid.head.indices) {
            if (grid(i)(j) == 2) {
                queue.add((i, j))
            } else if (grid(i)(j) == 1) {
                goodNum += 1
            }
        }

        var cycleNum = 0
        while (! queue.isEmpty && goodNum > 0) {
            cycleNum += 1
            val size = queue.size()
            for (_ <- 0 until size) {
                val node = queue.poll()
                val x = node._1
                val y = node._2
                // 上
                if (x - 1 >= 0 && grid(x - 1)(y) == 1) {
                    grid(x - 1)(y) = 2
                    queue.add((x - 1, y))
                    goodNum -= 1
                }
                // 下
                if (x + 1 < grid.length && grid(x + 1)(y) == 1) {
                    grid(x + 1)(y) = 2
                    queue.add((x + 1, y))
                    goodNum -= 1
                }
                // 左
                if (y - 1 >= 0 && grid(x)(y - 1) == 1) {
                    grid(x)(y - 1) = 2
                    queue.add((x, y - 1))
                    goodNum -= 1
                }
                // 右
                if (y + 1 < grid.head.length && grid(x)(y + 1) == 1) {
                    grid(x)(y + 1) = 2
                    queue.add((x, y + 1))
                    goodNum -= 1
                }
            }
        }

        if (goodNum > 0)  -1 else cycleNum
    }
}
//leetcode submit region end(Prohibit modification and deletion)
