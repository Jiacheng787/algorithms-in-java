---
sidebar_position: 1
---

# Leetcode 236 二叉树最近公共祖先

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

示例 1：

```bash
输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
```

示例 2：

```bash
输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出：5
解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
```

示例 3：

```bash
输入：root = [1,2], p = 1, q = 2
输出：1
```

## 解题思路

首先这道题的函数签名如下：

```java
TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);
```

`root` 节点确定了一棵二叉树，`p` 和 `q` 是这这棵二叉树上的两个节点，让你返回 `p` 节点和 `q` 节点的最近公共祖先节点。

所有二叉树的套路都是一样的，可以先把遍历的框架写出来：

```java
TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
  // 前序遍历
  TreeNode left = lowestCommonAncestor(root.left, p, q);
  // 中序遍历
  TreeNode right = lowestCommonAncestor(root.right, p, q);
  // 后序遍历
}
```

现在我们思考如何添加一些细节，把框架改造成解法。遇到任何递归型的问题，无非就是灵魂三问：

**1、这个函数是干嘛的？**

**2、这个函数参数中的变量是什么？**

**3、得到函数的递归结果，你应该干什么？**

> 与动态规划的思路类似，也是要明确「定义」「状态」「选择」

### 1) 这个函数是干嘛的？

描述一下 `lowestCommonAncestor` 这个函数的「定义」吧。

描述：给该函数输入三个参数 `root`，`p`，`q`，它会返回一个节点。

情况 1，如果 `p` 和 `q` 都在以 `root` 为根的树中，函数返回的即 `p` 和 `q` 的最近公共祖先节点。

情况 2，如果 `p` 和 `q` 都不在以 `root` 为根的树中，则理所当然地返回 `null` 呗。

情况 3，如果 `p` 和 `q` 只有一个存在于 `root` 为根的树中，函数就返回那个节点。

> 题目说了输入的 `p` 和 `q` 一定存在于以 `root` 为根的树中，但是递归过程中，以上三种情况都有可能发生，所以说这里要定义清楚，后续这些定义都会在代码中体现

### 2) 这个函数的参数中，变量是什么？

你描述一下这个函数的「状态」吧。

描述：函数参数中的变量是 `root`，因为根据框架，`lowestCommonAncestor(root)` 会递归调用 `root.left` 和 `root.right`；至于 `p` 和 `q`，我们要求它俩的公共祖先，它俩肯定不会变化的，就是在递归过程中一层一层透传下去。

> 你也可以理解这是「状态转移」，每次递归在做什么？不就是在把「以root为根」转移成「以root的子节点为根」，不断缩小问题规模嘛

### 3) 得到函数的递归结果，你该干嘛？

得到递归调用的结果后，你做什么「选择」？

先想 base case，如果 `root` 为空，肯定得返回 `null`。如果 `root` 本身就是 `p` 或者 `q`，比如说 `root` 就是 `p` 节点吧，如果 `q` 存在于以 `root` 为根的树中，显然 `root` 就是最近公共祖先；即使 `q` 不存在于以 `root` 为根的树中，按照情况 3 的定义，也应该返回 `root` 节点。

以上两种情况的 base case 就可以把框架代码填充一点了：

```java
TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
  // 如果 root 为空
  if (root == null) return null;
  // 如果 root 本身就是 p 或者 q
  if (root == p || root == q) return root;

  TreeNode left = lowestCommonAncestor(root.left, p, q);
  TreeNode right = lowestCommonAncestor(root.right, p, q);
}
```

现在用递归调用的结果 `left` 和 `right` 来搞点事情。根据刚才第一个问题中对函数的定义，我们继续分情况讨论：

情况 1，如果 `p` 和 `q` 都在以 `root` 为根的树中，那么 `left` 和 `right` 一定分别是 `p` 和 `q`（从 base case 看出来的）。

情况 2，如果 `p` 和 `q` 都不在以 `root` 为根的树中，直接返回 `null`。

情况 3，如果 `p` 和 `q` 只有一个存在于 `root` 为根的树中，函数返回该节点。

明白了上面三点，可以直接看解法代码了：

```java
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // 两个 base case
    // 1.如果 root 为空，直接返回 null
    if (root == null) return null;
    // 2.如果 root 本身就是 p 或者 q
    // 例如 root 是 p 节点，如果 q 存在于以 root 为根的树中，显然 root 就是最近公共祖先
    // 即使 q 不存在于以 root 为根的树中，按照情况 3 的定义，也应该返回 root 节点
    if (root == p || root == q) return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    // 在后序位置分情况讨论
    // 情况 1，如果 p 和 q 都在以 root 为根的树中
    // 那么 left 和 right 一定分别是 p 和 q（从 base case 看出）
    // 由于后序位置是从下往上，就好比从 p 和 q 出发往上走
    // 第一次相交的节点就是这个 root，显然就是最近公共祖先
    if (left != null && right != null) {
      return root;
    }
    // 情况 2，如果 p 和 q 都不在以 root 为根的树中，直接返回 null
    if (left == null && right == null) {
      return null;
    }
    // 情况 3，如果 p 和 q 只有一个存在于 root 为根的树中，函数返回该节点
    return left == null ? right : left;
  }
}
```

> 个人理解：
> 
> 在前序位置搜索节点，如果是空节点直接返回，如果搜索到 `p` 或者 `q` 返回该节点，否则继续递归
>
> 在后序位置接收前序的返回值，如果 `left` 和 `right` 都不为空，说明分别是 `p` 和 `q`，当前 `root` 就是最近公共祖先，直接返回 `root` 节点。如果一个为空另一个不为空，说明找到一个节点，把这个节点向上传递，查找另一个节点，直到出现两个都不为空，此时 `root` 就是最近公共祖先，直接返回 `root` 节点

对于情况 1，你肯定有疑问，`left` 和 `right` 非空，分别是 `p` 和 `q`，可以说明 `root` 是它们的公共祖先，但能确定 `root` 就是「最近」公共祖先吗？

这就是一个巧妙的地方了，**因为这里是二叉树的后序遍历啊！** 前序遍历可以理解为是从上往下，而后序遍历是从下往上，就好比从 `p` 和 `q` 出发往上走，第一次相交的节点就是这个 `root`，你说这是不是最近公共祖先呢？

