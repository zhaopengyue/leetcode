package leetcode.editor.cn.test

import leetcode.editor.cn.t_143_重排链表.{ListNode, Solution}


/**
 * @author zhaopengyue
 * @date 2022/7/27
 */

object Test {
  def main(args: Array[String]): Unit = {
    //val node8 = new ListNode(8, null)
    //val node7 = new ListNode(5, null)
    //val node6 = new ListNode(4, node7)
    //val node5 = new ListNode(5, null)
    //val node4 = new ListNode(4, node5)
    //val node3 = new ListNode(3, node4)
    val node2 = new ListNode(2, null)
    val head = new ListNode(1, node2)
    Solution.reorderList(head)
    //println(Solution.maxProfit(Array(7,1,5,3,6,4)))
  }
}
