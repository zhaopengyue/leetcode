package leetcode.editor.cn.t_160_相交链表
//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。 
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 自定义评测： 
//
// 评测系统 的输入如下（你设计的程序 不适用 此输入）： 
//
// 
// intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0 
// listA - 第一个链表 
// listB - 第二个链表 
// skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数 
// skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数 
// 
//
// 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视
//作正确答案 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, 
//skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 1 <= m, n <= 3 * 10⁴ 
// 1 <= Node.val <= 10⁵ 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB] 
// 
//
// 
//
// 进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？ 
//
// Related Topics 哈希表 链表 双指针 👍 1813 👎 0

/*
	执行耗时:588 ms,击败了70.00% 的Scala用户
	内存消耗:57 MB
	,击败了60.00% 的Scala用户
 */
class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Solution {
    def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
        /*方法1:
        解答成功:
          执行耗时:688 ms,击败了10.00% 的Scala用户
          内存消耗:56.5 MB,击败了100.00% 的Scala用户

        var lenA = 1
        var lenB = 1
        var tmpA = headA
        var tmpB = headB
        while (tmpA.next != null) {
            lenA += 1
            tmpA = tmpA.next
        }
        while (tmpB.next != null) {
            lenB += 1
            tmpB = tmpB.next
        }
        // 表示没有相交
        if (tmpA != tmpB) return null
        val diff = Math.abs(lenA - lenB)
        tmpA = headA
        tmpB = headB
        if (lenA > lenB) {
            for (_ <- 0 until diff) {
                tmpA = tmpA.next
            }
        } else if (lenA < lenB) {
            for (_ <- 0 until diff) {
                tmpB = tmpB.next
            }
        }
        while (tmpA != null && tmpB != null) {
            if (tmpA == tmpB) return tmpB
            tmpA = tmpA.next
            tmpB = tmpB.next
        }
        null

         */
        // 方法2
        /*
         * 基本思路：将某一条链表的结尾接到另一条链表的头上，这样当遍历过len(A)+len(B)轮后, tmpA和tmpB就会处于同一起点, 例子如下:
         * a1,a2,c1,c2,c3,b1,b2,b3,|c1,c2,c3
         * b1,b2,b3,c1,c2,c3,a1,a2,|c1,c2,c3
         * tmpA遍历轮次 = a_distinct(非相较部分) + common + b_distinct
         * tmpB遍历轮次 = b_distinct(非相较部分) + common + a_distinct
         */
        if (headA == null || headB == null) return null
        var tmpA = headA
        var tmpB = headB
        while (tmpA != tmpB) {
            tmpA = if (tmpA == null) headB else tmpA.next
            tmpB = if (tmpB == null) headA else tmpB.next
        }
        tmpA
    }
}
//leetcode submit region end(Prohibit modification and deletion)
