package leetcode.editor.cn.t_380O1时间插入删除和获取随机元素

import leetcode.editor.cn.utils.Utils._

//实现RandomizedSet 类： 
//
// 
// 
// 
// RandomizedSet() 初始化 RandomizedSet 对象 
// bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。 
// bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。 
// int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。 
// 
// 
// 
//
// 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。 
//
// 
//
// 示例： 
//
// 
//输入
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", 
//"insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]
//输出
//[null, true, false, true, 2, true, false, 2]
//
//解释
//RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
//randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
//randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
//randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// 最多调用 insert、remove 和 getRandom 函数 2 * 10⁵ 次 
// 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。 
// 
//
// Related Topics 设计 数组 哈希表 数学 随机化 👍 738 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random
class RandomizedSet() {

    val random = new Random(System.currentTimeMillis()) // 完全随机种子
    val data = new ListBuffer[Int]() // 存放插入的数据
    val map = new mutable.HashMap[Int, Int]() // key为数据, v为对应的索引

    def insert(v: Int): Boolean = {
        if (map.contains(v)) return false
        data += v
        map += (v -> (data.length - 1))
        true
    }

    def remove(v: Int): Boolean = {
        if (! map.contains(v)) return false
        val index = map(v)
        map -= v
        if (index != data.length - 1) {
            // data非最后一位
            data(index) = data.last
            map(data.last) = index
        }
        data.remove(data.length - 1)
        true
    }

    def getRandom(): Int = {
        val randomIndex = random.nextInt(data.length)
        data(randomIndex)
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */
//leetcode submit region end(Prohibit modification and deletion)
