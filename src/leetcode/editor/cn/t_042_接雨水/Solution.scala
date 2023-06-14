package leetcode.editor.cn.t_042_接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3736 👎 0

/*
* 方法思路如下（暴力和双指针方法思想一致）：
* 1. 求雨量总和可以理解为求每个柱子的容水量，然后进行加和
* 2. 每个柱子的容水量 = Math.min(该柱子左边的最高值, 该柱子右边的最高值) - 当前柱子高度
* 3. 以左侧为例，若当前柱子高度小于右侧柱子，但其高度又高于左侧最高，那么该柱子是不存水的；右侧同理
*
* 解答成功:
	执行耗时:536 ms,击败了87.50% 的Scala用户
	内存消耗:56.6 MB,击败了37.50% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  def trap(height: Array[Int]): Int = {
    // 双指针
    var sum = 0
    var i = 1
    var j = height.length - 2
    var leftMaxHeight = height(0)
    var rightMaxHeight = height(height.length - 1)
    /*
    while (i < j) {
        if (height(i) < height(j)) {
            if (height(i) > leftMaxHeight) {
                leftMaxHeight = height(i)
            } else {
                sum = leftMaxHeight - height(i) + sum
            }
            i += 1
        } else {
            if (height(j) > rightMaxHeight) {
                rightMaxHeight = height(j)
            } else {
                sum = rightMaxHeight - height(j) + sum
            }
            j -= 1
        }
    }*/
    while (i <= j) {
      if (leftMaxHeight < rightMaxHeight) {
        leftMaxHeight = Math.max(height(i), leftMaxHeight)
        sum += leftMaxHeight - height(i)
        i += 1
      } else {
        rightMaxHeight = Math.max(height(j), rightMaxHeight)
        sum += rightMaxHeight - height(j)
        j -= 1
      }
    }
    sum
  }
}
//leetcode submit region end(Prohibit modification and deletion)
