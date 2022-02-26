public class BstTraverse {
    private void traverse(int[] arr, int i) {
        if (i == arr.length) return;
        // 前序位置
//        System.out.println("前序：" + i);
        traverse(arr, i + 1);
        // 后序位置
        // 这里可以利用递归的堆栈实现倒序遍历
//        System.out.println("后序：" + i);
    }

    public static void main(String[] args) {
        BstTraverse bstTraverse = new BstTraverse();
        int[] arr = {1, 2, 3, 4, 5, 6};
        int startIndex = 0;
        bstTraverse.traverse(arr, startIndex);
    }
}
