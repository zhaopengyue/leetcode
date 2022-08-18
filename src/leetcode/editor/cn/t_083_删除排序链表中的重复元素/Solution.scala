package leetcode.editor.cn.t_083_删除排序链表中的重复元素
//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
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
// Related Topics 链表 👍 838 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
/*
* 解答成功:
	执行耗时:584 ms,击败了25.00% 的Scala用户
	内存消耗:55.5 MB,击败了16.67% 的Scala用户
* */
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
    var p = head
    var q = head.next
    while (q != null) {
      if (p.x != q.x) {
        p.next = q
        p = q
      } else {
        // 直接跳过重复
        q = q.next
      }
    }
    p.next = null
    // head指针一定是有效的，直接返回即可
    head
  }
}
//leetcode submit region end(Prohibit modification and deletion)
