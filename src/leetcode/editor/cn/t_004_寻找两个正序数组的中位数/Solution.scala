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
        findMedianSortedArraysByMiddle(nums1, nums2)
    }

    /**
     * 解答成功:
          执行耗时:640 ms,击败了82.35% 的Scala用户
          内存消耗:57 MB,击败了76.47% 的Scala用户
     */
    def findMedianSortedArraysByMiddle(nums1: Array[Int], nums2: Array[Int]): Double = {
        val len1 = nums1.length
        val len2 = nums2.length

        if (((len1 + len2) & 1) == 1) {
            // 奇数
            findMedianSortedArraysByMiddleDp(nums1, nums2, 0, len1 - 1, 0, len2 - 1, ((len1 + len2) >> 1) + 1)
        } else {
            // 偶数情况
            (findMedianSortedArraysByMiddleDp(nums1, nums2, 0, len1 - 1, 0, len2 - 1, (len1 + len2) >> 1) +
              findMedianSortedArraysByMiddleDp(nums1, nums2, 0, len1 - 1, 0, len2 - 1, ((len1 + len2) >> 1) + 1)) * 0.5
        }

    }

    // 从nums1[nums1Left:end],nums2[nums2Left:end]寻找第k大的数
    private def findMedianSortedArraysByMiddleDp(nums1: Array[Int],
                                                 nums2: Array[Int],
                                                 nums1Left: Int,
                                                 nums1Right: Int,
                                                 nums2Left: Int,
                                                 nums2Right: Int,
                                                 k: Int): Int = {
        val len1 = nums1Right - nums1Left + 1
        val len2 = nums2Right - nums2Left + 1
        // 确保nums1永远比nums2短
        if (len1 > len2) return findMedianSortedArraysByMiddleDp(nums2, nums1, nums2Left, nums2Right, nums1Left, nums1Right, k)

        // nums1为空时, 第k大数从nums2中取即可
        if (len1 == 0) return nums2(nums2Left + k - 1)

        // 当k为1时表示递归结束, 此时选取两者中最小的值即为第k个值(因为k从原始k变为1经过了原始k/2轮比较,已经去掉了原始k-1个数字,则此轮小值即为原始第k个值)
        if (k == 1) return Math.min(nums1(nums1Left), nums2(nums2Left))

        val kMid = k / 2
        val nums1Index = nums1Left + Math.min(len1, kMid) - 1
        val nums2Index = nums2Left + Math.min(len2, kMid) - 1

        if (nums1(nums1Index) < nums2(nums2Index)) {
            // 表示nums1[nums1Left: nums1Index]范围内的数不可能是第k大的数
            findMedianSortedArraysByMiddleDp(nums1, nums2, nums1Index + 1, nums1Right, nums2Left, nums2Right, k - (nums1Index - nums1Left + 1))
        } else {
            findMedianSortedArraysByMiddleDp(nums1, nums2, nums1Left, nums1Right, nums2Index + 1, nums2Right, k - (nums2Index - nums2Left + 1))
        }
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
