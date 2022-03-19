import java.util.Arrays;
import java.util.Random;

public class Quick {
    public void sort(int[] nums) {
        // 为避免出现耗时的极端情况，先随机打乱
        shuffle(nums);
        // 排序整个数组（原地修改）
        _sort(nums, 0, nums.length - 1);
    }

    private void _sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        // 对 nums[lo..hi] 进行切分
        // 使得 nums[lo..p-1] <= nums[p] < nums[p+1..hi]
        int p = partition(nums, lo, hi);

        _sort(nums, lo, p - 1);
        _sort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        // 选取 pivot
        int pivot = nums[lo];

        // 把 i, j 定义为开区间，同时定义：
        // [lo, i) <= pivot; (j, hi] > pivot
        // 之后都要正确维护这个边界区间的定义

        // 使用双指针法，从两边向中间接近
        int i = lo + 1, j = hi;
        // 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
        while (i <= j) {
            // 当 nums[i] 小于 pivot，下标前移
            // 此 while 结束时恰好 nums[i] > pivot
            while (i < hi && nums[i] <= pivot) {
                i++;
            }
            // 当 nums[j] 大于 pivot，下标后移
            // 此 while 结束时恰好 nums[j] <= pivot
            while (j > lo && nums[j] > pivot) {
                j--;
            }
            // 此时 [lo, i) <= pivot && (j, hi] > pivot
            if (i >= j) {
                break;
            }
            // 出现 nums[i] > pivot && nums[j] <= pivot
            // 交换元素
            swap(nums, i, j);
        }
        // 将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
        swap(nums, lo, j);
        return j;
    }

    private void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0 ; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Quick quick = new Quick();
        int[] arr = {1, 2, 3, 4, 5, 6};
        quick.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
