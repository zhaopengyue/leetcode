package leetcode.editor.cn.t_143_重排链表
//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics 栈 递归 链表 双指针 👍 1018 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x

    override def toString: String = _x.toString
}
/*
* 解答成功:
	执行耗时:592 ms,击败了75.00% 的Scala用户
	内存消耗:57.9 MB,击败了87.50% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
import java.util
object Solution {
    def reorderList(head: ListNode): Unit = {
        if (head.next == null) return
        val stack = new util.LinkedList[ListNode]()
        // 将全部节点入栈
        var tmp = head
        while (tmp != null) {
            stack.push(tmp)
            tmp = tmp.next
        }
        val vHead = new ListNode()
        var curr = head
        // tail节点为上一组的最后一个节点。因为初始时为空，故tail为一个虚拟节点
        var tail = vHead
        while (true) {
            if (stack.isEmpty) {
                return
            } else {
                val sNode = stack.pop()
                if (curr == sNode) {
                    // 节点个数为奇数，且已经达到最后一个节点
                    tail.next = sNode
                    sNode.next = null
                    return
                } else if (curr.next == sNode) {
                    // 节点个数为偶数，且已经相遇
                    tail.next = curr
                    sNode.next = null
                    return
                } else {
                    val tmp = curr.next
                    curr.next = sNode
                    sNode.next = null
                    tail = sNode
                    curr = tmp
                    tail.next = curr
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
