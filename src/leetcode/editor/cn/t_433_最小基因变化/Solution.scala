package leetcode.editor.cn.t_433_最小基因变化

import leetcode.editor.cn.utils.Utils._

//基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。 
//
// 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。 
//
// 
// 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。 
// 
//
// 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中） 
//
// 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成
//此基因变化，返回 -1 。 
//
// 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。 
//
// 
//
// 示例 1： 
//
// 
//输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
//"AAACGGTA"]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
//"AACCCCCC"]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// start.length == 8 
// end.length == 8 
// 0 <= bank.length <= 10 
// bank[i].length == 8 
// start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成 
// 
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 282 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
object Solution {

    def minMutation(startGene: String, endGene: String, bank: Array[String]): Int = {
      // 排除边界条件
      if (startGene == endGene) return 0
      val bankSet = bank.toSet
      if (bank.isEmpty || ! bankSet.contains(endGene)) return -1

      // 记录状态从start转化到key需要几步
      val stepMap = new mutable.HashMap[String, Int]()
      val queue = new mutable.Queue[String]()

      queue.enqueue(startGene)
      stepMap += (startGene -> 0)

      val items = Array('A', 'G', 'C', 'T')

      while (queue.nonEmpty) {
        var size = queue.size
        while (size > 0) {
          val s = queue.dequeue()
          val step = stepMap(s)
          val sA = s.toCharArray
          // 依次变换每个元素
          for (i <- 0 until 8) {
            items.foreach(c => {
              val oldC = s(i)
              if (c != s(i)) {
                sA(i) = c
                val ns = String.valueOf(sA)
                if (bankSet.contains(ns) && ! stepMap.contains(ns)) {
                  if (ns == endGene) return step + 1
                  stepMap += (ns -> (step + 1))
                  queue.enqueue(ns)
                }
              }
              // 还原
              sA(i) = oldC
            })
          }
          size -= 1
        }
      }
      -1
    }
}

//leetcode submit region end(Prohibit modification and deletion)
