// Problem: Longest Ordered Subsequence of Vowels
// https://www.geeksforgeeks.org/longest-ordered-subsequence-of-vowels/
// This DP problem
//
import java.io.*;
import java.util.*;

public class FunWithVowels_V2 {

    private static final Scanner s = new Scanner(System.in);
    private static List<Character> vowels = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));
    private static Map<Character, Integer> mapping = new LinkedHashMap<Character, Integer>() {{
        put('a', 0);
        put('e', 1);
        put('i', 2);
        put('o', 3);
        put('u', 4);
    }};

    static boolean isValidSequence(List<Character> subList) {
        for (Character v : vowels) {
            if (subList.indexOf(v) == -1) {
                return false;
            }
        }
        return true;
    }

    // This code has problem - "aaeaaeiou" = "aaaaeiou" (8) | "aaeeiou" (7)
    static List<Character> longestSubsequence(String str, List<Character> subList, int index) {
        // Reached at end of str; check if we recieved valid sequence or not
        if (index == str.length()) {
            if (isValidSequence(subList)) {
                System.out.println(Arrays.toString(subList.toArray()) + " = " + "true");
                return subList;
            } else {
                System.out.println(Arrays.toString(subList.toArray()) + " = " + "false");
                return Collections.<Character>emptyList();
            }
        } else {
            // ignore till we find first character 'a'
            if (subList.size() == 0) {
                Character c = str.charAt(index);
                if (c != 'a') { 
                    System.out.println("first char is not a");
                    return longestSubsequence(str, subList, index + 1);
                } else {
                    subList.add(c);
                    return longestSubsequence(str, subList, index + 1);
                }
            } else if ( mapping.get(subList.get(subList.size()-1)) == mapping.get(str.charAt(index)) ) {
                // If last vowel in subseq is same as at current index, add it to the subsequence
                    subList.add(str.charAt(index));
                    return longestSubsequence(str, subList, index + 1);
            } else if ( mapping.get(subList.get(subList.size()-1))+1 == mapping.get(str.charAt(index)) ) {
                // If current index vowel comes after last vowel in subseq, we have two options:
                // Either to add the vowel in the subsequence
                // OR move to next character
                // We choose the one which gives the longest subseq
                List<Character> oldList = new ArrayList<>(subList);
                subList.add(str.charAt(index));
                List<Character> sub1 = longestSubsequence(str, subList, index + 1);
                List<Character> sub2 = longestSubsequence(str, oldList, index + 1);
                if ( sub1.size() > sub2.size() )
                    return sub1;
                else 
                    return sub2;
            } else {
                // Non-vowel character
                return longestSubsequence(str, subList, index + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        
        String str = s.nextLine();
        // 0 or longest subsequence size
        int size = longestSubsequence(str, new ArrayList<Character>(), 0).size();
        System.out.println(size);
    }
}
