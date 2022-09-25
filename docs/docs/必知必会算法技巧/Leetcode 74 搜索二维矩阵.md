---
sidebar_position: 8
---

# Leetcode 74 搜索二维矩阵

编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

- 每行中的整数从左到右按升序排列。
- 每行的第一个整数大于前一行的最后一个整数。

虽然是一个二维矩阵，但是由于它特殊的有序性，所以完全可以按照下标把它看成一个一维矩阵，只不过需要行列坐标转换。最后利用二分搜索直接搜索即可。

```go
func searchMatrix(matrix [][]int, target int) bool {
    if len(matrix) == 0 {
        return false
    }
    m, low, high := len(matrix[0]), 0, len(matrix) * len(matrix[0]) - 1
    for low <= high {
        mid := low + (high - low) >> 1
        if matrix[mid / m][mid % m] == target {
            return true
        } else if matrix[mid / m][mid % m] > target {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return false
}
```

二分查找基本框架：

```go
func binarySearch(nums []int, target int) bool {
    if len(nums) == 0 {
        return false
    }
    low, high := 0, len(nums) - 1
    for low <= high {
        mid := low + (high - low) >> 1
        if nums[mid] == target {
            return true
        } else if nums[mid] > target {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return false
}
```
