package leetcode.editor.cn.t_101_对称二叉树
//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2083 👎 0
/*
* > 2022/08/29 20:51:14
解答成功:
	执行耗时:540 ms,击败了36.36% 的Scala用户
	内存消耗:54.6 MB,击败了100.00% 的Scala用户
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
import java.util
object Solution {

    def isSymmetric(root: TreeNode): Boolean = {
        val queue = new util.LinkedList[TreeNode]()
        // 将左右孩子入队
        queue.add(root.left)
        queue.add(root.right)
        while (! queue.isEmpty) {
           // 取出两个节点
            val left = queue.poll()
            val right = queue.poll()
            if (left == null && right == null) {
                // continue语句
            } else if (left == null || right == null) {
                // 有一个为null即不对称
                return false
            } else {
                // 皆非null
                if (left.value != right.value) {
                    return false
                }
                queue.add(left.left)
                queue.add(right.right)
                queue.add(left.right)
                queue.add(right.left)
            }
        }
        true
    }

    /*
    * 解答成功:
      执行耗时:604 ms,击败了9.09% 的Scala用户
      内存消耗:55.6 MB,击败了9.09% 的Scala用户
    def isSymmetric(root: TreeNode): Boolean = {
        val queue = new util.LinkedList[TreeNode]()
        queue.add(root)
        var level = 0
        while (! queue.isEmpty) {
            val size = queue.size()
            // 除第一行外，其他行为奇数时一定不对称
            if (level != 0 && size % 2 != 0) return false
            // 这里假设上层已经验证是ok的了，只需要验证子节点是否一致
            val data = new Array[Int](size * 2)
            var i = 0
            while (i < size) {
                val node = queue.poll()
                data(i*2) = if (node.left != null) {
                    queue.add(node.left)
                    node.left.value
                } else {
                    Int.MaxValue
                }
                data(i*2+1) = if (node.right != null) {
                    queue.add(node.right)
                    node.right.value
                } else {
                    Int.MaxValue
                }
                i += 1
            }
            // 检查下data数组是否对称即可
            var p = 0
            var q = data.length - 1
            while (p < q) {
                if (data(p) != data(q)) return false
                p += 1
                q -= 1
            }
            level += 1
        }
        true
    }
     */
}
//leetcode submit region end(Prohibit modification and deletion)
