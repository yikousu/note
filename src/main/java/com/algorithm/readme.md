## 二分查找

思想：**二分查找**是一种在**有序数组**中查找目标值的位置的高效算法，时间复杂度是 O(log n)。

基本流程：

```bash
初始：
left = 0
right = 数组长度 - 1

循环：
1. 取中间位置 mid = (left + right) / 2
2. 判断 nums[mid] 和 target 的关系：
   - 相等：返回 mid
   - 小于：目标在右边 → left = mid + 1
   - 大于：目标在左边 → right = mid - 1
3. 如果 left > right，说明没找到，返回 -1

```

常见变种：

[普通二分查找](basic/search/binary_search/BinarySearch1.java)

[查找左边界（lower bound）](./basic/search/binary_search/BinarySearch2.java)

[查找右边界（upper bound）](./basic/search/binary_search/BinarySearch3.java)

面试算法题：[在一个升序数组中，找到目标数的个数。](./basic/search/binary_search/TargetCount.java)
