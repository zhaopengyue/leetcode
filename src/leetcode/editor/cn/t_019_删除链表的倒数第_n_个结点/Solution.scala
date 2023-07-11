package leetcode.editor.cn.t_019_删除链表的倒数第_n_个结点
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2164 👎 0
/*
解答成功:
	执行耗时:496 ms,击败了66.67% 的Scala用户
	内存消耗:56 MB,击败了91.67% 的Scala用户
 */
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
    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
        // 因为当只有一个节点，可能会删除它本身，这里创建一个虚拟的头结点
        val vHead = new ListNode()
        vHead.next = head
        var slow = vHead
        var fast = vHead
        var index = 0
        // 将j向后位移n位，确保(i,j]区间有n个节点，这样当j指向最后一个节点时，(i,j]区间就会有n个节点，i正好指向倒数第n个节点的前一个节点
        // 注：测试案例中n不会大于链表长度，故无需考虑null情况
        while (index < n) {
            fast = fast.next
            index += 1
        }

        while (fast != null && fast.next != null) {
            fast = fast.next
            slow = slow.next
        }

        slow.next = slow.next.next

        vHead.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)
