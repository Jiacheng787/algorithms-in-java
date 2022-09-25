---
sidebar_position: 9
---

# Leetcode 240 搜索二维矩阵 II

这一题是第 74 题的加强版。第 74 题中的二维矩阵完全是一个有序的一维矩阵，但是这一题如果把它拍扁成一维，并不是有序的。首先每一个行或者每一列是有序的 ，那么我们可以依次在每一行或者每一列中利用二分去搜索。这样做时间复杂度为 O(n log n)。

还有一个模拟的解法。通过观察，我们发现了这个矩阵的一个特点，最右边一列的元素是本行中最大的元素，所以我们可以先从最右边一列开始找到第一个比 target 元素大的元素，这个元素所在的行，是我们接着要搜索的。在行中搜索是从最右边开始往左边搜索，时间复杂度是 O(n)，算上一开始在最右边一列中查找的时间复杂度是 O(m)，所以最终的时间复杂度为 O(m+n)。

> 总结一下就是从矩阵第一行最右侧开始查找，当前值比 target 大往左走，比 target 小的话往下走

```go
func searchMatrix(matrix [][]int, target int) bool {
    if len(matrix) == 0 {
        return false
    }
    row, col := 0, len(matrix[0]) - 1
    for col >= 0 && row <= len(matrix) - 1 {
        if target == matrix[row][col] {
            return true
        } else if target > matrix[row][col] {
            row++
        } else {
            col--
        }
    }
    return false
}
```
