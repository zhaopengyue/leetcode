package leetcode.editor.cn.t_117_填充每个节点的下一个右侧节点指针_i_i

import leetcode.editor.cn.utils.Utils._

//给定一个二叉树： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。 
//
// 初始状态下，所有 next 指针都被设置为 NULL 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 6000] 内 
// -100 <= Node.val <= 100 
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。 
// 
//
// 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 824 👎 0

class Node(var _value: Int) {
    var value: Int = _value
    var left: Node = null
    var right: Node = null
    var next: Node = null
}

/**
 * 解答成功:
 * 执行耗时:496 ms,击败了40.00% 的Scala用户
 * 内存消耗:55.3 MB,击败了50.00% 的Scala用户
 *
 */
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var left: Node = null
 *   var right: Node = null
 *   var next: Node = null
 * }
 */
object Solution {
    def connect(root: Node): Node = {
        if (root == null) return root
        val queue = new java.util.LinkedList[Node]()
        // 层序遍历
        queue.add(root)
        val list = new java.util.ArrayList[Node]()
        while (! queue.isEmpty) {
            list.clear()
            var size = queue.size()
            while (size > 0) {
                val node = queue.poll()
                list.add(node)
                if (node.left != null) queue.add(node.left)
                if (node.right != null) queue.add(node.right)
                size -= 1
            }
            var i = list.size() - 1
            var next: Node = null
            while (i >= 0) {
                val curr = list.get(i)
                curr.next = next
                next = curr
                i -= 1
            }
        }
        root
    }
}
//leetcode submit region end(Prohibit modification and deletion)
