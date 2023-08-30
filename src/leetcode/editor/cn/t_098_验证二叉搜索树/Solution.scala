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

    // arr[0] -> minV arr[1] -> maxV
    private var arr: Array[Long] = _

    def isValidBSTPri(root: TreeNode): Boolean = {
        // 空节点直接返回
        if (root == null) return true
        // 叶子结点的最大值和最小值均为本身
        if (root.left == null && root.right == null) {
            arr(0) = root.value
            arr(1) = root.value
            return true
        }
        // 非叶子结点
        // 计算左子树最小值, root的值必须比左子树最大值大
        if (root.left != null) {
            if (!isValidBSTPri(root.left) || root.value <= arr(1)) return false
        } else {
            arr(0) = Long.MaxValue
        }
        // 暂存最小值
        val min = arr(0)

        // 计算右子树最大值, root的值必须比右子树最小值小
        if (root.right != null) {
            if (!isValidBSTPri(root.right) || root.value >= arr(0)) return false
        } else {
            arr(1) = Long.MinValue
        }
        // 暂存最大值
        val max = arr(1)

        // 若上述校验通过, 则说明以root为根的树为二叉搜索树, 该树的最小值为左子树最小值, 最大值为右子树最大值
        arr(0) = Math.min(min, root.value)
        arr(1) = Math.max(max, root.value)
        true
    }

    def isValidBST(root: TreeNode): Boolean = {
       arr = Array(Long.MaxValue, Long.MinValue)
       isValidBSTPri(root)
    }

}
//leetcode submit region end(Prohibit modification and deletion)
