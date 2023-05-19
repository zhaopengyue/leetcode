package leetcode.editor.cn.t_105_从前序与中序遍历序列构造二叉树

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1710 👎 0

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}
/*
 *解答成功:
	执行耗时:636 ms,击败了60.00% 的Scala用户
	内存消耗:55.5 MB,击败了86.67% 的Scala用户
* */
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
    def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
        val map = new mutable.HashMap[Int, Int]
        for (item <- inorder.zipWithIndex) {
            map += (item._1 -> item._2)
        }
        deal(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map.toMap)
     }

    /*
    * 计算[pStart,pEnd]数组的树，并返回根
    * */
    def deal(preorder: Array[Int], inorder: Array[Int], pStart: Int, pEnd: Int, iStart: Int, iEnd: Int, iMap: Map[Int, Int]): TreeNode = {
        // 可以用pStart和pEnd比较，此时四个值应该是一致的
        if (iStart == iEnd) {
            return new TreeNode(inorder(iStart))
        }
        // 当前序列的根
        val rootValue = preorder(pStart)
        val rootNode = new TreeNode(rootValue)
        val leftChildNum = iMap(rootValue) - iStart
        val rightChildNum = iEnd - iMap(rootValue)
        if (leftChildNum != 0) {
            // 构建左结点数组并返回其根
            rootNode.left = deal(preorder, inorder, pStart + 1, pStart + leftChildNum, iStart, iMap(rootValue) - 1, iMap)
        }
        if (rightChildNum != 0) {
            // 构建右节点数组并返回其根
            rootNode.right = deal(preorder, inorder, pStart + leftChildNum + 1, pEnd, iMap(rootValue) + 1, iEnd, iMap)
        }
        rootNode
    }
}
//leetcode submit region end(Prohibit modification and deletion)
