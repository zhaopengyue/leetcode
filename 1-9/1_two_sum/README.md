### 题目描述
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的**两个**整数。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:
```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

### 基本思路
1. 依次遍历每一个元素x，通过相减计算出待查找的元素y
2. 在列表中查找该元素y，该元素y只可能出现在元素x后面(因为从前向后查询，因此不可能出现在前面)
3. 若查找到该元素y，则返回x,y的索引列表，否则重复此步操作

### 注意事项
- 根据基本思路，我们发现需要在一个序列中向后查找该值是否存在，此时整体是一个复杂度为<a href="https://www.codecogs.com/eqnedit.php?latex=O(n^2)" target="_blank"><img src="https://latex.codecogs.com/gif.latex?O(n^2)" title="O(n^2)" /></a>的算法。为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。如果存在，我们需要找出它的索引。保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。
- 通过以空间换取速度的方式，我们可以将查找时间从 O(n) 降低到 O(1)。哈希表正是为此目的而构建的，它支持以 近似 恒定的时间进行快速查找。我用“近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)。但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)。

### 实现代码
```python
class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # 采用一遍hash
        index_dict = {}
        nums_len = len(nums)
        for i in range(nums_len):
            end_num = target - nums[i]
            if index_dict.get(end_num) != None:
                return index_dict.get(end_num), i
            index_dict.update({nums[i]: i})
```