import java.io.*;
import java.util.*;

public class MinMaxRiddle {

    private static final Scanner scanner = new Scanner(System.in);

    // Time complexity: O(n^2)
    // First, build min value per window
    // Store these information in Map<Long, List<Long>>
    // Second, find max per window size 
    // e.g. https://www.hackerrank.com/challenges/min-max-riddle/problem
    static long[] riddle(long[] arr) {
        long[] res = new long[arr.length];
        Map<Long, List<Long>> table = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            long minValue = Long.MAX_VALUE;
            long count = 0;
            for (int j = i; j < arr.length; j++) {
                minValue = Math.min(minValue, arr[j]);
                if (table.containsKey(count)) {
                    List<Long> newList = new ArrayList<>();
                    newList.addAll(table.get(count));
                    newList.add(minValue);
                    table.put(count, newList);
                } else {
                    table.put(count, Arrays.asList(minValue));
                }
                count++;
            }
        }

        int count = 0;
        for (List<Long> t : table.values()) {
            // System.out.println(t.toString());
            long maxValue = Long.MIN_VALUE;
            for (Long i : t) {
               maxValue = Math.max(maxValue, i);
            }
            res[count++] = maxValue;
        }

        return res;
    }

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }
        
        long[] res = riddle(arr);
        for (long r : res)
            System.out.print(r + " ");
        
        scanner.close();
    }
}
