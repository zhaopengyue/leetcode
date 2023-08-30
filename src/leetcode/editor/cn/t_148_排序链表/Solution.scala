package leetcode.editor.cn.t_148_排序链表

import leetcode.editor.cn.utils.Utils
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2044 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x

  override def toString: String = s"[$x->${next.x}]"
}

/**
 * 解答成功:
	执行耗时:864 ms,击败了42.86% 的Scala用户
	内存消耗:66.4 MB,击败了71.43% 的Scala用户
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
  def sortList(head: ListNode): ListNode = {
    // 递归终止条件 ==> 拆分为单个节点
    if (head == null || head.next == null) {
      return head
    }

    // 基于快慢指针,将链表拆分为两部分
    var slow, fast = head
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next
      fast = fast.next.next
    }

    // slow为中间节点的上一个节点
    // 拆链
    val head2 = slow.next
    slow.next = null

    val l = sortList(head)
    val r = sortList(head2)

    // 合并两条链
    merge(l, r)
  }

  // merge l1和l2
  private def merge(l1: ListNode, l2: ListNode): ListNode = {
    val vHead = new ListNode()
    var tail = vHead

    var p = l1
    var q = l2
    while (p != null && q != null) {
      if (p.x < q.x) {
        tail.next = p
        p = p.next
      } else {
        tail.next = q
        q = q.next
      }
      tail = tail.next
    }
    if (p != null) tail.next = p
    if (q != null) tail.next = q

    vHead.next
  }

  def main(args: Array[String]): Unit = {
    val a = new ListNode(4)
    val b = new ListNode(2)
    val c = new ListNode(1)
    val d = new ListNode(3)

    a.next = b
    b.next = c
    c.next = d

    val m = sortList(a)

    println(m.x)
    println(m.next.x)
    println(m.next.next.x)
    println(m.next.next.next.x)

  }




}
//leetcode submit region end(Prohibit modification and deletion)
