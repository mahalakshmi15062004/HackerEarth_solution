import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            if (n <= 0) continue;

            int[] pos = new int[n];
            for (int i = 0; i < n; i++) {
                pos[fr.nextInt()] = i;
            }

            long[] ans = new long[n + 1];
            
           
            int L = pos[0];
            int R = pos[0];
            
           
            for (int k = 1; k < n; k++) {
                int pk = pos[k];
                
                if (pk < L) {
                  
                    ans[k] = (long) (L - pk) * (n - R);
                } else if (pk > R) {
                    
                    ans[k] = (long) (L + 1) * (pk - R);
                } else {
                    
                    ans[k] = 0;
                }
                
                
                L = Math.min(L, pk);
                R = Math.max(R, pk);
            }
            
            
            ans[n] = 1;
            
            
            StringBuilder sb = new StringBuilder();
            for (int k = 1; k <= n; k++) {
                sb.append(ans[k]);
                if (k < n) sb.append(" ");
            }
            out.println(sb.toString());
        }
        out.flush();
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

