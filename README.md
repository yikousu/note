# ㊀说明

目前主要记录算法等笔记。

# ㊁CSDN博客

在[CSDN博客](https://blog.csdn.net/m0_64289188)也有记录刷算法的思路，题解。

[力扣hot100](https://blog.csdn.net/m0_64289188/article/details/144056081?spm=1001.2014.3001.5501)

[力扣hot100--2](https://blog.csdn.net/m0_64289188/article/details/145312501?spm=1001.2014.3001.5501)

# ㊂算法

## ➀二分查找

思想：**二分查找**是一种在**有序数组**中查找目标值的位置的高效算法，时间复杂度是 O(log n)。

常见变种：

[普通二分查找](src/main/java/com/algorithm/basic/search/binary_search/BinarySearch1.java)

[查找左边界（lower bound）](src/main/java/com/algorithm//basic/search/binary_search/BinarySearch2.java)

[查找右边界（upper bound）](src/main/java/com/algorithm//basic/search/binary_search/BinarySearch3.java)

面试算法题：[在一个升序数组中，找到目标数的个数。](src/main/java/com/algorithm//basic/search/binary_search/TargetCount.java)

## ②排序【排序算法的6大核心思想】

### 1. **交换排序**

**思想关键词**：不断交换错位的元素
**核心逻辑**：遇到逆序对就交换，直到整体有序

* [**冒泡排序**（Bubble Sort）](src/main/java/com/algorithm/basic/sort/BubbleSort.java)：相邻元素两两比较，较大的冒泡到后面。
* [**快速排序**（Quick Sort）](src/main/java/com/algorithm/basic/sort/Quick.java)：分区+递归。选一个“基准”，比它小的放左边，大的放右边，然后左右再递归快排。

---

### 2. **插入排序**

**思想关键词**：构造有序序列，把新元素“插”进去
**核心逻辑**：像打扑克牌那样，把牌一张张插入已有有序部分。

* [**直接插入排序**](src/main/java/com/algorithm/basic/sort/InsertSort.java)：每次将一个元素插入到已排好序的部分中。
* **希尔排序**：分组插入排序，通过“跳跃”式的分组减少移动次数，加快排序。

---

### 3. **选择排序**

**思想关键词**：每轮选最值放到合适位置
**核心逻辑**：找到当前范围内的最小（或最大）元素，放到前面。

* [**简单选择排序**](src/main/java/com/algorithm/basic/sort/selectSort.java)：每次从未排序中找出最小的，放到已排好序的后面。
* [**堆排序**](src/main/java/com/algorithm/basic/sort/HeapSort.java)：构建大顶堆/小顶堆，每次取堆顶元素放到末尾。

---

### 4. **归并排序**

**思想关键词**：分而治之 + 合并有序
**核心逻辑**：先把数组拆成最小单位，再两两合并成有序。

* [**归并排序**（Merge Sort）](src/main/java/com/algorithm/basic/sort/MergeSort.java)：递归地拆分数组，然后合并时保持有序。

---

### 5. **计数排序**

**思想关键词**：计数桶
**核心逻辑**：用一个数组统计每个数字出现次数，再按顺序输出。

* **计数排序**：适用于数字范围不大、数据量大的情况（如0\~100的考试成绩）。

---

### 6. **桶排序 & 基数排序**

**思想关键词**：分桶、按位分组

* **桶排序**：把数据按范围分到不同桶中，各桶内单独排序，再合并。
* **基数排序**：按个位、十位、百位……逐位排序。

## ③面试

### 实现 LRU（Least Recently Used）缓存

- [用 Java 内置类 LinkedHashMap](src/main/java/com/algorithm/intv/LRUCache.java)
- 手写 LRU（HashMap + 双向链表）


## ④其他

[力扣hot100](src/main/java/com/algorithm/hot100/)

[up主labuladong](src/main/java/com/algorithm/labuladong)

[力扣其他(除hot100)](src/main/java/com/algorithm/leetcode_other)
