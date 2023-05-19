package leetcode.editor.cn.t_124_二叉树中的最大路径和
//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
// 
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1724 👎 0

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
object Solution {

    // 注意不要在这里直接赋值，因为maxV是静态变量，多个测试案例会共享该值，故每次皆需要初始化
    var maxV: Int = _

    def maxPathSum(root: TreeNode): Int = {
        maxV = Int.MinValue
        f(root)
        maxV
    }

    /**
     * 解析：
     * 指定某个节点为根时，一条经过root的最大路径：这条路径可能是：
     * 1. 左边某条路径 + root + 右边某条路径(左右子树的路径加上当前节点)
     * 2. 左边某条路径 + root (左子树的路径加上当前节点)
     * 3. root + 右边某条路径 (右子树的路径加上当前节点)
     * 4. root
     * 然而这四种情况只是用来计算以当前节点根的最大路径，如果当前节点上面还有节点，那它的父节点是不能累加第1种情况的（因为需要和上层构成
     * 一条新的路径，故只能在左右节点中选择一个最大的保留）
     * 所以要保存两个最大值，一个是当前节点下最大路径和maxCurrent（没有父节点），另一个是如果要连接父节点时最大的路径和maxSum。
     * */
    def f(node: TreeNode): Int = {
        if (node == null) return 0
        // 计算左子树节点和
        val left = f(node.left)
        // 计算右子树最大节点
        val right = f(node.right)
        maxV = Math.max(maxV, left + node.value + right)
        Array(0, left + node.value, right + node.value).max
    }
}
//leetcode submit region end(Prohibit modification and deletion)
