import java.io.*;
import java.util.Scanner;


public class JumpingOnTheClouds {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int CUMULUS = 0;
    private static final int THUNDERHEADS = 1;
    private static final int ONE_STEP = 1;
    private static final int TWO_STEP = 2;
    // Jump size is 1 or 2.
    // Return min. number of jumps required w/o jumping over thunderheads
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int lastCloud = c.length-1;
        int currentCloud = 0;

        do {
            if (currentCloud != lastCloud - 1 
                    && c[currentCloud+TWO_STEP] != THUNDERHEADS) {
                jumps++;
                currentCloud += TWO_STEP;
            } else {
                jumps++;
                currentCloud += ONE_STEP;
            } 
            // System.out.println("Cloud=" + currentCloud);
        } while (currentCloud < lastCloud);
        
        return jumps;
    }

    public static void main(String[] args) throws IOException {
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];
        String[] cItems = scanner.nextLine().split(" ");
        
        for (int i=0; i<n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println(result);

        scanner.close();
    }

}
