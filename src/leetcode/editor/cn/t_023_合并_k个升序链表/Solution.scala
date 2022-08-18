package leetcode.editor.cn.t_023_合并_k个升序链表
//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2121 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
/*
* 解答成功:
	执行耗时:588 ms,击败了76.92% 的Scala用户
	内存消耗:57.9 MB,击败了38.46% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
import java.util.{Comparator, PriorityQueue}
object Solution {
    def mergeKLists(lists: Array[ListNode]): ListNode = {
        if (lists.isEmpty) return null
        // 使用小顶堆
        val heap = new PriorityQueue[ListNode](lists.length, new Comparator[ListNode] {
            override def compare(o1: ListNode, o2: ListNode): Int = o1.x - o2.x
        })
        // 初始每个链表的第一个节点放入
        for (l <- lists ) {
            if (l != null) {
                heap.add(l)
            }
        }
        // 虚拟头结点
        val vHead = new ListNode()
        var currNode = vHead
        while (! heap.isEmpty) {
            val smallNode = heap.poll()
            currNode.next = smallNode
            if (smallNode.next != null) {
                // 将最小值的下一个节点入堆
                heap.add(smallNode.next)
            }
            currNode = smallNode
        }
        vHead.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)
