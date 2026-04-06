package hackerEarth_Program_Setter_2025;

import java.util.*;

public class Modified_Knapsack {

    public static int findmax(int[][] item, int k) {
        // Step 1: Group items by type
        Map<Integer, List<int[]>> typeMap = new HashMap<>();
        for (int[] it : item) {
            int type = it[0], weight = it[1], value = it[2];
            typeMap.putIfAbsent(type,new ArrayList<>());
            typeMap.get(type).add(new int []{weight,value});
        }

        // Step 2: DP array
        int[] dp = new int[k + 1];

        // Step 3: Process each type (multi-choice knapsack)
        for (List<int[]> itemsOfType : typeMap.values()) {
            // For each type, we must consider "pick none" or "pick exactly one item"
            int[] newDp = dp.clone();

            for (int[] it : itemsOfType) {
                int w = it[0], v = it[1];
                for (int cap = k; cap >= w; cap--) {
                    newDp[cap] = Math.max(newDp[cap], dp[cap - w] + v);
                }
            }
            dp = newDp; // update after finishing this type
        }

        // Step 4: Answer is max value achievable with weight ≤ k
        int ans = 0;
        for (int cap = 0; cap <= k; cap++) {
            ans = Math.max(ans, dp[cap]);
        }
        return ans;
    }

    public static void main(String[] args) {
        // Sample input
        int[][] items = {
                {3, 1, 13},
                {5, 1, 10},
                {1, 9, 1},
                {4, 5, 11},
                {2,4,7},
                {6,3,12}
        };
        int k = 10;

        System.out.println(findmax(items, k)); // Expected output: 24
    }
}