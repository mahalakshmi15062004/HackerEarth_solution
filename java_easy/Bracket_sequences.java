import java.util.Scanner;

public class Bracket_sequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Check if there is input
        if (!sc.hasNext()) {
            return;
        }
        
        String s = sc.next();
        int n = s.length();
        
        int currentBalance = 0;
        int minBalance = 0;
        int count = 1; // Initialized to 1 to account for the starting prefix sum of 0

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                currentBalance++;
            } else {
                currentBalance--;
            }

            if (i < n - 1) {
                if (currentBalance < minBalance) {
                    minBalance = currentBalance;
                    count = 1;
                } else if (currentBalance == minBalance) {
                    count++;
                }
            }
        }

     
        if (currentBalance != 0) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
        
        sc.close();
    }
}
