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

        val numStrArr = num.toString.toCharArray
        var currMaxCI = numStrArr.length - 1
        // 左侧待交换节点
        var p = -1
        // 右侧尽量靠右侧的节点
        var q = -1
        // 计算每个元素包含自己右侧最大的元素索引
        numStrArr.indices.reverse.foreach(i => {
            val currChar = numStrArr(i)
            if (currChar > numStrArr(currMaxCI)) {
                currMaxCI = i
            } else if (currChar < numStrArr(currMaxCI)) {
                // 尽可能使得p向左，q向右
                p = i
                q = currMaxCI
            }
        })

        if (p != -1) {
            // 原始非倒序排列
            val tmp = numStrArr(p)
            numStrArr(p) = numStrArr(q)
            numStrArr(q) = tmp
        }

        new String(numStrArr).toInt
    }
}
//leetcode submit region end(Prohibit modification and deletion)
