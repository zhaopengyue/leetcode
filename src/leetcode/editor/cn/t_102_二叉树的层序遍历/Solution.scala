package leetcode.editor.cn.t_102_二叉树的层序遍历
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1428 👎 0

/*
* 解答成功:
	执行耗时:580 ms,击败了6.67% 的Scala用户
	内存消耗:55.2 MB,击败了93.33% 的Scala用户
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
    def levelOrder(root: TreeNode): List[List[Int]] = {
        if (root == null) return List.empty[List[Int]]

        val queue = new mutable.Queue[TreeNode]()
        val rs = new ListBuffer[List[Int]]
        queue.enqueue(root)
        while (queue.nonEmpty) {
            val tmp = new ListBuffer[Int]
            for (_ <- queue.indices) {
                val node = queue.dequeue()
                tmp += node.value
                if (node.left != null) {
                    queue.enqueue(node.left)
                }
                if (node.right != null) {
                    queue.enqueue(node.right)
                }
            }
            rs += tmp.toList
        }
        rs.toList
    }
}
//leetcode submit region end(Prohibit modification and deletion)
