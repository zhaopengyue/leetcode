package leetcode.editor.cn.t_347_前_k_个高频元素

import leetcode.editor.cn.utils.Utils._

//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1714 👎 0

/**
 * 解答成功:
	执行耗时:592 ms,击败了88.89% 的Scala用户
	内存消耗:59.8 MB,击败了55.56% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.PriorityQueue
import scala.collection.mutable
import java.util.Comparator
import scala.collection.JavaConverters._
object Solution {
    def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
        val hash = new mutable.HashMap[Int, Int]()
        val heap = new PriorityQueue[(Int, Int)](k, new Comparator[(Int, Int)] {
            override def compare(o1: (Int, Int), o2: (Int, Int)): Int = o1._2 - o2._2
        })
        nums.foreach(num => hash.put(num, hash.getOrElse(num, 0)+1))

        hash.foreach(entry => {
            if (heap.size() < k) {
                heap.add(entry)
            } else {
                if (entry._2 > heap.peek()._2) {
                    heap.remove()
                    heap.add(entry)
                }
            }
        })

        heap.iterator().asScala.take(k).map(_._1).toArray
    }
}
//leetcode submit region end(Prohibit modification and deletion)
