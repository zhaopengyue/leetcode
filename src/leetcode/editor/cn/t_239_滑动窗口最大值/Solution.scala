package leetcode.editor.cn.t_239_滑动窗口最大值

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2342 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util._

object Solution {

  case class NumObj(index: Int, num: Int)

  /*
  解答成功:
	执行耗时:1248 ms,击败了75.00% 的Scala用户
	内存消耗:79.5 MB,击败了75.00% 的Scala用户
  * */
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    val heap = new PriorityQueue[NumObj](nums.length, new Comparator[NumObj] {
      override def compare(o1: NumObj, o2: NumObj): Int = o2.num - o1.num
    })

    val rs = new Array[Int](nums.length - k + 1)

    for (i <- nums.indices) {
      heap.add(NumObj(i, nums(i)))
      if (i >= k - 1) {
        val j = i - k
        if (j >= 0) {
          // 非滑动区间内的元素删除掉
          while (heap.peek().index < i - k + 1) {
            heap.poll()
          }
        }
        rs(i - k + 1) = heap.peek().num
      }
    }

    rs
  }

  /*
  解答成功:
  击败了60.00% 的Scala用户
  击败了60.00% 的Scala用户
  * */
  /* 方案1:  构建一个可以自由删除元素的堆
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {

    val myHeap = new MyHeap()
    val rs = new Array[Int](nums.length - k + 1)
    for (i <- nums.indices) {
      myHeap.push(nums(i))
      if (i >= k - 1) {
        val j = i - k
        if (j >= 0) {
          myHeap.erase(nums(j))
        }
        rs(i - k + 1) = myHeap.top()
      }
    }
    rs
  }

  class MyCompactor extends Comparator[Int] {
    override def compare(o1: Int, o2: Int): Int = o2 - o1
  }

  class MyHeap {
    private val saveHeap = new PriorityQueue[Int](new MyCompactor)
    private val dealHeap = new PriorityQueue[Int](new MyCompactor)

    def push(v: Int): Unit = saveHeap.add(v)

    def empty: Boolean = saveHeap.isEmpty

    def top(): Int = {
      while (!dealHeap.isEmpty && dealHeap.peek() == saveHeap.peek()) {
        dealHeap.poll()
        saveHeap.poll()
      }
      saveHeap.peek()
    }

    def pop(): Unit = {
      while (!dealHeap.isEmpty && dealHeap.peek() == saveHeap.peek()) {
        dealHeap.poll()
        saveHeap.poll()
      }
      if (!saveHeap.isEmpty) saveHeap.poll()
    }

    def erase(v: Int): Unit = dealHeap.add(v)
  } */
}

//leetcode submit region end(Prohibit modification and deletion)
