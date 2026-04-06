package hackerEarth_Program_Setter_2025;

import java.util.*;

public class K_Frequency {

    static String kthFrequency(String s, int k) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Collect unique frequencies in descending order
        Set<Integer> freqSet = new HashSet<>(freqMap.values());
        List<Integer> freqList = new ArrayList<>(freqSet);
        freqList.sort(Collections.reverseOrder());

        // Step 3: If k-th frequency doesn't exist
        if (k > freqList.size()) {
            return "-1";
        }

        int targetFreq = freqList.get(k - 1);

        // Step 4: Collect all characters with that frequency
        List<Character> candidates = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == targetFreq) {
                candidates.add(entry.getKey());
            }
        }

        // Step 5: Return smallest lexicographically
        Collections.sort(candidates);
        return candidates.get(0) + "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            System.out.println(kthFrequency(s, k));
        }
        sc.close();
    }
}
//input
//2
// aabcd 2
// aabcd 1