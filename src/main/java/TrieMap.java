import java.util.LinkedList;
import java.util.List;

/**
 * Trie 树实现键值对映射
 * 键为 String 类型，值为类型 T
 * @param <T>
 */
public class TrieMap<T> {
    // ASCII 码个数
    private static final int R = 256;
    // 注意点：记得保存当前存在 Map 中的键值对个数
    private int size = 0;

    private static class TrieNode<T> {
        T val = null;
        TrieNode<T>[] children = new TrieNode[R];
    }

    // 注意点：记得保存 Trie 树根节点
    private TrieNode<T> root = null;

    // 获取 Trie 树中所有节点数量
    public int size() {
        return this.size;
    }

    // 从节点 node 开始搜索 key，如果存在返回对应节点，否则返回 null
    private TrieNode<T> getNode(TrieNode<T> node, String key) {
        TrieNode<T> p = node;
        // 从节点 node 开始搜索 key
        for (int i=0; i<key.length(); i++) {
            // 无法向下搜索
            if (p == null) return null;
            // 向下搜索
            char c = key.charAt(i);
            p = p.children[c];
        }
        return p;
    }

    // 搜索 key 对应的值，不存在则返回 null
    public T get(String key) {
        // 从 root 开始搜索 key
        TrieNode<T> x = this.getNode(this.root, key);
        // x 为空或者 x 的 val 字段为空，都说明 key 没有对应的值
        // 仅仅 x 非空只能说明字符串 key 是一个前缀
        if (x == null || x.val == null) return null;
        return x.val;
    }

    // 判断 key 是否存在在 Map 中
    public boolean containsKey(String key) {
        return this.get(key) != null;
    }

    // 判断是否存在前缀为 prefix 的键
    public boolean hasKeyWithPrefix(String prefix) {
        // 只要能找到 prefix 对应的节点，就是存在前缀
        // 这里不用关心 val 是否非空
        return this.getNode(this.root, prefix) != null;
    }

    // 类似 `getNode` 的方法逻辑，在所有键中寻找 query 的最短前缀
    public String shortestPrefixOf(String query) {
        TrieNode<T> p = root;
        // 从 root 节点开始搜索
        for (int i=0; i<query.length(); i++) {
            // 无法向下搜索
            if (p == null) return "";
            // 第一次遇到一个键是 query 的前缀，直接返回
            if (p.val != null) {
                return query.substring(0, i);
            }
            // 向下搜索
            char c = query.charAt(i);
            p = p.children[c];
        }
        // for 循环之后还要再额外检查一下
        // Trie 树的树枝存储字符串，节点存储字符串对应的值
        // for 循环相当于只遍历了树枝，但漏掉了最后一个节点
        // 如果 query 本身就是一个键
        if (p != null && p.val != null) return query;
        return "";
    }

    public String longestPrefixOf(String query) {
        TrieNode<T> p = root;
        // 记录前缀的最大长度
        int max_len = 0;
        // 从 root 节点开始搜索
        for (int i=0; i<query.length(); i++) {
            if (p == null) {
                // 无法向下搜索
                break;
            }
            if (p.val != null) {
                // 找到一个键是 query 的前缀，不急着返回
                // 而是更新前缀最大长度
                max_len = i;
            }
            // 向下搜索
            char c = query.charAt(i);
            p = p.children[c];
        }
        // 如果 query 本身是一个键
        if (p != null && p.val != null) return query;
        return query.substring(0, max_len);
    }

    // 搜索前缀为 prefix 的所有键
    public List<String> keysWithPrefix(String prefix) {
        LinkedList<String> res = new LinkedList<>();
        // 找到匹配 prefix 在 Trie 树中的那个节点
        TrieNode<T> x = getNode(root, prefix);
        if (x == null) return res;
        // DFS 遍历以 x 为根的这棵 Trie 树
        this.traverse(x, new StringBuilder(prefix), res);
        return res;
    }

    // 遍历以 node 节点为根的 Trie 树，找到所有键
    private void traverse(TrieNode<T> node, StringBuilder path, List<String> res) {
        if (node == null) {
            // 到达 Trie 树底部叶子结点
            return;
        }

        if (node.val != null) {
            // 找到一个 key，添加到结果列表中
            res.add(path.toString());
        }

        // 回溯算法遍历框架
        for (char c = 0; c < R; c++) {
            // 做选择
            path.append(c);
            traverse(node.children[c], path, res);
            // 撤销选择
            path.deleteCharAt(path.length() - 1);
        }
    }

    // 在 map 中添加或修改键值对
    public void put(String key, T val) {
        if (!containsKey(key)) {
            // 新增键值对
            size++;
        }
        // 需要一个额外的辅助函数，并接收其返回值
        this.root = put(this.root, key, val, 0);
    }

    // 定义：向以 node 为根的 Trie 树中插入 key[i..]，返回插入完成后的根节点
    private TrieNode<T> put(TrieNode<T> node, String key, T val, int i) {
        if (node == null) {
            // 如果树枝不存在，新建
            node = new TrieNode<>();
        }
        if (i == key.length()) {
            // key 的路径已插入完成，将值 val 存入节点
            node.val = val;
            return node;
        }
        char c = key.charAt(i);
        // 递归插入子节点，并接收返回值
        node.children[c] = put(node.children[c], key, val, i + 1);
        return node;
    }
}
