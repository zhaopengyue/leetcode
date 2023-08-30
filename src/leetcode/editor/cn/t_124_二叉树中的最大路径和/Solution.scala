package leetcode.editor.cn.t_124_二叉树中的最大路径和

import leetcode.editor.cn.utils.TreeNode
import leetcode.editor.cn.utils.Utils.generateTreeNode
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
    var maxSum: Int = _

    def maxPathSum(root: TreeNode): Int = {
        maxSum = -1000
        Math.max(f(root), maxSum)
    }

    /**
     * 解析：
     *  所有树的题目，都想成一颗只有根、左节点、右节点 的小树。然后一颗颗小树构成整棵大树，所以只需要考虑这颗小树即可。接下来分情况，
     *  按照题意：一颗三个节点的小树的结果只可能有如下6种情况：
            根 + 左 + 右
            根 + 左
            根 + 右
            根
            左
            右
        分析上述6种情况， 只有 2,3,4 可以向上累加，而1,5,6不可以累加（这个很好想，情况1向上累加的话，必然出现分叉，情况5和6直接就跟上面的树枝断开的
    ，   没法累加），所以我们找一个全局变量存储 1,5,6这三种不可累加的最大值， 另一方面咱们用遍历树的方法求2,3,4这三种可以累加的情况。 最后把两
        类情况得到的最大值再取一个最大值即可。
     * */
    def f(node: TreeNode): Int = {
        if (node == null) return -1000
        // 计算左子树节点和
        val left = f(node.left)
        // 计算右子树最大节点
        val right = f(node.right)
        maxSum = Array(node.value + left + right, left, right, maxSum).max
        Array(node.value + left, node.value + right, node.value).max
    }
}
//leetcode submit region end(Prohibit modification and deletion)
