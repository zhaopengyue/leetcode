package leetcode.editor.cn.t_002_两数相加

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
//
// Related Topics 递归 链表 数学 👍 8399 👎 0

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
    /* 方法1:
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        var addNum = 0
        // 头指针
        val rsHead: ListNode = new ListNode()
        var currNodeP: ListNode = rsHead
        var p = l1
        var q = l2
        // 处理公共长度
        while (p != null && q != null) {
            val sum = p.x + q.x + addNum
            var currNodeNum = 0
            if (sum >= 10) {
                currNodeNum = sum - 10
                addNum = 1
            } else {
                currNodeNum = sum
                addNum = 0
            }
            val currNode = new ListNode(currNodeNum, null)
            currNodeP.next = currNode
            currNodeP = currNode
            p = p.next
            q = q.next
        }
        var skip = false
        while (p != null && !skip) {
            val sum = p.x + addNum
            // 表示需要进位
            if (sum >= 10) {
                val currNode = new ListNode(sum - 10, null)
                currNodeP.next = currNode
                currNodeP = currNode
                addNum = 1
                p = p.next
            } else {
                // 无需进位, 将后续节点直接接上
                val currNode = new ListNode(sum, p.next)
                // 退出后续步骤
                currNodeP.next = currNode
                currNodeP = currNode
                addNum = 0
                skip = true
            }
        }

        while (q != null && !skip) {
            val sum = q.x + addNum
            // 表示需要进位
            if (sum >= 10) {
                val currNode = new ListNode(sum - 10, null)
                currNodeP.next = currNode
                currNodeP = currNode
                addNum = 1
                q = q.next
            } else {
                // 无需进位, 将后续节点直接接上
                val currNode = new ListNode(sum, q.next)
                // 退出后续步骤
                currNodeP.next = currNode
                currNodeP = currNode
                addNum = 0
                skip = true
            }
        }

        if (addNum == 1) {
            val currNode = new ListNode(1, null)
            currNodeP.next = currNode
        }
        rsHead.next
    }
     */

    /* 方法2：方法1的代码优化版本
    	  执行耗时:608 ms,击败了43.48% 的Scala用户
	      内存消耗:56.2 MB,击败了60.87% 的Scala用户
    */
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        val rsHead = new ListNode()
        var currNode = rsHead
        // 进位
        var carryNum = 0
        var p = l1
        var q = l2

        while (p != null || q!= null) {
            val x = if (p != null) p.x else 0
            val y = if (q != null) q.x else 0
            val sum = x + y + carryNum
            val rsNode = new ListNode(sum % 10)
            currNode.next = rsNode
            currNode = rsNode
            carryNum = sum / 10
            if (p != null) p = p.next
            if (q != null) q = q.next
        }

        if (carryNum == 1) currNode.next = new ListNode(1)

        rsHead.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)
