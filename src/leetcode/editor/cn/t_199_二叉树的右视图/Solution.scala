package leetcode.editor.cn.t_199_二叉树的右视图
//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 743 👎 0

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}
/*
解答成功:
	执行耗时:480 ms,击败了100.00% 的Scala用户
	内存消耗:54.9 MB,击败了100.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
import java.util
import scala.collection.mutable.ListBuffer
object Solution {
    def rightSideView(root: TreeNode): List[Int] = {
        // 两种特殊情况
        if (root == null) return List.empty[Int]
        val queue = new util.LinkedList[TreeNode]()
        // 直接将根的右孩子入队
        queue.add(root)
        val buffer = new ListBuffer[Int]
        while (!queue.isEmpty) {
            var index = 0
            val size = queue.size()
            while (index < size) {
                val node = queue.poll()
                if (index == size - 1) {
                    buffer.append(node.value)
                }
                if (node.left != null) {
                    queue.add(node.left)
                }
                if (node.right != null) {
                    queue.add(node.right)
                }
                index += 1
            }

        }
        buffer.toList
    }
}
//leetcode submit region end(Prohibit modification and deletion)
