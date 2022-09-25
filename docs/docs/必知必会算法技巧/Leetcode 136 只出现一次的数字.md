---
sidebar_position: 7
---

# Leetcode 136 只出现一次的数字

这道题最简单的方法是用 map，首次遍历就放到 map 里面，再次遍历就从 map 中删除，最后剩下的就是需要找的元素了：

```go
func singleNumber(nums []int) int {
    var hashTable = make(map[int]int)
    var result []int

    for _, item := range nums {
        if _, ok := hashTable[item]; ok {
            delete(hashTable, item)
        } else {
            hashTable[item] = 1
        }
    }

    for key := range hashTable {
        result = append(result, key)
    }

    return result[0]
}
```

但是如果要求 `O(1)` 的空间复杂度，可以用异或操作，原理是对同一个值进行异或操作，结果是 0，这样最终重复的值都会抵消掉，剩下的就是需要找的元素了：

```go
func singleNumber(nums []int) int {
    a := 0
    for _, n := range nums {
        a ^= n
    }
    return a
}
```
