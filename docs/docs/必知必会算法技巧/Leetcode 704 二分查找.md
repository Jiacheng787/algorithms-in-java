---
sidebar_position: 4
---

# Leetcode 704 二分查找

给定一个 `n` 个元素有序的（升序）整型数组 `nums` 和一个目标值 `target`  ，写一个函数搜索 `nums` 中的 `target`，如果目标值存在返回下标，否则返回 `-1`。


示例 1:

```bash
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
```

示例 2:

```bash
输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
```

## 解题思路

二分查找基本框架如下：

```java
int binarySolution(int[] nums, int target) {
  int left = 0, right = ...;
  while (...) {
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) {
      ...
    } else if (nums[mid] < target) {
      left = ...;
    } else if (nums[mid] > target) {
      right = ...;
    }
  }
  return ...;
}
```

**分析二分查找的一个技巧是：不要出现 else，而是把所有情况用 else if 写清楚，这样可以清楚地展现所有细节。**

其中 `...` 标记的部分，就是可能出现细节问题的地方，当你见到一个二分查找的代码时，首先注意这几个地方。

另外声明一下，计算 `mid` 时需要防止溢出，代码中 `left + (right - left) / 2` 就和 `(left + right) / 2` 的结果相同，但是有效防止了 `left` 和 `right` 太大直接相加导致溢出。


对于本题的题解如下：

```java {4,6,11,13}
class Solution {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1; // 注意
    
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1; // 注意
      } else if (nums[mid] > target) {
        right = mid - 1; // 注意
      }
    }
    return -1;
  }
}
```

这里探讨一下其中的几个细节。

**1、为什么 while 循环的条件中是 <=，而不是 <？**

答：因为初始化 `right` 的赋值是 `nums.length - 1`，即最后一个元素的索引，而不是 `nums.length`。

因为我们需要对所有的元素进行搜索，使用 `<=` 搜索的是两端都闭区间 `[left, right]`，如果使用 `<` 则相当于左闭右开区间 `[left, right)`。

> 如果使用 `<`，然后 `right` 初始赋值改为 `nums.length`，也可实现 `[left, right]` 范围的搜索，但会漏掉最后一个元素，下面会讲


此外还要注意下结束搜索的条件。当找到目标值的时候可以终止：`nums[mid] == target`。如果没找到，就需要 `while` 循环终止，然后返回 `-1`。那 while 循环什么时候应该终止？**搜索区间为空的时候应该终止。**

`while(left <= right)` 的终止条件是 `left == right + 1`，写成区间的形式就是 `[right + 1, right]`，或者带个具体的数字进去 `[3, 2]`。

`while(left < right)` 的终止条件是 `left == right`，写成区间的形式就是 `[right, right]`，或者带个具体的数字进去 `[2, 2]`，这时候区间非空，还有一个数 `2`，但此时 `while` 循环终止了。也就是说这区间 `[2, 2]` 被漏掉了，索引 `2` 没有被搜索，如果这时候直接返回 `-1` 就是错误的。

如果要用 `while(left < right)` 也是可以的，我们已经知道了出错的原因，就打个补丁好了：

```java
class Solution {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      }
    }
    // 对漏掉的元素进行判断
    return nums[left] == target ? left : -1;
  }
}
```

**2、为什么 `left = mid + 1`，`right = mid - 1`？我看有的代码是 `right = mid` 或者 `left = mid`**

刚才明确了「搜索区间」这个概念，而且本算法的搜索区间是两端都闭的，即 `[left, right]`。那么当我们发现索引 `mid` 不是要找的 `target` 时，下一步应该去搜索哪里呢？

当然是去搜索 `[left, mid-1]` 或者 `[mid+1, right]` 对不对？**因为 `mid` 已经搜索过，应该从搜索区间中去除。**


**3、此算法有什么缺陷？**

比如说给你有序数组 `nums = [1,2,2,2,3]`，`target` 为 `2`，此算法返回的索引是 `2`，没错。但是如果我想得到 `target` 的左侧边界，即索引 `1`，或者我想得到 `target` 的右侧边界，即索引 `3`，这样的话此算法是无法处理的。

这样的需求很常见，**你也许会说，找到一个 `target`，然后向左或向右线性搜索不行吗？可以，但是不好，因为这样难以保证二分查找对数级的复杂度了。**


## 总结

- 不要使用 `else`，而是把所有情况用 `else if` 写清楚
- 计算 `mid` 时需要防止溢出，使用 `left + (right - left) / 2` 先减后加这样的写法
- `while` 循环的条件 `<=` 对应 `right` 初始值为 `nums.length - 1`，终止条件是 `left == right + 1`，例如 `[3, 2]`
- 如果 `while` 循环的条件 `<`，需要把 `right` 初始值改为 `nums.length`，此时终止条件是 `left == right`，例如 `[2, 2]`，这样会漏掉最后一个区间的元素，需要单独判断下
- 当 `mid` 不是要找的 `target` 时，下一步应该搜索 `[left, mid-1]` 或者 `[mid+1, right]`，对应 `left = mid + 1` 或者 `right = mid - 1`
- 二分查找时间复杂度 `O(logn)`
