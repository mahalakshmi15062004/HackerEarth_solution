import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        long sumA = 0;
        long countA = 0;
        long sumB = 0;
        long countB = 0;

       
        for (int i = 0; i < n; i++) {
            long val = sc.nextLong();
            if (val == -1) {
                countA++;
            } else {
                sumA += val;
            }
        }

    
        for (int i = 0; i < n; i++) {
            long val = sc.nextLong();
            if (val == -1) {
                countB++;
            } else {
                sumB += val;
            }
        }

      

        if (countA == countB) {
            // If the number of -1s is the same, they cancel out
            if (sumA == sumB) {
                System.out.println("Infinite");
            } else {
                System.out.println(0);
            }
        } else {
       
            long numerator = sumB - sumA;
            long denominator = countA - countB;

           
            if (numerator % denominator == 0) {
                long x = numerator / denominator;
               
                if (x >= 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                // Division results in a decimal, not a whole integer
                System.out.println(0);
            }
        }
        
        sc.close();
    }
}
