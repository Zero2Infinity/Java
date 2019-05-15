import java.io.*;
import java.util.Scanner;

public class RepeatedString {

    private static final Scanner scanner = new Scanner(System.in);
    
    static int countCharOccurences(String s, int end, char ch) {
        int count = 0;
        for (int i=0; i<end; i++) {
            if (s.charAt(i) == ch) count++;
        }
        return count;
    }

    // Return an long representing the no of occurences of 'a' in repeating string.
    static long repeatedString(String s, long n) {
        int strLen = s.length();
        long quotient = n/strLen;
        long remainder = n%strLen;

        long result = 0;
        long occurence = (long)countCharOccurences(s, strLen, 'a');
        // Improvement would be calculate both occurences at one time in for loop
        result = quotient * occurence + countCharOccurences(s, (int)remainder, 'a');
        return result;
    }

    public static void main(String[] args) throws IOException {
    
        String s = scanner.nextLine();
    
        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);

        scanner.close();

    }

}
