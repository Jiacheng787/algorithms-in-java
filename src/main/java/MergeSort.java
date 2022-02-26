import java.util.Arrays;

public class MergeSort {
    // 用于辅助合并有序数组（不能原地合并，需要借助额外空间）
    private static int[] temp;

    public static void sort(int[] nums) {
        // 避免递归中频繁分配和释放内存可能产生的性能问题
        // 提前给辅助数组开辟内存空间
        temp = new int[nums.length];
        // 原地修改的方式对整个数组进行排序
        _sort(nums, 0, nums.length - 1);
    }

    // 将子数组 nums[lo..hi] 进行排序
    private static void _sort(int[] nums, int lo, int hi) {
        // 单个元素不用排序
        if (lo == hi) return;
        // 这样写是为了防止溢出，效果等同于 (hi + lo) / 2
        int mid = lo + (hi - lo) / 2;
        // 先对左半部分数组 nums[lo..mid] 进行排序
        _sort(nums, lo, mid);
        // 再对右半部分数组 nums[mid+1..hi] 进行排序
        _sort(nums, mid +1, hi);
        // 合并两个有序数组
        merge(nums, lo, mid, hi);
    }

    // 将 nums[lo..mid] 和 nums[mid+1..hi] 这两个有序数组合并成一个有序数组
    private static void merge(int[] nums, int lo, int mid, int hi) {
        // 先把 nums[lo..hi] 复制到辅助数组中
        // 以便合并后的结果能够直接存入 nums
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        // 使用双指针技巧合并两个有序数组
        // i => 左半边数组起始下标
        // j => 右半边数组起始下标
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                // 左半边数组已全部被合并，只需把右半边数组合并过来即可
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                // 右半边数组已全部被合并，只需把左半边数组合并过来即可
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                // 将较小的元素合入，同时下标前进一位，此时是升序
                // 只要将 > 改为 < 就可以把结果改为降序
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 6, 5};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
