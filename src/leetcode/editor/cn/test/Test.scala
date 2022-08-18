package leetcode.editor.cn.test

import leetcode.editor.cn.t_109_有序链表转换二叉搜索树._


/**
 * @author zhaopengyue
 * @date 2022/7/27
 */

object Test {
  def main(args: Array[String]): Unit = {
    //val node8 = new ListNode(8, null)
    //val node7 = new ListNode(5, null)
    //val node6 = new ListNode(4, node7)
    val node5 = new ListNode(9, null)
    val node4 = new ListNode(5, node5)
    val node3 = new ListNode(0, node4)
    val node2 = new ListNode(3, node3)
    val head = new ListNode(-10, node2)
    val out = Solution.sortedListToBST(head)
  }
}
