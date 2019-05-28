import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class NewYearChaos {

    private static final Scanner scanner = new Scanner(System.in);

    // Variant of Bubble Sort, instead of swapping we do counting..
    static void minimumBribes(int[] q) {
        int result = 0;
        int qSize = q.length;
        for (int i = qSize - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic"); return;
            }
    
    // To resolve timeout issue, we need to optimize start index.
            for (int j = Math.max(q[i] - 2, 0); j < i; j++) {
                if (q[j] > q[i])
                    result++;
            }
        }

        System.out.println(result);

    }
    
    public static void main(String[] args) {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }
        scanner.close();
    }

}
