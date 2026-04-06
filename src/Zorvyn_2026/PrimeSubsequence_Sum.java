package Zorvyn_2026;

import java.util.Scanner;

public class PrimeSubsequence_Sum {

    static final long MOD = 1_000_000_007;

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            totalSum += a[i];
        }

        long[] dp = new long[totalSum + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int s = totalSum; s >= a[i]; s--) {  // ← must be backwards
                dp[s] = (dp[s] + dp[s - a[i]]) % MOD;
            }
        }

        long answer = 0;
        for (int s = 2; s <= totalSum; s++) {
            if (isPrime(s))
                answer = (answer + dp[s]) % MOD;
        }

        System.out.println(answer);
    }
}
//3
// 1 2 3
//out : 4

//Quick recap of what we used:

//Q1 ApproachQ1DP + precomputed subarray costs
// Q2 Simple scan with min tracking
// Q3 Knapsack DP + prime check