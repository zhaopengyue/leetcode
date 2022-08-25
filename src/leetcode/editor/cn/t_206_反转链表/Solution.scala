package leetcode.editor.cn.t_206_反转链表
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 2706 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
}

/*
* 解答成功:
	执行耗时:520 ms,击败了46.88% 的Scala用户
	内存消耗:55.8 MB,击败了18.75% 的Scala用户
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
    def reverseList(head: ListNode): ListNode = {
        var prev: ListNode = null
        var p = head
        while (p != null) {
            val next = p.next
            p.next = prev
            prev = p
            p = next
        }
        prev
    }
}
//leetcode submit region end(Prohibit modification and deletion)
