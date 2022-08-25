package leetcode.editor.cn.t_145_二叉树的后序遍历
//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 907 👎 0

/*
* 解答成功:
	执行耗时:488 ms,击败了63.64% 的Scala用户
	内存消耗:55.2 MB,击败了9.09% 的Scala用户
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
import scala.collection.mutable.ListBuffer
object Solution {

    case class Element(node: TreeNode, var visitNum: Int = 1)

    def postorderTraversal(root: TreeNode): List[Int] = {
        if (root == null) return List.empty[Int]
        // 这里使用非递归算法实现
        var curr = root
        val stack = new mutable.Stack[Element]()
        val rs = new ListBuffer[Int]
        while (stack.nonEmpty || curr != null) {
            while (curr != null) {
                stack.push(Element(curr))
                curr = curr.left
            }
            if (stack.nonEmpty) {
                // 检查左子树是否已经遍历完成
                if (stack.head.visitNum == 1) {
                    // 值为1表示左子树已经遍历完成，将该节点的值修改为2，然后继续遍历其右子树
                    stack.head.visitNum = 2
                    curr = stack.head.node.right
                } else {
                    // 值为2表示左右节点都已经遍历完成，将该节点出栈即可
                    rs += stack.pop().node.value
                }
            }
        }
        rs.toList
    }
}
//leetcode submit region end(Prohibit modification and deletion)
