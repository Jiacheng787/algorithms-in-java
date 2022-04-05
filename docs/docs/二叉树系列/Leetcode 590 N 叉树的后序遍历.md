---
sidebar_position: 4
---

# Leetcode 590 N 叉树的后序遍历

给定一个 n 叉树的根节点 `root`，返回其节点值的后序遍历。

n 叉树在输入中按层序遍历进行序列化表示，每组子节点由空值 `null` 分隔（请参见示例）。

示例 1：

```bash
输入：root = [1,null,3,2,4,null,5,6]
输出：[5,6,3,2,4,1]
```

示例 2：

```bash
输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
```

## 解题思路

### 1) 递归法

使用递归法如下：

```java
class Solution {

  // 开一个数组保存遍历结果
  private List<Integer> ans = new ArrayList<>();

  public List<Integer> postorder(Node root) {
    traverse(root);
    return ans;
  }

  private void traverse(Node root) {
    if (root == null) return;
    for (Node child : root.children) {
      traverse(child);
    }
    // 后序位置添加遍历结果
    ans.add(root.val);
  }
}
```

时间复杂度：`O(n)`

空间复杂度：忽略递归带来的额外空间开销，复杂度为 `O(1)`

### 2) 迭代法

参考二叉树的后序遍历方法，先把栈顶元素弹出，**从头部添加结果**，然后 **先把左节点入栈，再右节点入栈**，这样可以确保先遍历右节点。在遍历 N 叉树的时候，也需要按从左到右的顺序压栈，使用正序遍历即可。

```java
class Solution {
  public List<Integer> postorder(Node root) {
    LinkedList<Integer> ans = new LinkedList<>();
    LinkedList<Node> stack = new LinkedList<>();

    if (root == null) return ans;
    stack.push(root);

    while (!stack.isEmpty()) {
      root = stack.pop();
      // 注意：这里如果从尾部添加，得到的结果是反的
      // 需要从头部添加结果
      // 由于 ArrayList 只能从尾部添加元素
      // 这里使用了 LinkedList 双向链表
      ans.addFirst(root.val);
      // 正序遍历子节点压栈
      for (Node child : root.children) {
        stack.push(child);
      }
    }

    return ans;
  }
}
```

:::tip

LinkedList 方法说明：

- `add` 方法相当于 `addLast`，即从数组尾部添加元素，相当于 JS 中的 `push` 方法
- `addFirst` 可以从数组头部添加元素，相当于 JS 中的 `unshift`
- `poll` 相当于 `pollFirst`，删除数组头部元素，相当于 JS 中的 `shift`
- `pollLast` 可以删除数组尾部元素，相当于 JS 中的 `pop`

:::

时间复杂度：`O(n)`

空间复杂度：`O(n)`
