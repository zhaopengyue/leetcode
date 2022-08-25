package leetcode.editor.cn.t_146__l_r_u_缓存
//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 2344 👎 0

/*
* 解答成功:
	执行耗时:1612 ms,击败了57.14% 的Scala用户
	内存消耗:165.8 MB,击败了85.71% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)

import scala.collection.mutable

class LRUCache(_capacity: Int) {

  case class Node(k: Int = 0, var v: Int = 0, var prev: Node = null, var next: Node = null)

  /* 维护双向队列 */
  class LRULinkList() {
    var size = 0
    // 虚拟头结点
    val vHead: Node = Node()
    // 尾结点
    var tail: Node = vHead

    /* 插入元素：尾插法 */
    def add(node: Node): Unit = {
      tail.next = node
      node.prev = tail
      node.next = null
      tail = node
      size += 1
    }

    /* 移除头部元素 */
    def removeFirst(): Node = {
      if (vHead.next == null) return null
      val first = vHead.next
      size -= 1
      if (tail == vHead.next) {
        tail = vHead
        vHead.next = null
        return first
      }
      vHead.next = vHead.next.next
      // 重置新头结点的prev
      if (vHead.next != null) {
        vHead.next.prev = vHead
      }
      first
    }

    /**/
    def remove(node: Node): Unit = {
      node.prev.next = node.next
      if (node.next != null) {
        node.next.prev = node.prev
      }
      if (node == tail) {
        tail = tail.prev
      }
      size -= 1
    }
  }

  var pool = new mutable.HashMap[Int, Node]()
  var lruList = new LRULinkList

  def get(key: Int): Int = {
    if (!pool.contains(key)) return -1
    // 池中包含
    val node = pool(key)
    // 移除
    lruList.remove(node)
    // 重新添加
    lruList.add(node)
    node.v
  }

  def put(key: Int, value: Int) {
    if (pool.contains(key)) {
      val node = pool(key)
      lruList.remove(node)
    } else {
      // 容量满了,移出队首元素
      if (lruList.size == _capacity) {
        val first = lruList.removeFirst()
        pool.remove(first.k)
      }
    }
    val node = Node(key, value)
    pool += (key -> node)
    lruList.add(node)
  }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
//leetcode submit region end(Prohibit modification and deletion)
