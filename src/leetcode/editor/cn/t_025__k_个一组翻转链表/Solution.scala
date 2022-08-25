package leetcode.editor.cn.t_025__k_个一组翻转链表
//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 1760 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
/*
* 解答成功:
	执行耗时:508 ms,击败了100.00% 的Scala用户
	内存消耗:55.5 MB,击败了33.33% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def reverseKGroup(head: ListNode, k: Int): ListNode = {
        // 递归终止条件：长度不足k
        var q = head
        for (_ <- 0 until k) {
            if (q == null) return head
            q = q.next
        }
        // 循环结束后q为分组下一个元素
        val newHead = reverseList(head, q)
        // 计算下一组：下一组和从q开始
        head.next = reverseKGroup(q, k)
        // 返回新头元素
        newHead
    }

    // 重置[head,end)之间的元素
    private def reverseList(head: ListNode, end: ListNode): ListNode = {
        var prev: ListNode = null
        var p = head
        while (p != end) {
            val next = p.next
            p.next = prev
            prev = p
            p = next
        }
        prev
    }

    /*
    /*
    * 解答成功:
      执行耗时:556 ms,击败了25.00% 的Scala用户
      内存消耗:55.3 MB,击败了25.00% 的Scala用户
    * */
    def reverse(head: ListNode, k: Int): ListNode = {
        var i = 0
        var curr = head
        // 第一次循环，探测是否满足一组
        while (i < k && curr != null) {
            i += 1
            curr = curr.next
        }
        if (i != k) {
            // 不满足一组，直接返回
            return head
        }
        // 反转head开头的链表，最多反转n次，并记录第一个节点和最后一个节点
        curr = head
        i = 0
        var prev: ListNode = null
        while (curr != null && i < k) {
            // 暂存next
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
            i += 1
        }
        // 应该指向后续节点的头结点
        head.next = reverse(curr, k)
        // prev指向原来最后一个节点，此时作为该段的头结点返回
        prev
    }
    */
}
//leetcode submit region end(Prohibit modification and deletion)
