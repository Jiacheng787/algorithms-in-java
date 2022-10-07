---
sidebar_position: 2
---

原地哈希

数组长度为 `n + 1`，同时给定的 `nums[i]` 都在 `[1, n]` 范围内，因此我们可以设定哈希规则为 `nums[idx] = idx + 1`，即数值 `x` 会放在下标 `x - 1` 的位置。

如此一来，对于只出现一次的数值而言，必然能够顺利放在目标位置，而出现多次的数值必然会因为位置冲突而被找出。

```go
func findDuplicate(nums []int) int {
	for i := 0; i < len(nums); {
		t := nums[i]
		idx := t - 1
    // 验证 `t` 是否放在 `t - 1` 位置
		if nums[idx] == t {
      // t` 放在 `t - 1` 位置，且 `t - 1` 不是当前变量的下标
      // 此时 t 是重复的数
			if idx != i {
				return t
			}
      // t` 放在 `t - 1` 位置，且 `t - 1` 等于 `i`
      // t 恰好满足哈希规则，直接跳过遍历下一个
			i++
		} else {
      // `t` 没有放在 `t - 1` 位置
      // 交换元素将 `t` 放在正确的位置
      // 下一个循环会走到上面 i++ 的位置
			nums[idx], nums[i] = nums[i], nums[idx]
		}
	}
	return -1
}
```
