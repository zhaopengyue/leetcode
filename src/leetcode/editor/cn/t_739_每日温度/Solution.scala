package leetcode.editor.cn.t_739_每日温度

import leetcode.editor.cn.utils.Utils._

//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//
//
// 示例 1:
//
//
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
//
//
// 示例 2:
//
//
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
//
//
// 示例 3:
//
//
//输入: temperatures = [30,60,90]
//输出: [1,1,0]
//
//
//
// 提示：
//
//
// 1 <= temperatures.length <= 10⁵
// 30 <= temperatures[i] <= 100
//
//
// Related Topics 栈 数组 单调栈 👍 1627 👎 0

/**
 * 解答成功:
	执行耗时:1084 ms,击败了66.67% 的Scala用户
	内存消耗:73.9 MB,击败了0.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
        // 存放下标
        val stack = new scala.collection.mutable.Stack[Int]()

        temperatures.zipWithIndex.reverse.map(item => {
          var isBreak = false
          val v = item._1
          val index = item._2
          var next = index
          while (!isBreak) {
              if (stack.isEmpty) {
                  isBreak = true
                  stack.push(index)
              } else {
                  if (v < temperatures(stack.head)) {
                      next = stack.head
                      stack.push(index)
                      isBreak = true
                  } else {
                      stack.pop()
                  }
              }
          }

          next - index
        }).reverse
    }
}
//leetcode submit region end(Prohibit modification and deletion)
