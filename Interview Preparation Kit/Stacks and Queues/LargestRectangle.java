import java.io.*;
import java.util.*;

public class LargestRectangle {

    private static final Scanner scanner = new Scanner(System.in);

    // Time complexity: O(n^2)
    // Simple approach - 
    // consider every bar as a starting point of area
    // keep track of min bar and max area build
    static long largestRectangle_n2(int[] h) {
        long ans = 0;
        for (int j = 0; j < h.length; j++) {
            long min_height = Integer.MAX_VALUE;
            long max_area = 0;
            for (int k = j; k < h.length; k++) {
                min_height = Math.min(min_height, h[k]);
                max_area = Math.max(max_area, min_height * (k-j+1));
            }

            ans = Math.max(ans, max_area);
        }
        return ans;
    }

    // Time complexity: O(n)
    // Using stack...
    static long largestRectangle(int[] h) {
        int[] heights = new int[h.length + 1];
        System.arraycopy(h, 0, heights, 0, h.length);
        heights[h.length] = 0;

        Stack<Integer> S = new Stack<>();
        long sum = 0;
        int i = 0;

        while (i < heights.length) {
            if (S.empty() || heights[i] > heights[S.peek()]) {
                S.push(i);
                i++;
            } else {
                int top = S.pop();
                sum = Math.max( sum, heights[top] * (S.empty() ? i : (i-S.peek()-1)) );
            }
        }
                
        return sum;
    }

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);
        System.out.println(result);

        scanner.close();
    }
}
