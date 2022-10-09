---
sidebar_position: 10
---

# Leetcode 856 括号的分数

```go
func scoreOfParentheses(s string) int {
	stack := []int{0} // 初始化，将 `0` 放入答案中
	for _, char := range s {
		if string(char) == "(" {
			// 遇到 `(` 则存入一个 `0`
			stack = append(stack, 0)
		} else {
			// 遇到 `)` 取出栈顶元素
			l := len(stack)
			cur := stack[l-1]
			stack = stack[:l-1]
			if cur == 0 {
				// 栈顶元素 cur == 0
				// 即当前 `)`的前一元素是 `(`
				// 根据 `()` 得一分的规则，本次操作分值为 `1`
				stack[l-2] = stack[l-2] + 1
			} else {
				// 栈顶元素 cur != 0
				// 即当前 `)` 与其匹配的 `(` 中间相隔了其他字符
				// 根据 `(A)` 的得分规则，此时得分为 `cur * 2`
				stack[l-2] = stack[l-2] + cur*2
			}
		}
	}
	return stack[0]
}
```
