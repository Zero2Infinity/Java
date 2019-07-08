import java.io.*;
import java.util.*;
import java.lang.Math;

public class SherlockAndValidString {

    private static final Scanner scanner = new Scanner(System.in);

    static String isValid(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (Character c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        
        // #1 One character form string
        if (charFrequency.size() == 1)
            return "YES";

        Map<Integer, Integer> uniqueCount = new HashMap<>();
        for (Integer i : charFrequency.values()) {
            uniqueCount.put(i, uniqueCount.getOrDefault(i, 0) + 1);
        }

        // System.out.println(charFrequency);
        // System.out.println(uniqueCount);

        if (uniqueCount.size() == 2) {
            // compute the difference
            List<Integer> keys = new ArrayList<>(uniqueCount.keySet());
            List<Integer> counts = new ArrayList<>(uniqueCount.values());
            // #3 If all have the same freq except 1 char which as 1 freq
            if ( (keys.get(0) == 1 && counts.get(0) == 1)
                    || (keys.get(1) == 1 && counts.get(1) == 1) ) {
                return "YES";
            } else if (Math.abs(keys.get(0) - keys.get(1)) == 1
                    && (counts.get(0) == 1 || counts.get(1) == 1) ) {
                // #4 If only 1 char has a freq that 1 greater than all others
                return "YES";

            }
        } else if (uniqueCount.size() == 1) {
            // #2 If all have the same fequency
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();
        String result = isValid(s);
        System.out.println(result);

        scanner.close();
    }
}
