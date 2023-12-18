package leetcode.editor.cn.t_289_生命游戏

import leetcode.editor.cn.utils.Utils._

//根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。 
//
// 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞
// （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律： 
//
// 
// 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡； 
// 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活； 
// 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡； 
// 如果死细胞周围正好有三个活细胞，则该位置死细胞复活； 
// 
//
// 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返
//回下一个状态。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
//输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
// 
//
// 示例 2： 
// 
// 
//输入：board = [[1,1],[1,0]]
//输出：[[1,1],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 25 
// board[i][j] 为 0 或 1 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。 
// 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？ 
// 
//
// Related Topics 数组 矩阵 模拟 👍 558 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def gameOfLife(board: Array[Array[Int]]): Unit = {

        val row = board.length
        val col = board.head.length
        // 一个int为32位, 分为如下:
        // xx...(其余29为)1(该值是否经过处理,1表示经过处理,0表示未经处理)1(原始值)1(计算出的新值)
        // 相邻节点x坐标
        val pointX = Array(-1, -1, -1, 0, 0, 1, 1, 1)
        val pointY = Array(-1, 0, 1, -1, 1, -1, 0, 1)
        // 重置原始值, 原始值高16位为标记为,低16为为原始值
        for (i <- board.indices; j <- board.head.indices) {
            // 当前value一定是未经处理过的
            val originV = board(i)(j)
            var liveCount = 0
            var deadCount = 0
            // 计算周围细胞状态种类
            for ((x, y) <- pointX zip pointY) {
                val newX = i + x
                val newY = j + y
                if (newX >= 0 && newX < row && newY >= 0 && newY < col) {
                    // 坐标合法
                    val pointV = board(newX)(newY)
                    val dealStatus = pointV & 0x4
                    val originPointV = pointV & 0x2
                    val newPointV = pointV & 0x1
                    if (dealStatus != 0) {
                        if (originPointV != 0) {
                            liveCount += 1
                        } else {
                            deadCount += 1
                        }
                    } else {
                        if (newPointV != 0) {
                            liveCount += 1
                        } else {
                            deadCount += 1
                        }
                    }
                }
            }
            // 计算当前状态
            val newV = {
                if (originV == 1) {
                    if (liveCount < 2) {
                        0
                    } else if (liveCount >= 2 && liveCount <= 3) {
                        1
                    } else {
                        0
                    }
                } else {
                    if (liveCount == 3) {
                        1
                    } else {
                        0
                    }
                }
            }
            // 存入
            board(i)(j) = 0x4 | (originV << 1) | newV
        }
        // 替换为结果值
        for (i <- board.indices; j <- board.head.indices) {
            // 仅取最后一位
            board(i)(j) &= 0x1
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
