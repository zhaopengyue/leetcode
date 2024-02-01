package leetcode.editor.cn.t_222_完全二叉树的节点个数

import leetcode.editor.cn.utils.Utils._

//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
//
// Related Topics 位运算 树 二分查找 二叉树 👍 1083 👎 0

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}

/**
 * 解答成功:
 * 执行耗时:559 ms,击败了25.00% 的Scala用户
 * 内存消耗:58.3 MB,击败了100.00% 的Scala用户
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
object Solution {
    def countNodes(root: TreeNode): Int = {
        if (root == null) return 0
        // 基于层序遍历
        val queue = new util.LinkedList[TreeNode]()
        var level = 1
        queue.push(root)

        while (! queue.isEmpty) {
            var childNum = 0
            var levelNodeNum = queue.size()
            while (levelNodeNum > 0) {
                val node = queue.poll()
                if (node.left == null) {
                    return (math.pow(2, level) - 1 + childNum).toInt
                }
                queue.add(node.left)
                childNum += 1
                if (node.right == null) {
                    return (math.pow(2, level) - 1 + childNum).toInt
                }
                queue.add(node.right)
                childNum += 1
                levelNodeNum -= 1
            }
            level += 1
        }
        -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)
