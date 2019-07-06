// Problem: Longest Ordered Subsequence of Vowels
// https://www.geeksforgeeks.org/longest-ordered-subsequence-of-vowels/

import java.io.*;
import java.util.*;

public class FunWithVowels {

    private static final Scanner s = new Scanner(System.in);
    private static List<Character> vowels = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));

    static boolean isValidSequence(List<Character> subStr) {
        for (Character v : vowels) {
            if (!subStr.contains(v))
                return false;
        }
        return true;
    }

    static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }

    // This code has problem - "aaeaaeiou" = "aaaaeiou" (8) | "aaeeiou" (7)
    static int longestSubsequence(String s) {
        Character curr_vowel = vowels.get(0);
        List <Character> subStr = new ArrayList<>();
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                if (c == curr_vowel) {
                    subStr.add(c);
                } else if (c > curr_vowel) {
                    curr_vowel = c;
                    subStr.add(c);
                }
            }
        }
        int size = vowels.size();
        if (isValidSequence(subStr))
            return subStr.size();
        else 
            return 0;
    }

    public static void main(String[] args) throws Exception {
        
        String str = s.nextLine();
        System.out.println(longestSubsequence(str));
    }
}
