import java.util.Arrays;

/**
 * Leetcode 322 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChangeSolution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // 初始化 dp 数组，大小为 amount + 1
        Arrays.fill(dp, -1); // 全部元素初始化为 -1
        dp[0] = 0; // 金额 0 的最优解 dp[0]=0

        // 依次计算 1 至 amount 的最优解
        for (int i = 1; i <= amount; i++) {
            // 对于每个金额 i ，遍历面值 coins 数组
            for (int j = 0; j < coins.length; j++) {
                // 需要拼凑的面额 i 比当前面值 coins[j] 大，且金额 i - coins[j] 有最优解
                if (coins[j] <= i && dp[i - coins[j]] != -1) {
                    // 如果当前金额还未计算或者 dp[i] 比当前计算的值大
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1) {
                        dp[i] = dp[i - coins[j]] + 1; // 更新 dp[i]
                    }
                }
            }
        }
        return dp[amount]; // 返回金额 amount 的最优解 dp[amount]
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 7, 10};
        int amount = 14;
        System.out.println(
            new CoinChangeSolution().coinChange(coins, amount)
        );
    }
}
