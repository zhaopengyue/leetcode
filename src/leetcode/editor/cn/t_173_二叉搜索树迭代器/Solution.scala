package leetcode.editor.cn.t_173_二叉搜索树迭代器

import leetcode.editor.cn.utils.Utils._

//实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
//
// 
// 
// 
// BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出
//。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。 
// boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。 
// int next()将指针向右移动，然后返回指针处的数字。 
// 
// 
// 
//
// 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。 
//
// 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。 
//
// 
//
// 示例： 
// 
// 
//输入
//["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", 
//"hasNext", "next", "hasNext"]
//[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
//输出
//[null, 3, 7, true, 9, true, 15, true, 20, false]
// 
//
//解释
//BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
//bSTIterator.next(); // 返回 3
//bSTIterator.next(); // 返回 7
//bSTIterator.hasNext(); // 返回 True
//bSTIterator.next(); // 返回 9
//bSTIterator.hasNext(); // 返回 True
//bSTIterator.next(); // 返回 15
//bSTIterator.hasNext(); // 返回 True
//bSTIterator.next(); // 返回 20
//bSTIterator.hasNext(); // 返回 False
//
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁵] 内 
// 0 <= Node.val <= 10⁶ 
// 最多调用 10⁵ 次 hasNext 和 next 操作 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计一个满足下述条件的解决方案吗？next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，并使用 O(h) 内存。其中 h 是树的高
//度。 
// 
//
// Related Topics 栈 树 设计 二叉搜索树 二叉树 迭代器 👍 729 👎 0

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}

/**
 * 解答成功:
 * 执行耗时:652 ms,击败了80.00% 的Scala用户
 * 内存消耗:62.6 MB,击败了20.00% 的Scala用户
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
class BSTIterator(_root: TreeNode) {

    // 非递归中序遍历
    private val stack = new mutable.ArrayStack[TreeNode]()
    private var curr = _root
    init()

    private def init(): Unit = {
        // 将curr指向指向以当前curr为root的子树的最左下节点
        while (curr != null) {
            stack.push(curr)
            curr = curr.left
        }
    }

    def next(): Int = {
        val node = stack.pop()
        curr = node.right
        init()
        node.value
    }

    def hasNext(): Boolean = stack.nonEmpty

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
//leetcode submit region end(Prohibit modification and deletion)
