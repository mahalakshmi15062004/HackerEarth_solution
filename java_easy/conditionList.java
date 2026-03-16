import java.util.*;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
 
        while (t-- > 0) {
            int l = sc.nextInt();
            int[] x = new int[l];
            long totalSum = 0;
 
            for (int i = 0; i < l; i++) {
                x[i] = sc.nextInt();
                totalSum += x[i];
            }
 
            String result = "NO";
            long leftSum = 0;
 
            for (int i = 0; i < l; i++) {
               
                if (leftSum == (totalSum - leftSum - x[i])) {
                    result = "YES";
                    break;
                }
                leftSum += x[i];
            }
            System.out.println(result);
        }
    }
}
