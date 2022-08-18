package leetcode.editor.cn.t_061_旋转链表
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics 链表 双指针 👍 815 👎 0

/*
* 解答成功:
	执行耗时:524 ms,击败了38.46% 的Scala用户
	内存消耗:55.9 MB,击败了7.69% 的Scala用户
* */
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def rotateRight(head: ListNode, k: Int): ListNode = {
        // 空节点或只有一个节点直接返回
        if (head == null || head.next == null) return head

        var tempNode = head
        // 计算链表长度
        var count = 1
        while (tempNode.next != null) {
            tempNode = tempNode.next
            count += 1
        }
        val tail = tempNode

        // 计算新k
        val newK = k % count
        // 位移位数和个数一致，则直接返回
        if (newK == 0) return head
        // 旋转后新头结点的前一个节点的索引，也就是位移次数
        val removeNum = count - newK - 1
        var i = 0
        tempNode = head
        while (i < removeNum) {
            tempNode = tempNode.next
            i += 1
        }
        val newHead = tempNode.next
        // 首先形成循环
        tail.next = head
        // 然后进行断链
        tempNode.next = null
        newHead
    }

}
//leetcode submit region end(Prohibit modification and deletion)
