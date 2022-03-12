---
sidebar_position: 1
---

# Leetcode 300 最长递增子序列

给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

示例 1：

```bash
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
```

示例 2：

```bash
输入：nums = [0,1,0,3,2,3]
输出：4
```

示例 3：

```bash
输入：nums = [7,7,7,7,7,7,7]
输出：1
```

## 解题思路

常规方法是使用动态规划，时间复杂度 `O(n^2)`。这里注意 `dp[i]` 的定义是 **以 `nums[i]` 这个数结尾的最长递增子序列长度**。

```java
class Solution {
  public int lengthOfLIS(int[] nums) {
    // 定义 dp 数组
    // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列长度
    int[] dp = new int[nums.length];
    // 初始值填充 1（子序列至少包含当前元素自己）
    Arrays.fill(dp, 1);
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        // 假设 dp[0...i-1] 都已知，需要求出 dp[i]
        // 只需要遍历 nums[0...i-1]，找到结尾比 nums[i] 小的子序列 dp[j]
        // 然后把 nums[i] 接到最后，就可以形成一个新的递增子序列，长度为 dp[j] + 1
        // 显然，可能形成很多种新的子序列，只需要选择最长的，作为 dp[i] 的值即可
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    // 遍历 dp 数组，找出最大值
    int res = 0;
    for (int i = 0; i < dp.length; i++) {
      res = Math.max(res, dp[i]);
    }
    return res;
  }
}
```

这边采用 Vue 中 DOM diff 的思路，即**贪心法**，需要注意的是，最后 `stack` 的长度是对的，但是内容可能不是正确的。由于采用了两层循环遍历，时间复杂度为 `O(n^2)` 。

```javascript
var lengthOfLIS = function (nums) {
  let stack = [];
  for (let i = 0; i < nums.length; i++) {
    // 数组为空直接入栈，不为空则获取栈顶元素判断大小
    if (stack.length == 0 || getTopEle(stack) < nums[i]) {
      stack.push(nums[i]);
    } else {
      let index = findNextEle(stack, nums[i]);
      stack[index] = nums[i];
    }
  }
  return stack.length;
};

function getTopEle(arr) {
  if (!arr.length) return 0;
  return arr[arr.length - 1];
}

function findNextEle(arr, n) {
  // 判断大小用 >= ，即不替换栈顶元素
  return arr.findIndex(item => item >= n);
}
```

进一步优化，可以将 `findIndex` 方法替换为二分查找，时间复杂度降低到 `O(nlogn)` 。

## 参考

[精读《DOM diff 最长上升子序列》](https://juejin.cn/post/6952674285311754276)
