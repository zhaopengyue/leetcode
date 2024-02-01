package leetcode.editor.cn.utils

import scala.reflect.ClassTag
import java.util
import scala.language.implicitConversions

/**
 * @author zhaopengyue
 * @date 2022/7/27
 */

object Utils {

  /**
   * 生成二维数组
   * @param m 行
   * @param n 列
   * @param items 元素
   * @tparam T 类型
   * @return 二维数组
   */
  def mk_two_dimensional_arr[T: ClassTag](m: Int, n: Int, items: T*): Array[Array[T]] = {
    val arr = new Array[Array[T]](m)
    for (i <- items.indices) {
      val col = i % n
      val row = i / n
      if (col == 0) {
        arr(row) = new Array[T](n)
      }
      arr(row)(col) = items(i)
    }

    arr
  }

  /**
   * 生成二维数组，字符串范例为：[[2,1,1],[1,1,0],[0,1,1]]
   * @param caseString 二维数组字符串
   * @param op 转化为指定类型
   * @tparam T 类型
   * @return
   */
  def mk_two_dimensional_arr[T: ClassTag](caseString: String)(op: String => T): Array[Array[T]] = {
    for (line <- caseString.stripPrefix("[").stripSuffix("]").split("]"))
      yield line.replaceAll(",?\\[|\"|\'", "").split(",").map(op)
  }

  def print_two_dimensional_arr[T](arr: Array[Array[T]]): Unit = {
    println("[")
    for (line <- arr) {
      print("  [")
      print(line.mkString(","))
      println("]")
    }
    println("]")
  }

  /**
   * 生成树结构, 返回树的头结点--前序遍历
   * @param treeStr 数构造字符串, 范例[5,4,8,11,null,13,4,7,2,null,null,5,1],不去除两侧中括号
   * @return 树头结点
   */
  def generateTreeNode(treeStr: String): TreeNode = {
    val strs = treeStr.substring(1, treeStr.length - 1).split(",")
    val nums = new Array[Integer](strs.length)
    for (i <- 0 until strs.length) {
      if ("null" == strs(i)) nums(i) = null
      else nums(i) = strs(i).toInt
    }
    if (nums == null || nums.length == 0) return null
    val len = nums.length
    var index = 0
    val head = new TreeNode(nums(index))
    val nodeQueue = new util.LinkedList[TreeNode]
    nodeQueue.offer(head)
    var cur: TreeNode = null
    while ( {
      index < len
    }) {
      index += 1
      if (index >= len) return head
      cur = nodeQueue.poll()
      val left = nums(index)
      if (left != null) {
        cur.left = new TreeNode(left)
        nodeQueue.offer(cur.left)
      }
      index += 1
      if (index >= len) return head
      val right = nums(index)
      if (right != null) {
        cur.right = new TreeNode(right)
        nodeQueue.offer(cur.right)
      }
    }
    head
  }

  def main(args: Array[String]): Unit = {
    generateTreeNode("[3,9,20,null,null,15,7]")
  }


}
