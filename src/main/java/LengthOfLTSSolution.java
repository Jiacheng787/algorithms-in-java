import java.util.Arrays;

public class LengthOfLTSSolution {
    public int lengthOfLTS(int[] nums) {
        // 定义 dp 数组
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列长度
        int[] dp = new int[nums.length];
        // 初始值填充 1（子序列至少包含当前元素自己）
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 假设 dp[0...i-1] 都已知，需要求出 dp[i]
                // 只需要遍历 nums[0...i-1]，找到结尾比 nums[i] 小的子序列 dp[j]
                // 然后把 nums[i] 接到最后，就可以形成一个新的递增子序列，长度为 dp[j] + 1
                // 显然，可能形成很多种新的子序列，只需要选择最长的，作为 dp[i] 的值即可
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 遍历 dp 数组，找出最大值
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 4, 2, 3};
        LengthOfLTSSolution solution = new LengthOfLTSSolution();
        System.out.println(solution.lengthOfLTS(arr));
    }
}
