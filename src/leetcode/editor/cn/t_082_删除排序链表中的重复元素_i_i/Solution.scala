package leetcode.editor.cn.t_082_删除排序链表中的重复元素_i_i
//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 双指针 👍 969 👎 0

/*
* 解答成功:
	执行耗时:572 ms,击败了7.69% 的Scala用户
	内存消耗:55.3 MB,击败了38.46% 的Scala用户
* */
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 * var next: ListNode = _next
 * var x: Int = _x
 * }
 */
object Solution {
  def deleteDuplicates(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
      val vHead = new ListNode(Int.MinValue, null)
      var p = vHead
      var q = head
      while (q != null) {
          val v = q.x
          // 判断下一个元素是否和当前一致，若一致，则可能有重复
          if (q.next != null && q.next.x == v) {
              var tmp = q.next
              // 说明存在重复，循环跳过
              while (tmp != null && tmp.x == v) {
                  tmp = tmp.next
              }
              // 去完重复后q重置到不重复的下一个元素
              q = tmp
          } else {
              // 说明不存在重复或者为最后一个节点
              val qNext = q.next
              // 易出错点：这里需要做断链
              q.next = null
              p.next = q
              p = q
              q = qNext
          }
      }
      vHead.next
  }
}
//leetcode submit region end(Prohibit modification and deletion)
