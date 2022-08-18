package leetcode.editor.cn.t_086_分隔链表
//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics 链表 双指针 👍 611 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
}
/*
* 解答成功:
	执行耗时:528 ms,击败了71.43% 的Scala用户
	内存消耗:54.7 MB,击败了42.86% 的Scala用户
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
    def partition(head: ListNode, x: Int): ListNode = {
        if (head == null || head.next == null) return head
        // 存储小于x的节点
        val head1 = new ListNode()
        var node1 = head1
        // 存储大于等于x的节点
        val head2 = new ListNode()
        var node2 = head2
        var tmp = head
        while (tmp != null) {
            if (tmp.x < x) {
                node1.next = tmp
                node1 = tmp
            } else {
                node2.next = tmp
                node2 = tmp
            }
            tmp = tmp.next
        }
        // 链接两条链
        node1.next = head2.next
        // 第二条链的最后一个节点的next域置为null
        node2.next = null
        head1.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)
