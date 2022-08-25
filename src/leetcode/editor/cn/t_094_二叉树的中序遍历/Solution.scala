package leetcode.editor.cn.t_094_二叉树的中序遍历
//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1533 👎 0

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}
/*
* 解答成功:
	执行耗时:492 ms,击败了66.67% 的Scala用户
	内存消耗:54.8 MB,击败了57.14% 的Scala用户
* */
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
import scala.collection.mutable.ListBuffer
object Solution {
    def inorderTraversal(root: TreeNode): List[Int] = {
        if (root == null) return List.empty[Int]
        // 这里基于非递归进行处理
        val stack = new mutable.Stack[TreeNode]()
        val buffer = new ListBuffer[Int]
        var currNode = root
        while (stack.nonEmpty || currNode != null) {
            // 处理左节点
            while (currNode != null) {
                stack.push(currNode)
                currNode = currNode.left
            }
            // 表示处理完了左结点
            if (stack.nonEmpty) {
                buffer.append(stack.head.value)
                currNode = stack.pop().right
            }
        }
        buffer.toList
    }
}
//leetcode submit region end(Prohibit modification and deletion)
