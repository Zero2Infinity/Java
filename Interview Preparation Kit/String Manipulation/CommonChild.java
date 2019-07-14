// Problem space: Longest common subsequence - Dynamic Programming
//
// First way (not meeting all criteria):
// OUDFRMYMAW  | AWHYFCCMQX = 5 instead of 2.
// 1. Sort the string - Problem: distort the nature string ordering
// 2. scan left to right and find common childs
// Time complexity = (n log n)
//
// Second way:
// 1. Find the subsequence of first and second string
// 2. Find the largest common subsequence in both.

import java.io.*;
import java.util.*;

public class CommonChild {

    private static final Scanner scanner = new Scanner(System.in);

    private static Set<String> subseq1 = new HashSet<>();
    private static Set<String> subseq2 = new HashSet<>();

    private static Set<String> subsequence(Set<String> subseq, String s) {
        for (int pos = 0; pos < s.length(); pos++) {
            for (int range = s.length(); range > pos; range--) {

                String str = s.substring(pos, range);

                if (!subseq.contains(str))
                    subseq.add(str);

                for (int drop = 1; drop < str.length(); drop++) {
                    StringBuffer sb = new StringBuffer(str);
                    sb.deleteCharAt(drop);
                    if (!subseq.contains(sb))
                        subsequence(subseq, sb.toString());
                }
            }
        }

        return subseq;
    }

    static int commonChild(String s1, String s2) {
      Set<String> a1 = subsequence(subseq1, s1);
      Set<String> a2 = subsequence(subseq2, s2);
      // System.out.println(a1);
      // System.out.println(a2);

      int max = 0;
      for (String s : a1) {
          if (a2.contains(s) && s.length() > max) {
              max = s.length();
              System.out.println(s);
          }
      }
      return max;
    }

    public static void main(String[] args) throws IOException {
        
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int result = commonChild(s1, s2);
        System.out.println(result);

        scanner.close();
    }
}
