import java.io.*;
import java.util.Scanner;

public class CountingValleys {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final int GROUND_LEVEL = 0;
    /**
     *  Complete the countingValleys function that denotes the number of valleys traversed.
     */
    static int countingValleys(int n, String s) {
        int countValleys = 0;       // Start from ground-level
        int currentHeight = 0; 
        char[] hikes = s.toCharArray();
        for (char h : hikes) {
            switch(h) {
                case 'U': 
                            if (currentHeight == GROUND_LEVEL-1) {
                                countValleys++;
                            }
                            currentHeight++; 
                            break;
                case 'D': 
                            currentHeight--; 
                            break;
            } 
        } 
        return countValleys;
    }

    public static void main(String[] args) throws IOException {
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        
        System.out.println(result);
        scanner.close();
    }
}
