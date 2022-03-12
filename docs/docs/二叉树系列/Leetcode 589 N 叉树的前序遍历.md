---
sidebar_position: 2
---

# Leetcode 589 N 叉树的前序遍历

给定一个 n 叉树的根节点 `root`，返回其节点值的前序遍历。

n 叉树在输入中按层序遍历进行序列化表示，每组子节点由空值 `null` 分隔（请参见示例）。

示例 1：

```bash
输入：root = [1,null,3,2,4,null,5,6]
输出：[1,3,5,6,2,4]
```

示例 2：

```bash
输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
```

## 解题思路

### 1) 递归法

N 叉树的遍历可以参考二叉树遍历方法。

```java
void traverse(Node root) {
  // 前序位置
  for (Node child : root.children) {
    traverse(child);
  }
  // 后序位置
}
```

使用递归法如下：

```java
class Solution {

  // 开一个数组保存遍历结果
  private List<Integer> ans = new ArrayList<>();

  public List<Integer> preorder(Node root) {
    traverse(root);
    return ans;
  }

  private void traverse(Node root) {
    // 前序位置添加遍历结果
    ans.add(root.val);
    for (Node child : root.children) {
      traverse(child);
    }
  }
}
```

时间复杂度：`O(n)`

空间复杂度：忽略递归带来的额外空间开销，复杂度为 `O(1)`

### 2) 迭代法

迭代法遍历 N 叉树也可参考二叉树的遍历方法。遍历二叉树的时候，先把栈顶元素弹出，保存结果，然后 **先把右节点入栈，再左节点入栈**，这样可以确保先遍历左节点。在遍历 N 叉树的时候，也需要按从右到左的顺序压栈，可以通过倒序遍历。

```java
class Solution {
  public List<Integer> preorder(Node root) {
    List<Integer> ans = new ArrayList<>();
    // 使用双端队列实现一个栈
    // Deque<Node> stack = new ArrayDeque<>();
    // LinkedList 是一个继承于 AbstractSequentialList 的双向链表
    // 实现了 Deque 接口，可以当做双端队列使用
    LinkedList<Node> stack = new LinkedList<>();

    if (root == null) return ans;
    stack.push(root);

    while(!stack.isEmpty()) {
      root = stack.pop();
      // 保存结果
      ans.add(root.val);
      // 倒序遍历子节点压栈
      for (int i = root.children.size() - 1; i >=0; i--) {
        stack.push(root.children.get(i));
      }
    }

    return ans;
  }
}
```

:::tip

LinkedList 是一个继承于 AbstractSequentialList 的双向链表，它也可以被当作堆栈、队列或双端队列进行操作。

LinkedList 实现 List 接口，能对它进行队列操作。

LinkedList 实现 Deque 接口，即能将LinkedList当作双端队列使用。

:::

时间复杂度：`O(n)`

空间复杂度：`O(n)`
