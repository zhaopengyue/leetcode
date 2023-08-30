package leetcode.editor.cn.t_437_路径总和_i_i_i

import leetcode.editor.cn.utils._
import leetcode.editor.cn.utils.Utils._
//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1690 👎 0

/**
 * 解答成功:
	执行耗时:536 ms,击败了66.67% 的Scala用户
	内存消耗:57.4 MB,击败了0.00% 的Scala用户
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
import scala.collection.mutable
object Solution {

  // 保存从root到currNode为止每一个前缀和对应的个数
  private var map: mutable.HashMap[Long, Int] = _

  def pathSum(root: TreeNode, targetSum: Int): Int = {
    map = new mutable.HashMap[Long, Int]()
    map.put(0, 1)
    rootSum(root, 0, targetSum)
  }


  def rootSum(root: TreeNode, currSum: Long, targetSum: Long): Int = {
    if (root == null) return 0

    val curr = currSum + root.value

    // 两者差值
    val other = curr - targetSum
    var ret = 0

    if (map.contains(other)) ret += map(other)

    // 加入前缀和
    map.put(curr, map.getOrElse(curr, 0) + 1)

    // 计算下一层
    ret += rootSum(root.left, curr, targetSum)
    ret += rootSum(root.right, curr, targetSum)

    // 回退当前节点时清除当前节点的前缀和, 防止干扰
    map.put(curr, map(curr) - 1)

    ret
  }
}
//leetcode submit region end(Prohibit modification and deletion)
