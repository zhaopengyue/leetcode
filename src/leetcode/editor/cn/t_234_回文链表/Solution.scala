package leetcode.editor.cn.t_234_回文链表
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1723 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

/*
 * 基本思路是反转后半部分, 例如原始链表: 0 -> 1 -> 1 -> 0
 * 经过反转后, 变为: 0 -> 1 <- 1 <- 0
 * 然后从两侧两个头指针开始遍历，依次比较值, 循环终止条件为:
 * 1: p.x != q.x : 非回文, return false
 * 2: p.next == q.next: 两者的next相同, 当节点数为奇数时存在这种情况, 此时前面节点皆已经比较完成并皆相等, 故直接返回true
 * 3: p.next == q || p == q.next: 两者互相指向对方, 当节点数为偶数时存在这种情况，前置节点已经比较完成, 故仅需 比较当前两个节点即可确定是否为回文
 *
 * 解答成功:
	执行耗时:820 ms,击败了100.00% 的Scala用户
	内存消耗:66.9 MB,击败了90.00% 的Scala用户
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
    def isPalindrome(head: ListNode): Boolean = {

      if (head.next == null) return true

      var p, q = head
      // 基于快慢指针变形, 通过该方式遍历结束后, p位于中间位置(奇数情况)及中间偏左位置(偶数情况)
      while (q.next != null && q.next.next != null) {
        p = p.next
        q = q.next.next
      }

      var preP = p
      p = p.next
      // 反转p后续节点
      while (p != null) {
        val tmp = p.next
        p.next = preP
        preP = p
        p = tmp
      }

      p = head
      // preP即为反转后的新头节点
      q = preP

      while (true) {
        if (p.x != q.x) return false
        if (p.next == q.next) return true // 奇数情况, 退出循环
        if (p.next == q || q.next == p) return p.x == q.x// 偶数情况, 退出循环
        p = p.next
        q = q.next
      }

      // 任何情况下会在循环内直接返回结果, 此处false仅声明语法
      false
    }
}
//leetcode submit region end(Prohibit modification and deletion)
