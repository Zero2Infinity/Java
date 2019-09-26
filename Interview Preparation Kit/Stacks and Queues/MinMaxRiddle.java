import java.io.*;
import java.util.*;

public class MinMaxRiddle {

    private static final Scanner scanner = new Scanner(System.in);

    // Time complexity = O(n)
    static long[] riddle(long[] arr) {
        // Setup left, right, ans, Stack<>
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        long[] ans = new long[arr.length + 1];
        Arrays.fill(left, -1);
        Arrays.fill(right, arr.length);
        Arrays.fill(ans, 0);

        Stack<Integer> st = new Stack<>();

        // left[] to store indices of the previous smaller element
        for (int i = 0; i < arr.length; i++) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (!st.empty()) {
                left[i] = st.peek();
            }

            st.push(i);
        }
        
        // clean up stack
        while (!st.empty()) {
            st.pop();
        }

        // right[] to store indices of the next smaller element
        for (int i = arr.length-1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (!st.empty()) {
                right[i] = st.peek();
            }

            st.push(i);
        }

        // clean up stack
        while (!st.empty()) {
            st.pop();
        }

        // Now, you can observe that arr[i] (0<=i<n) is the smallest element
        // in the range of next[i] - previous[i] - 1.
        int len;
        for (int i = 0; i < arr.length; i++) {
            len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }

        // After this, we may have some values of res[i] which are 0.
        // There is also an interesting observation that res[i] >= res[i+1].
        // So we can fill the remaining values by using this condition.
        for (int i = arr.length - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i+1]);
        }

        long[] res = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = ans[i + 1];
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
