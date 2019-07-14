// Problem space: Longest common subsequence - Dynamic Programming
//
// First way (not meeting all criteria):
// OUDFRMYMAW  | AWHYFCCMQX = 5 instead of 2.
// 1. Sort the string - Problem: distort the nature string ordering
// 2. scan left to right and find common childs
// Time complexity = (n log n)
//

import java.io.*;
import java.util.*;

public class CommonChild {

    private static final Scanner scanner = new Scanner(System.in);

    private static char[] sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        System.out.println(c);
        return (c);
    }

        static int commonChild(String s1, String s2) {
        char[] sort1 = sortString(s1);
        char[] sort2 = sortString(s2);
        int size = s1.length();
        int count = 0;

        int i = 0;
        int j = 0;
        while (size != i && size != j) {
            System.out.println(sort1[i] + " == " + sort2[j]);
            if (sort1[i] == sort2[j]) {
                count++; i++; j++;
            } else if (sort1[i] < sort2[j]) {
                i++;
            } else if (sort1[i] > sort2[j]) {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int result = commonChild(s1, s2);
        System.out.println(result);

        scanner.close();
    }
}
