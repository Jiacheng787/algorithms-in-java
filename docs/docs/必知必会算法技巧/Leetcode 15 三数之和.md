---
sidebar_position: 6
---

# Leetcode 15 三数之和

首先两数之和，应该都知道下面的方法：

```go
func twoSum(nums []int, target int) []int {
  mapping := make(map[int]int)
  for i := 0; i < len(nums); i++ {
    k := target - nums[i]
    value, ok := mapping[k]
    if ok {
      return []int{i, value}
    }
    mapping[i] = nums[i]
  }
  return []int{0, 0}
}
```

三数之和的方法是先对数组排序，确定其中一个值，再通过左右双指针法确定剩下两个值（这就是排序的目的）。主要难点在于如何去掉重复的结果：

```go
package algorithm

import (
	"sort"
)

func ThreeSum(nums []int) [][]int {
	ans := make([][]int, 0)
	// 数组元素个数小于 3，直接返回
	if len(nums) < 3 {
		return ans
	}
	// 排序
	sort.Ints(nums)
	// 遍历到倒数第二个，因为是三个数总和
	for i := 0; i < len(nums) - 2; i++ {
		// 规定 nums[i] < nums[left] < nums[right]
		// 如果 nums[i] > 0 则不存在另外两个值使得相加等于 0
		// 大于 0 可以直接跳出循环了
		if nums[i] > 0 {
			break
		}
		// 过滤 nums[i] 重复
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		// 先确定一个值 nums[i]
		// 再去找另外两个值 nums[left] 和 nums[right]
		// 需要满足 nums[i] < nums[left] < nums[right]
		target := -nums[i]
		left, right := i + 1, len(nums) - 1

		// 使用双指针法确定剩下两个值
		for left < right {
			sum := nums[left] + nums[right]
			if sum < target {
				left++
			} else if sum > target {
				right--
			} else if sum == target {
				ans = append(ans, []int{nums[i], nums[left], nums[right]})
				// 找到目标值，左右指针分别移动一位
				left++
				right--
				// 过滤 nums[left] 重复
				for left < right && nums[left] == nums[left-1] {
					left++
				}
				// 过滤 nums[right] 重复
				for left < right && nums[right] == nums[right+1] {
					right--
				}
			}
		}
	}
	return ans
}
```
