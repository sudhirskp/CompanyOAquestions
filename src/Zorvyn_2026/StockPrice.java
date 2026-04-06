package Zorvyn_2026;

import java.util.Scanner;

public class StockPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] price = new int[n + 1];
        for (int i = 1; i <= n; i++)
            price[i] = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int idx = sc.nextInt();
                int x = sc.nextInt();
                price[idx] = x;

            } else {
                int l = sc.nextInt();
                int r = sc.nextInt();

                int minSoFar = price[l];
                long maxProfit = 0;

                for (int j = l + 1; j <= r; j++) {
                    maxProfit = Math.max(maxProfit, price[j] - minSoFar);
                    minSoFar = Math.min(minSoFar, price[j]);
                }

                sb.append(maxProfit).append("\n");
            }
        }

        System.out.print(sb);
    }
}
//input
//5 4
//3 1 4 1 5
//2 1 5
//2 2 4
//1 3 2
//2 1 5
//out : 4 3 4