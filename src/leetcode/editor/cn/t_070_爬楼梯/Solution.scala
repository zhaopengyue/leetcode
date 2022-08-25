package leetcode.editor.cn.t_070_爬楼梯
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 2591 👎 0

/*
* 解答成功:
	执行耗时:440 ms,击败了43.48% 的Scala用户
	内存消耗:51 MB,击败了63.04% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {

    def climbStairs(n: Int): Int = {
        //reverse(n)
        dp(n)
    }

    // 递归方式
    def reverse(n: Int): Int = {
        // 第一级有一种方式
        if (n == 1) return 1
        // 第二级有两种方式
        if (n == 2) return 2
        // 第n节台阶的爬法 = 第一次爬了1级后n-1的爬法+第一次爬了2级后n-2的爬法
        reverse(n - 1) + reverse(n - 2)
    }

    /* 动态规划方式 */
    def dp(n: Int): Int = {
        if (n <= 2) return n
        val status = new Array[Int](n+1)
        // 初始化状态数组
        status(1) = 1
        status(2) = 2
        for (i <- 3 to n) {
            status(i) = status(i - 1) + status(i - 2)
        }
        status(n)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
