package leetcode.editor.cn.t_670_最大交换

import leetcode.editor.cn.utils.Utils._

//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 455 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    def maximumSwap(num: Int): Int = {

        val numStr = num.toString
        val maxArr = new Array[Int](numStr.length)
        var currMaxCI = -1
        var currMaxC = Char.MinValue
        numStr.indices.reverse.foreach(i => {
            val currChar = numStr.charAt(i)
            if (currMaxCI == -1) {
                maxArr(i) = currChar
                currMaxCI = i
            } else {
                // 比较当前值与当前最大值
                if (currChar >= )
            }
        })

        val queue = new java.util.Pri

        originArr.mkString.toInt
    }
}
//leetcode submit region end(Prohibit modification and deletion)
