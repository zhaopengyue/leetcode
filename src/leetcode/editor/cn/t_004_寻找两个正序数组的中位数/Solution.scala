package leetcode.editor.cn.t_004_寻找两个正序数组的中位数

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 5667 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
import java.util
import java.util.{Comparator, PriorityQueue}

object Solution {

    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        findMedianSortedArraysByGuiBing(nums1, nums2)
    }

    /*
    * 解答成功:
      执行耗时:692 ms,击败了55.00% 的Scala用户
      内存消耗:55.9 MB,击败了60.00% 的Scala用户
      * 备注：还有一个思路：就是光移动指针，不创建新数组
    * */
    def findMedianSortedArraysByGuiBing(nums1: Array[Int], nums2: Array[Int]): Double = {
        if (nums1.isEmpty && nums2.isEmpty) {
            return 0.0
        }
        val data = new Array[Int](nums1.length + nums2.length)
        var i = 0
        var j = 0
        while (i < nums1.length && j < nums2.length) {
            if (nums1(i) < nums2(j)) {
                data(i+j) = nums1(i)
                i += 1
            } else {
                data(i+j) = nums2(j)
                j += 1
            }
        }
        while (i < nums1.length) {
            data(i+j) = nums1(i)
            i += 1
        }
        while (j < nums2.length) {
            data(i+j) = nums2(j)
            j += 1
        }
        val allSize = nums1.length + nums2.length
        val middle = allSize / 2
        if (allSize % 2 == 0) {
            (data(middle - 1).toDouble + data(middle)) / 2
        } else {
            data(middle)
        }

    }

    /*
    * 解答成功:
      执行耗时:916 ms,击败了5.00% 的Scala用户
      内存消耗:56.5 MB,击败了20.00% 的Scala用户
    * */
    def findMedianSortedArraysByHeap(nums1: Array[Int], nums2: Array[Int]): Double = {
        // 基于两个堆查找中位数
        val smallHeap = new PriorityQueue[Int]()
        val bigHeap = new PriorityQueue[Int](new Comparator[Int] {
            override def compare(o1: Int, o2: Int): Int = o2 - o1
        })

        if (nums1.isEmpty && nums2.isEmpty) {
            return 0.0
        }
        insert(nums1, smallHeap, bigHeap)
        insert(nums2, smallHeap, bigHeap)

        if ((nums1.length + nums2.length) % 2 == 0) {
            (smallHeap.peek().toDouble + bigHeap.peek().toDouble) / 2
        } else {
            bigHeap.peek()
        }
    }

    def insert(nums: Array[Int], smallHeap: PriorityQueue[Int], bigHeap: PriorityQueue[Int]): Unit = {
        if (nums.isEmpty) {
            return
        }
        for (i <- nums) {
            if (bigHeap.isEmpty) {
                bigHeap.add(i)
            } else {
                // 比较top
                if (i < bigHeap.peek()) {
                    // 插入大顶堆
                    bigHeap.add(i)
                } else {
                    smallHeap.add(i)
                }
            }
            // 确保平衡
            makeBalance(smallHeap, bigHeap)
        }
    }

    def makeBalance(smallHeap: PriorityQueue[Int], bigHeap: PriorityQueue[Int]): Unit = {
        if (bigHeap.size() > smallHeap.size() + 1) {
            smallHeap.add(bigHeap.poll())
        } else if (bigHeap.size() < smallHeap.size()) {
            bigHeap.add(smallHeap.poll())
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
