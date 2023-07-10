package leetcode.editor.cn.utils

import leetcode.editor.cn.t_143_重排链表.{ListNode, Solution}

import scala.reflect.ClassTag


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
}
