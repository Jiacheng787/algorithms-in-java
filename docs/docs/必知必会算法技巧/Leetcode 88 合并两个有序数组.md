---
sidebar_position: 5
---

# Leetcode 88 合并两个有序数组

给你两个有序整数数组 `nums1` 和 `nums2`，请你将 `nums2` 合并到 `nums1` 中，使 `nums1` 成为一个有序数组。

初始化 `nums1` 和 `nums2` 的元素数量分别为 `m` 和 `n` 。你可以假设 `nums1` 的空间大小等于 `m + n`，这样它就有足够的空间保存来自 `nums2` 的元素。

示例1：

```bash
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
```

示例2：

```bash
输入：nums1 = [0], m = 0, nums2 = [1], n = 1
输出：[1]
```

示例3：

```bash
输入：nums1 = [5, 6, 7, 8, 0, 0, 0], m = 4, nums2 = [2, 3, 3], n = 3
输出：[2, 3, 3, 5, 6, 7, 8]
```

## 解题思路

这道题明显是从 `nums1` 数组最后，按照倒序的方式进行合并。使用双指针法合并两个有序数组，比较两个元素大小，将较大的元素从后面合入。当其中一个数组全部合并之后，只需把另一个数组剩余元素合并过来即可。

```java
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // 使用双指针法合并两个有序数组
    // i => nums1 数组起始下标
    // j => nums2 数组起始下标
    int i = m - 1, j = n - 1;
    for (int p = nums1.length - 1; p >= 0; p--) {
      if (i == -1) {
        // nums1 已全部被合并，只需把 nums2 合并过来即可
        nums1[p] = nums2[j--];
      } else if (j == -1) {
        // nums2 已全部被合并，只需把 nums1 合并过来即可
        nums1[p] = nums1[i--];
      } else if (nums1[i] > nums2[j]) {
        // 将较大的元素合入，同时下标前进一位
        nums1[p] = nums1[i--];
      } else {
        nums1[p] = nums2[j--];
      }
    }
  }
}
```
