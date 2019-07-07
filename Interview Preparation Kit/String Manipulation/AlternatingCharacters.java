import java.io.*;
import java.util.*;

public class AlternatingCharacters {

    private static final Scanner scanner = new Scanner(System.in);

    private static String removeAllDuplicates(String s) {
        String output = "";
        if (s.length() == 1) return s;  // Exception for one char

        char curr;
        char next = '\0';
        for (int i = 0; i < s.length() - 1; i++) {
            curr = s.charAt(i);
            next = s.charAt(i+1);
            if (curr != next) {
                output += String.valueOf(curr);    // Difference chars; add
            } else {
                continue;    // Found same pair; skip
            }
        }
        output += String.valueOf(next); // last left-out char
        // System.out.println(output);
        return output;
    }

    // Remove duplicates one at a time
    private static String removeDuplicates(String s) {
        for (int i = 1; i < s.length(); i++) {
            char prev = s.charAt(i-1);
            char curr = s.charAt(i);
            if (prev == curr) {
                return (s.substring(0, i-1)) + (s.substring(i, s.length()));
            }
        }
        return s;
    }

    // Terminated due to timeout
    static int alternatingCharacters_v1(String s) {
        int len = s.length();
        String temp; 
        do {
            temp = s;
            s = removeAllDuplicates(temp);
            System.out.println(temp + " == " + s);
        } while(!temp.equals(s));
        return len - s.length();
    }

    // Turns out I was overthinking this problem!
    static int alternatingCharacters(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            int result = alternatingCharacters(s);
            System.out.println(result);
        }

        scanner.close();
    }
}
