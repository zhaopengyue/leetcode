package leetcode.editor.cn.t_530_二叉搜索树的最小绝对差

import leetcode.editor.cn.utils.Utils._

//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 542 👎 0

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}

/**
 * > 2024/03/03 18:12:21
 * 解答成功:
 * 执行耗时:693 ms,击败了0.00% 的Scala用户
 * 内存消耗:59.6 MB,击败了0.00% 的Scala用户
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

    def getMinimumDifference(root: TreeNode): Int = {
        var currNode = root
        val stack = new util.LinkedList[TreeNode]()
        var last: TreeNode = null
        var min = Int.MaxValue

        while (! stack.isEmpty || currNode != null) {
            while (currNode != null) {
                stack.push(currNode)
                currNode = currNode.left
            }
            if (! stack.isEmpty) {
                val curr = stack.pop()
                if (last != null) {
                    min = math.min(min, curr.value - last.value)
                }
                last = curr
                currNode = curr.right
            }
        }
        min
    }



}
//leetcode submit region end(Prohibit modification and deletion)
