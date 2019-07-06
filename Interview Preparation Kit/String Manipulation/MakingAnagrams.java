import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MakingAnagrams {

    private static final Scanner scanner = new Scanner(System.in);

    // O(a+b+26) - frequency[26] increment and decrement and remaining freq added to deleted chars.
    // O(n+m)
    static int makeAnagram_v2(String a, String b) {
        Map<String, Integer> aMap = new HashMap<>();
        List<String> aList = Arrays.asList(a.split(""));
        for (String s : aList) {
            aMap.put(s, aMap.getOrDefault(s, 0) + 1);
        }

        List<String> bList = Arrays.asList(b.split(""));
        int result = 0;
        for (String s : bList) {
            if (aMap.containsKey(s)) {
                Integer count = aMap.get(s);
                if (count > 0) {
                    aMap.put(s, aMap.get(s) - 1);
                    result += 2;
                }
            }
        }

        return (a.length() + b.length()) - result;
    }
    // O(n logn) - Sort two strings and scan each char to find common chars
    // O(n^2)
    static int makeAnagram(String a, String b) {
        // char[] to List<Character> is incompatible conversion
        List<Character> temp = b.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        for (char aChar : a.toCharArray()) {
            for (Character t : temp) {
                if (aChar == t) {
                    temp.remove(t);
                    break;
                }
            }
        }

        int commonChars = b.length() - temp.size();
        // int aDel = a.length() - commonChars;
        // int bDel = b.length() - commonChars;
        return (a.length() + b.length()) - (commonChars * 2); // Chars to be deleted to get anagram
    }

    public static void main(String[] args) throws IOException {
        
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        // int res = makeAnagram(a, b);
        int res = makeAnagram_v2(a, b);
        System.out.println(res);

        scanner.close();
    }
}
