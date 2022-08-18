package leetcode.editor.cn.t_109_有序链表转换二叉搜索树
//给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [-10,-3,0,5,9]
//输出: [0,-3,9,-10,null,5]
//解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
// 
//
// 示例 2: 
//
// 
//输入: head = []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// head 中的节点数在[0, 2 * 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 745 👎 0

class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
}

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}

/*
* 解答成功:
	执行耗时:1652 ms,击败了80.00% 的Scala用户
	内存消耗:62.3 MB,击败了80.00% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def sortedListToBST(head: ListNode): TreeNode = {
        if (head == null) return null
        make(head)
    }

    // 返回以head为根的树
    def make(head: ListNode): TreeNode = {
        // 递归终止条件
        if (head == null) return null
        // 返回叶子节点
        if (head.next == null) return new TreeNode(head.x, null, null)

        var prev: ListNode = null
        var i = head
        var j = head
        // 基于快慢指针求出中间节点
        while (j.next != null && j.next.next != null) {
            prev = i
            i = i.next
            j = j.next.next
        }
        /*
        * 此时i为中间节点，将prev后面的部分断链
        * 因为中间节点左侧可能为空（i==head时），右侧链则不会空，故左侧head特殊处理，不存在时填null，否则使用原head
        * */
        var leftHead = head
        val iNext = i.next
        if (prev != null) prev.next = null
        if (i == head) leftHead = null
        // 中间节点为根节点
        new TreeNode(i.x, make(leftHead), make(iNext))
    }
}
//leetcode submit region end(Prohibit modification and deletion)
