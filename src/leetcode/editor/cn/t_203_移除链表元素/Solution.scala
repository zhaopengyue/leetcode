package leetcode.editor.cn.t_203_移除链表元素
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics 递归 链表 👍 1395 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
}

/**
 * 解答成功:
 * 执行耗时:710 ms,击败了100.00% 的Scala用户
 * 内存消耗:59.5 MB,击败了100.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def removeElements(head: ListNode, `val`: Int): ListNode = {
        // 虚拟头结点
        val vHead = new ListNode(0, head)

        var curr = vHead
        while (curr != null && curr.next != null) {
          if (curr.next.x == `val`) {
              // 删除next节点, 然后继续处理该节点
            curr.next = curr.next.next
          } else {
            curr = curr.next
          }
        }

        vHead.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)
