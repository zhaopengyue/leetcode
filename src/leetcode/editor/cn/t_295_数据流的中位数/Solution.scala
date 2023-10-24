package leetcode.editor.cn.t_295_数据流的中位数

import leetcode.editor.cn.utils.Utils._

//中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
//
// 
// 例如 arr = [2,3,4] 的中位数是 3 。 
// 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。 
// 
//
// 实现 MedianFinder 类: 
//
// 
// MedianFinder() 初始化 MedianFinder 对象。 
// void addNum(int num) 将数据流中的整数 num 添加到数据结构中。 
// double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10⁻⁵ 以内的答案将被接受。 
// 
//
// 示例 1： 
//
// 
//输入
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//输出
//[null, null, null, 1.5, null, 2.0]
//
//解释
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0 
//
// 提示: 
//
// 
// -10⁵ <= num <= 10⁵ 
// 在调用 findMedian 之前，数据结构中至少有一个元素 
// 最多 5 * 10⁴ 次调用 addNum 和 findMedian 
// 
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 891 👎 0

/**
 * 解答成功:
	执行耗时:1616 ms,击败了100.00% 的Scala用户
	内存消耗:91.9 MB,击败了100.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.PriorityQueue
import java.util.Comparator

class MedianFinder() {

    private val minHeap = new PriorityQueue[Int]()
    private val maxHeap = new PriorityQueue[Int](new Comparator[Int] {
        override def compare(o1: Int, o2: Int): Int = o2 - o1
    })
    private var size = 0

    def addNum(num: Int) {
        if (maxHeap.isEmpty && minHeap.isEmpty) {
            // 初始加入大顶堆
            maxHeap.add(num)
        } else if (num > maxHeap.peek()) {
            minHeap.add(num)
        } else {
            maxHeap.add(num)
        }
        mkBalance()
        size += 1
    }

    private def mkBalance(): Unit = {
        // 确保小顶堆=大顶堆或大顶堆=小顶堆+1
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll())
        } else if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.add(maxHeap.poll())
        }
    }

    def findMedian(): Double = {
        if ((size & 1) == 1) {
            // 奇数
            maxHeap.peek()
        } else {
            // 偶数
            (maxHeap.peek().toDouble + minHeap.peek()) / 2
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = new MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */
//leetcode submit region end(Prohibit modification and deletion)
