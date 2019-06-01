import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class MinimumSwaps2 {

    public static final Scanner scanner = new Scanner(System.in);

    static List<Integer> cycleSize(int[] arr, int sIndex) {
        List<Integer> cycle = new ArrayList<>();
        cycle.add(sIndex);
        int sValue = arr[sIndex] - 1;
        while (sIndex != sValue) {
            cycle.add(sValue);
            sValue = arr[sValue] - 1;
        }

        return cycle;
    }
    
    // Idea was to use Array and not List :)
    static int minimumSwaps(int[] arr) {
        int numSwaps = 0;
    // Before I was using List<Integer> to keep tracked our travsersed indexes but search complexity was O(n). Failed to pass all tests.
        List<Boolean> visitedIndex = 
            new ArrayList<>(Collections.nCopies(arr.length, Boolean.FALSE));
        for (int i = 0; i < arr.length; i++) {
            if (visitedIndex.get(i)) {
                // skip that index since it already traversed
                continue;
            } else {
                // find the circular graph
                List<Integer> cycle = cycleSize(arr, i);
    // Below for() is unnecessary
                for (int c : cycle) 
                    visitedIndex.set(c, Boolean.TRUE);
                numSwaps += cycle.size() - 1;
           }
        }
        return numSwaps;
    }

    static int valueToArrIndex(int val) { return val - 1; }

    static int minimumSwaps_v2(int[] arr) {
        int numSwaps = 0;
        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);
        
        for (int i = 0; i < arr.length; i++) {
            int iVal = arr[i];
           
            if ( visited[i] || i == valueToArrIndex(iVal) ) {
                System.out.println("skipping index = " + i);
                continue;
            } else {
                // Formula: sum of each (cycle - 1) found
                visited[i] = true;  // account for first index
                int nodes = 1;
                int valToIdx = valueToArrIndex(iVal);
                while (i != valToIdx) {
                    visited[valToIdx] = true;

                    System.out.println(i + " == " + valToIdx);
                    valToIdx = valueToArrIndex(arr[valToIdx]);

                    nodes++;
                }

                numSwaps += (nodes - 1);
            } // else 
        } // for

        return numSwaps;
    }

    public static void main(String[] args) throws IOException {
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] arr = new int[n];
        
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps_v2(arr);
        System.out.print(res);
    }
}
