package pattern;

public class kspdynamic {
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 5};
        int[] values = {10, 20, 30, 50};
        int capacity = 8;
        int maxValue = knapsack(weights, values, capacity);
        System.out.println("The maximum value that can be attained: " + maxValue);
    }
}
