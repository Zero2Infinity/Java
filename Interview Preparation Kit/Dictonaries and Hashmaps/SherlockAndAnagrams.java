import java.io.*;
import java.util.*;

public class SherlockAndAnagrams {

    private static final Scanner scanner = new Scanner(System.in);

    // Find all substrings of a word
    static void printSubstrings(String s) {
        int len = s.length();
        int c = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i ; j < len; j++) {
                System.out.println(++c + " = " + s.substring(i,j+1));
            }
        }
    }

    static int sherlockAndAnagrams(String s) {
        Map<Integer, Integer> signatures = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i ; j < len; j++) {
                String substr = s.substring(i, j+1);
                // System.out.println(substr);
                Integer[] signature = new Integer[26];
                Arrays.fill(signature, new Integer(0));
                for (char c : substr.toCharArray()) {
                    int index = c - 'a';
                    signature[index] += 1;
                }
                // Generate hashcode of signature
                Integer sign = Arrays.hashCode(signature);
                // Like Python, HashMap could return defaultValue if Key not found.
                signatures.put(sign, 
                               signatures.getOrDefault(sign, 0) + 1);
                
            }
        }

        Integer result = 0;
        for (Map.Entry<Integer, Integer> e : signatures.entrySet()) {
            result += e.getValue().intValue() * (e.getValue().intValue() - 1) / 2;
        }
        return result.intValue();
    }

    public static void main(String[] args) throws IOException {
    
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
        }
        
        scanner.close();
    }
}
