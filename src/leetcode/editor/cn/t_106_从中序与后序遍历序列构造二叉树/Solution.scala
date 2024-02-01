package leetcode.editor.cn.t_106_从中序与后序遍历序列构造二叉树

import leetcode.editor.cn.utils.Utils._

//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1162 👎 0

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}

/**
 * 解答成功:
 * 执行耗时:596 ms,击败了100.00% 的Scala用户
 * 内存消耗:57.8 MB,击败了66.67% 的Scala用户
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
import scala.collection.mutable
object Solution {
    def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
        val map = new mutable.HashMap[Int, Array[Int]]()
        inorder.indices.foreach(i => {
            val iv = inorder(i)
            val pv = postorder(i)
            if (! map.contains(iv)) {
                map += (iv -> Array.fill(2)(0))
            }
            if (!map.contains(pv)) {
                map += (pv -> Array.fill(2)(0))
            }
            map(iv)(0) = i // 0为中序
            map(pv)(1) = i // 1为后序
        })
        build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map)
    }

    // 返回构建范围内的节点的根节点
    private def build(inorder: Array[Int],
                      postorder: Array[Int],
                      iStart: Int,
                      iEnd: Int,
                      pStart: Int,
                      pEnd: Int,
                      map: mutable.HashMap[Int, Array[Int]]): TreeNode = {
        if (iStart == iEnd) return new TreeNode(inorder(iStart)) // 遍历到叶子结点
        // 后序遍历从尾到头遍历
        val rootV = postorder(pEnd)
        val root = new TreeNode(rootV)
        val inorderIndex = map(rootV)(0)
        val leftLen = inorderIndex - iStart
        val rightLen = iEnd - inorderIndex
        // 处理左子树
        if (leftLen != 0)
            root.left = build(inorder, postorder, iStart, inorderIndex - 1, pStart, pStart + leftLen - 1, map)
        // 处理右子树
        if (rightLen != 0)
            root.right = build(inorder, postorder, inorderIndex + 1, iEnd, pEnd - rightLen, pEnd - 1, map)
        root
    }
}
//leetcode submit region end(Prohibit modification and deletion)
