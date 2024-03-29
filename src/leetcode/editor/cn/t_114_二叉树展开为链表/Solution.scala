package leetcode.editor.cn.t_114_二叉树展开为链表
//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
//
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1275 👎 0

/*
* 解答成功:
	执行耗时:636 ms,击败了50.00% 的Scala用户
	内存消耗:55.9 MB,击败了50.00% 的Scala用户
* */
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
import scala.collection.mutable
object Solution {
    def flatten(root: TreeNode): Unit = {
        if (root == null) return
        val stack = new mutable.ArrayStack[TreeNode]
        var curr = root
        var prev = root // prev表示遍历链的上一个遍历到的节点

        // 非递归前序遍历
        while (stack.nonEmpty || curr != null) {
            while (curr != null) {
                prev = curr
                stack.push(curr)
                curr = curr.left
            }
            // 所有左结点遍历结束
            if (stack.nonEmpty) {
                val node = stack.pop()
                prev.left = node.right // 将右子树整体放到上一次遍历的左子树的后面
                curr = node.right
            }
        }
        curr = root
        while (curr != null) {
            curr.right = curr.left
            curr.left = null
            curr = curr.right
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
