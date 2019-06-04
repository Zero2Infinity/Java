import java.io.*;
import java.util.*;

public class TwoStrings {

    public static final Scanner scanner = new Scanner(System.in);

    static String twoStrings_rahul(String s1, String s2) {
        String result = "NO";
        Map<Character, Integer> cSet1 = new HashMap<>();

        // O(s1)
        for (Character c : s1.toCharArray()) {
            if (cSet1.get(c) == null)
                cSet1.put(c, 1);
            else 
                cSet1.put(c, cSet1.get(c) + 1);
        }
    
        // O(s2)
        for (char c : s2.toCharArray()) {
            if (cSet1.get(c) != null)
                result = "YES";
        }

        return result;
    }

    static String twoStrings(String s1, String s2) {
        String abc = "abcdefghijklmnopqrstuvwxyz";

        for (char c : abc.toCharArray()) {
            if ( s1.indexOf(c) > -1 && s2.indexOf(c) > -1 )
                return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }

        scanner.close();
    }

}
