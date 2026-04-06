package Zorvyn_2026;

import java.util.Arrays;
import java.util.Scanner;

public class Optimal_Array_Partion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // array size
        int k = sc.nextInt();  // number of partitions

        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        // Step 1: Precompute cost of every subarray a[l..r]
        // cost = (max - min) * length
        long[][] cost = new long[n + 1][n + 1];
        for (int l = 1; l <= n; l++) {
            int max = a[l], min = a[l];
            for (int r = l; r <= n; r++) {
                if (a[r] > max) max = a[r];
                if (a[r] < min) min = a[r];
                cost[l][r] = (long) (max - min) * (r - l + 1);
            }
        }

        // Step 2: DP
        // dp[i][j] = minimum cost to split first i elements into j parts
        long INF = Long.MAX_VALUE / 2;
        long[][] dp = new long[n + 1][k + 1];

        // Fill everything with infinity initially
        for (long[] row : dp) Arrays.fill(row, INF);

        // Base case: 0 elements, 0 partitions = 0 cost
        dp[0][0] = 0;

        // Try all splits
        for (int j = 1; j <= k; j++) {          // j = number of parts
            for (int i = j; i <= n; i++) {       // i = current end index
                for (int p = j - 1; p < i; p++) {  // p = where last part starts
                    if (dp[p][j - 1] == INF) continue;
                    // last subarray is a[p+1 .. i]
                    long total = dp[p][j - 1] + cost[p + 1][i];
                    if (total < dp[i][j]) {
                        dp[i][j] = total;
                    }
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
//input
//5 2
//1 3 2 5 4 , out - 8