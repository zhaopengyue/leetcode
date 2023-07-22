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
  def sortList(head: ListNode): ListNode = {
    sortListReverse(head, null)
  }

  def sortListReverse(start: ListNode, end: ListNode): ListNode = {
    var slow, fast = start
    if (start.next == end) {
      return start
    }
    /**
     * 获取[start,end)的中间节点
     */
    while (fast != end && fast.next != end) {
      slow = slow.next
      fast = fast.next.next
    }
    sortListReverse(start, slow)
    sortListReverse(slow, end)

    merge(start, slow, end)
  }

  // 按顺序合并[start,mid),[mid,end)区间
  private def merge(start: ListNode, mid: ListNode, end: ListNode): ListNode = {
    val vHead = new ListNode()
    var tail = vHead

    var p = start
    var q = mid
    while (p != mid && q != end) {
      if (p.x < q.x) {
        tail.next = p
        p = p.next
      } else {
        tail.next = q
        q = q.next
      }
      tail = tail.next
    }
    if (p != mid) tail.next = p
    if (q != end) tail.next = q

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

  }




}
//leetcode submit region end(Prohibit modification and deletion)
