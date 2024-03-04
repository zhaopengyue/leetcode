package leetcode.editor.cn.t_098_验证二叉搜索树
//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2134 👎 0

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}

/**
 * 解答成功:
	执行耗时:504 ms,击败了66.67% 的Scala用户
	内存消耗:56.2 MB,击败了100.00% 的Scala用户
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

    def isValidBST(root: TreeNode): Boolean = {
        check(root, Long.MinValue, Long.MaxValue)
    }

    private def check(root: TreeNode, min: Long, max: Long): Boolean = {
        if (root == null) return true
        // 检查当前节点是否满足最小最小值
        if (root.value <= min || root.value >= max) return false
        if (root.left != null) {
            if (root.left.value >= root.value) return false
            // 左结点满足规则, 递归检查左子树, 若不满足, 则直接返回false
            if (!check(root.left, min, root.value)) return false
        }
        if (root.right != null) {
            if (root.right.value <= root.value) return false
            if (!check(root.right, root.value, max)) return false
        }
        // 所有检查皆通过
        true
    }

}
//leetcode submit region end(Prohibit modification and deletion)
