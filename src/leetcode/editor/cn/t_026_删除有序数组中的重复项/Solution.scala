package leetcode.editor.cn.t_026_删除有序数组中的重复项
//给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 
//。 
//
// 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个
//元素应该保存最终结果。 
//
// 将最终结果插入 nums 的前 k 个位置后返回 k 。 
//
// 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 判题标准: 
//
// 系统会用下面的代码来测试你的题解: 
//
// 
//int[] nums = [...]; // 输入数组
//int[] expectedNums = [...]; // 长度正确的期望答案
//
//int k = removeDuplicates(nums); // 调用
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//} 
//
// 如果所有断言都通过，那么您的题解将被 通过。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：2, nums = [1,2,_]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 升序 排列 
// 
//
// Related Topics 数组 双指针 👍 2773 👎 0

/*
* 解答成功:
	执行耗时:548 ms,击败了58.62% 的Scala用户
	内存消耗:54.7 MB,击败了34.48% 的Scala用户
* */
//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
    /*
    * 总体思路：定义一个宽度，用来表示当前字符与去重区尾字符的间隔。
    * 每当有一个重复字符（若当前字符和前一个字符重复，则当前字符为重复字符）则将宽度+1，待遍历结果后，wide的值即为重复了的元素的个数，nums.length-wide即为正常元素个数
    * */
    def removeDuplicates(nums: Array[Int]): Int = {
        var wide = 0
        var i = 1
        while (i < nums.length) {
            if (nums(i) == nums(i-1)) {
                wide += 1
            } else {
                nums(i - wide) = nums(i)
            }
            i += 1
        }
        nums.length - wide
    }
}
//leetcode submit region end(Prohibit modification and deletion)
