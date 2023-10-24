package leetcode.editor.cn.t_155_最小栈

import leetcode.editor.cn.utils.Utils._

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
// 
//
// Related Topics 栈 设计 👍 1664 👎 0

/**
解答成功:
	执行耗时:592 ms,击败了100.00% 的Scala用户
	内存消耗:59.6 MB,击败了100.00% 的Scala用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
case class Node(var x: Int = Int.MaxValue, var next: Node = null, var prev: Node = null, var m_prev: Node = null)

class MinStack() {

    private val head = Node()
    private var tail = head
    private var mini = head


    def push(v: Int): Unit = {
        val node = Node(v)
        node.prev = tail
        tail.next = node
        tail = node
        if (v < mini.x) {
            node.m_prev = mini
            mini = node
        }
    }

    def pop() {
        if (mini == tail) mini = mini.m_prev
        tail = tail.prev
        // 便于GC
        tail.next = null
    }

    def top(): Int = {
        tail.x
    }

    def getMin(): Int = {
        mini.x
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
//leetcode submit region end(Prohibit modification and deletion)
