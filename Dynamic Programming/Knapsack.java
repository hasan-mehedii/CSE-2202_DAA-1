import java.util.*;

// 0/1 Knapsack Problem
public class Knapsack {

    int knapSack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String args[]) {
        Knapsack knapsack = new Knapsack();
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println("Maximum value we can obtain = " + knapsack.knapSack(W, wt, val, n));
    }
}

