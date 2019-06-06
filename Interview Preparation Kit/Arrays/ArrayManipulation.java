import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class ArrayManipulation {

    private static final Scanner scanner = new Scanner(System.in);

    static int zeroIndex(int oneBaseIndex) { return oneBaseIndex - 1; }

    // Space complexity = O(n)
    static long[] setupArray(int n, int val) {
        long[] arr = new long[n];
        Arrays.fill(arr, val);
        return arr;
    }

    // Time complexity = O(m)xO(n)
    static long arrayManipulation(int n, int[][] queries) {
        long maxVal = 0L; 
        int m = queries.length;
        long[] arr = setupArray(n, 0);
        // O(m) = number of operations
        for (int row = 0; row < m; row++) {
            int start = zeroIndex(queries[row][0]);
            int end = zeroIndex(queries[row][1]);
            long val = queries[row][2];

            for (int i = start; i <= end; i++) {
                arr[i] += val;

                if (arr[i] > maxVal) 
                    maxVal = arr[i];
            }
        }
        return maxVal;
    }

    // To solve terminated due to timeout error issue
    // Using Difference Array logic
    static long fastArrayManipulation(int n, int[][] queries) {
        long len = queries.length;
        long[] arr  = new long[n];
        for (int row = 0; row < len; row++) {
            int p = zeroIndex(queries[row][0]);
            int q = zeroIndex(queries[row][1]);
            int sum = queries[row][2];

            arr[p] += sum;
            if (q+1 < n) arr[q+1] -= sum;
        }

        long tmp = 0L;
        long max = 0L;
        for (int i = 0; i < n; i++) {
            tmp += arr[i];
            if (tmp > max)
                max = tmp;
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = fastArrayManipulation(n, queries);
        System.out.println(result);
        scanner.close();
    }
}
