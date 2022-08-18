package leetcode.editor.cn.t_092_反转链表_i_i
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1367 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
}
/*
* 解答成功:
	执行耗时:592 ms,击败了16.67% 的Scala用户
	内存消耗:54.7 MB,击败了66.67% 的Scala用户
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
    def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
        // 这两种情况无需反转
        if (head.next == null || left == right) return head

        val vHead = new ListNode(0, head)
        // k表示需要反转多少个元素
        val k = right - left + 1
        var i = 0
        var beforeReverseNode = vHead
        // 遍历到待反转的节点的前一个节点
        while (i < left - 1) {
            beforeReverseNode = beforeReverseNode.next
            i += 1
        }

        // 需要反转区间中的第一个节点
        val reverseHead = beforeReverseNode.next
        var currNode = reverseHead
        i = 0
        var prev: ListNode = null
        while (i < k) {
            // 暂存next节点
            val next = currNode.next
            currNode.next = prev
            prev = currNode
            currNode = next
            i += 1
        }
        // 反转结束后，prev为反转区间中的头结点
        // 先连接尾结点
        reverseHead.next = currNode
        // 再连接头结点
        beforeReverseNode.next = prev
        vHead.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)
