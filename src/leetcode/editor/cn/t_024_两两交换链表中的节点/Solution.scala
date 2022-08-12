package leetcode.editor.cn.t_024_两两交换链表中的节点
//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 1511 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
}
/*
* 解答成功:
	执行耗时:500 ms,击败了41.67% 的Scala用户
	内存消耗:54.6 MB,击败了50.00% 的Scala用户
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
    def swapPairs(head: ListNode): ListNode = {
        // 特殊处理
        if (head == null) return null
        if (head.next == null) return head
        // 构建虚拟头结点
        val vHead = new ListNode()
        vHead.next = head
        var flagNode = vHead
        /*
        * 情景1: v -> o -> [o] 方括号为flagNode，此时无下一个节点，无需继续处理
        * 情景2：v -> o -> [o] -> o 方括号为flagNode，虽然有下一个节点，但是仅剩余一个，无法交换，故退出
        * */
        while (flagNode.next != null && flagNode.next.next != null) {
            val aNode = flagNode.next
            val bNode = flagNode.next.next
            aNode.next = bNode.next
            bNode.next = aNode
            flagNode.next = bNode
            // 将flagNode位移到交换后的aNode位置
            flagNode = aNode
        }
        vHead.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)
