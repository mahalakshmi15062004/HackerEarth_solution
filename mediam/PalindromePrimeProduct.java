import java.util.*;

public class PalindromePrimeProduct {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int maxM = sc.nextInt();
        int Q = sc.nextInt();
        int[] queries = new int[Q];
        for (int i = 0; i < Q; i++) queries[i] = sc.nextInt();
        List<Integer> primes = getPrimes(maxM);
        int MAX_LEN = 20; 
        long[][] dp = new long[MAX_LEN + 1][maxM + 1];
        dp[0][1] = 1;

        for (int p : primes) {
            for (int i = 1; i <= MAX_LEN; i++) {
                for (int j = p; j <= maxM; j++) {
                    if (j % p == 0) {
                        dp[i][j] = (dp[i][j] + dp[i-1][j/p]) % MOD;
                    }
                }
            }
        }

       
        StringBuilder sb = new StringBuilder();
        for (int mLimit : queries) {
            long count = 0;
            for (int L = 1; L <= N; L++) {
                count = (count + countPalindromic(L, mLimit, dp, primes)) % MOD;
            }
            sb.append(count).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static long countPalindromic(int L, int limit, long[][] dp, List<Integer> primes) {
        long total = 0;
        int k = L / 2;
        if (L % 2 == 0) {
          
            for (int p = 1; p * p <= limit; p++) {
                total = (total + dp[k][p]) % MOD;
            }
        } else {
          
            for (int p = 1; p * p <= limit; p++) {
                if (dp[k][p] == 0) continue;
                for (int m : primes) {
                    if ((long)p * p * m <= limit) {
                        total = (total + dp[k][p]) % MOD;
                    } else break;
                }
            }
        }
        return total;
    }

    private static List<Integer> getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) isPrime[i] = false;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) if (isPrime[i]) list.add(i);
        return list;
    }
}
