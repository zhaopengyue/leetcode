package leetcode.editor.cn.t_104_二叉树的最大深度
//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1673 👎 0

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

/*
解答成功:
	执行耗时:520 ms,击败了55.56% 的Scala用户
	内存消耗:56.4 MB,击败了77.78% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 * var value: Int = _value
 * var left: TreeNode = _left
 * var right: TreeNode = _right
 * }
 */
object Solution {
  def maxDepth(root: TreeNode): Int = {
    if (root == null) return 0
    Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
  }
}
//leetcode submit region end(Prohibit modification and deletion)
