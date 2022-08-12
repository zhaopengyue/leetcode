package leetcode.editor.cn.t_021_合并两个有序链表
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 2596 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

/*
* 解答成功:
	执行耗时:524 ms,击败了66.67% 的Scala用户
	内存消耗:55.6 MB,击败了17.78% 的Scala用户
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
    def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
        // 构建虚拟头结点
        val vHead = new ListNode()
        var l0 = vHead
        // 按照归并排序思路依次处理每一个队列
        var l1 = list1
        var l2 = list2
        while (l1 != null && l2 != null) {
            var minNode: ListNode = null
            if (l1.x < l2.x) {
                minNode = l1
                l1 = l1.next
            } else {
                minNode = l2
                l2 = l2.next
            }
            l0.next = minNode
            l0 = l0.next
        }
        if (l1 == null) {
            l0.next = l2
        }
        if (l2 == null) {
            l0.next = l1
        }
        vHead.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)
