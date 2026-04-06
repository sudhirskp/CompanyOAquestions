package hackerEarth_Program_Setter_2025;

//hard
public class Count_The_pair {
    static long Count_sol(int N, int[] A, int[] B) {

        int maxlimit = 1000000;

        int[] fra = new int[maxlimit + 1];
        int[] frb = new int[maxlimit + 1];

        for (int a : A) fra[a]++;
        for (int b : B) frb[b]++;

        int[] diva = new int[maxlimit + 1];
        int[] divb = new int[maxlimit + 1];

        // count multiples
        for (int i = 1; i <= maxlimit; i++) {
            for (int j = i; j <= maxlimit; j += i) {
                diva[i] += fra[j];
                divb[i] += frb[j];
            }
        }

        long[] gcc = new long[maxlimit + 1];

        // inclusion-exclusion
        for (int i = maxlimit; i >= 1; i--) {
            gcc[i] = (long) diva[i] * divb[i];

            for (int j = 2 * i; j <= maxlimit; j += i) {
                gcc[i] -= gcc[j];
            }
        }

        long totalPairs = (long) N * N;

        return totalPairs - gcc[1];   // gcd > 1
    }

    public static void main(String[] args) {
        int n = 2;
        int A [] = {2,4};
        int B [] = {4,2};
        System.out.println(Count_sol(2,A,B));
    }
}
//2
//2 4
//4 2
//out: 4
