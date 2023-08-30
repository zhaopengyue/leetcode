package leetcode.editor.cn.t_543_二叉树的直径

import leetcode.editor.cn.utils.TreeNode
//给你一棵二叉树的根节点，返回该树的 直径 。 
//
// 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。 
//
// 两节点之间路径的 长度 由它们之间边数表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5]
//输出：3
//解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1391 👎 0

/**
 * 解答成功:
	执行耗时:496 ms,击败了100.00% 的Scala用户
	内存消耗:56.6 MB,击败了40.00% 的Scala用户
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
object Solution {
    var max: Int = 0

    def diameterOfBinaryTree(root: TreeNode): Int = {
        max = 0
        maxDept(root)
        max
    }

    def maxDept(root: TreeNode): Int = {
        if (root == null) return 0
        // 计算左子树最大深度
        val leftDept = maxDept(root.left)
        // 计算右子树最大深度
        val rightDept = maxDept(root.right)
        // 以当前节点为root的直径 = 左子树最大深度 + 右子树最大深度
        max = Math.max(max, leftDept + rightDept)
        Math.max(leftDept, rightDept) + 1
    }
}
//leetcode submit region end(Prohibit modification and deletion)
