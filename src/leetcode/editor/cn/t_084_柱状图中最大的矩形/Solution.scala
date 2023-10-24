package leetcode.editor.cn.t_084_柱状图中最大的矩形

import leetcode.editor.cn.utils.Utils._

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2583 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
object Solution {

    val stack = new mutable.Stack[Int]()
    // key: 索引下标 value: arr[0] -> 左边第一个小于其本身的索引下标, arr[1] -> 右边第一个小于本身的索引下标
    val map = new mutable.HashMap[Int, Array[Int]]()

    def largestRectangleArea(heights: Array[Int]): Int = {
        map.clear()

        var maxArea = Int.MinValue
        // step1: 计算每个柱子左边第一个小于其本身的索引下标
        deal(heights, isLeft = true)
        // step2: 计算每个柱子右边第一个小于其本身的索引下标
        deal(heights, isLeft = false)

        // step3: 计算每个柱子的最大面积
        heights.zipWithIndex.foreach(item => {
            val index = item._2
            val height = item._1
            maxArea = math.max(maxArea, height * (1 + (index - map(index)(0) - 1) + (map(index)(1) - index - 1)))
        })

        maxArea
    }

    // 基于单调栈计算每个元素左侧和右侧第一个小值索引下标
    private def deal(heights: Array[Int], isLeft: Boolean): Unit = {
        stack.clear()
        val arr = if (isLeft) heights.zipWithIndex else heights.zipWithIndex.reverse
        arr.foreach(item => {
            val index = item._2
            val v = item._1
            var next = if (isLeft) -1 else heights.length

            while (stack.nonEmpty && v <= heights(stack.head)) {
                stack.pop()
            }

            if (stack.nonEmpty) next = stack.head
            stack.push(index)


            if (map.contains(index)) {
                if (isLeft) map(index)(0) = next else map(index)(1) = next
            } else {
                map += (index -> (if (isLeft) Array(next, 0)  else Array(0, next)))
            }
        })
    }
}
//leetcode submit region end(Prohibit modification and deletion)
