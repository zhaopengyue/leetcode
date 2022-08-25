package leetcode.editor.cn.t_103_二叉树的锯齿形层序遍历

//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
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
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 681 👎 0

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}
/*
* 解答成功:
	执行耗时:596 ms,击败了50.00% 的Scala用户
	内存消耗:55.4 MB,击败了50.00% 的Scala用户
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
    def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
        if (root == null) return List.empty[List[Int]]

        var level = 0
        val queue = new mutable.Queue[TreeNode]()
        val rs = new ListBuffer[List[Int]]
        queue.enqueue(root)
        while (queue.nonEmpty) {
            var tmp = new ListBuffer[Int]
            val isLeft = level % 2 == 0
            for (_ <- queue.indices) {
                val node = queue.dequeue()
                if (isLeft) {
                    // 从左向右
                    tmp += node.value
                } else {
                    // 右边的放前面
                    tmp = node.value +: tmp
                }
                if (node.left != null) {
                    queue.enqueue(node.left)
                }
                if (node.right != null) {
                    queue.enqueue(node.right)
                }
            }
            level += 1
            rs += tmp.toList
        }
        rs.toList
    }
}
//leetcode submit region end(Prohibit modification and deletion)
