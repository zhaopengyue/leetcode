package leetcode.editor.cn.t_230_二叉搜索树中第_k小的元素
//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 764 👎 0

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

/**
 * 解答成功:
	执行耗时:552 ms,击败了75.00% 的Scala用户
	内存消耗:56.6 MB,击败了50.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util
/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 * var value: Int = _value
 * var left: TreeNode = _left
 * var right: TreeNode = _right
 * }
 */
object Solution {
  def kthSmallest(root: TreeNode, k: Int): Int = {
    val stack = new util.LinkedList[TreeNode]()
    var sort = 1
    // 基于二叉树的中序遍历计算 左->中->右
    var currNode = root
    while (currNode != null || !stack.isEmpty) {
      while (currNode != null) {
        stack.push(currNode)
        currNode = currNode.left
      }
      // 左子树遍历完成
      if (! stack.isEmpty) {
          val node = stack.poll()
          if (sort == k) {
              return node.value
          }
          sort += 1
          // 设置右子树为root, 继续遍历右子树
          currNode = node.right
      }
    }

    // 循环内一定会返回, 此处仅用于声明语法
    root.value
  }
}
//leetcode submit region end(Prohibit modification and deletion)
