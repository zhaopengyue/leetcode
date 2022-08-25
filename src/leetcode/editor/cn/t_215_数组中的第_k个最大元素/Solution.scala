package leetcode.editor.cn.t_215_数组中的第_k个最大元素

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1824 👎 0

/*
* 快排方式：
* 解答成功:
	执行耗时:764 ms,击败了42.86% 的Scala用户
	内存消耗:74.4 MB,击败了14.29% 的Scala用户
*	堆方式：
* 解答成功:
	执行耗时:820 ms,击败了21.43% 的Scala用户
	内存消耗:70.4 MB,击败了35.71% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.PriorityQueue
import scala.annotation.tailrec
object Solution {
    def findKthLargest(nums: Array[Int], k: Int): Int = {
        // 快排方式
        //deal(nums, k, 0, nums.length - 1)
        // 方案2：也可以采用维持一个小顶堆的方式，全部数据插入完成后取出堆顶元素
        heapM(nums, k)
    }

    def oneSort(nums: Array[Int], start: Int, end: Int): Int = {
        val flag = nums(end)
        var i = start
        var j = start
        while (j < end) {
            // 将大于end的都放在左边
            if (nums(j) > flag) {
                swap(nums, i, j)
                i += 1
            }
            j += 1
        }
        swap(nums, i, end)
        i
    }

    @tailrec
    def deal(nums: Array[Int], k: Int, start: Int, end: Int): Int = {
        if (start > end) {
            return -1
        }
        val index = oneSort(nums, start, end)
        if (index + 1 == k) return nums(index)
        if (index + 1 > k) {
            deal(nums, k, start, index - 1)
        }  else {
            deal(nums, k, index + 1, end)
        }
    }

    def swap(nums: Array[Int], i: Int, j: Int): Unit = {
        val tmp = nums(j)
        nums(j) = nums(i)
        nums(i) = tmp
    }

    def heapM(nums: Array[Int], k: Int): Int = {
        val heap = new PriorityQueue[Int](k)
        for (item <- nums.zipWithIndex) {
            if (item._2 < k) {
                // 堆未满，直接插入
                heap.add(item._1)
            } else {
                // 堆满了，检查大小
                if (item._1 > heap.peek()) {
                    // 说明还有更大的，先删除后插入
                    heap.poll()
                    heap.add(item._1)
                }
                // 否则不操作
            }
        }
        // 返回堆顶即可
        heap.peek()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
