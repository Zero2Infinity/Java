import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class SockMerchant {

    private static final Scanner scanner = new Scanner(System.in);
    
    // Return the total number of matching pairs of socks.
    static int sockMerchant(int n, int[] ar) {
        int pairFound = 0;
        Map<Integer, Integer> socks = new HashMap<>();
        for (int s : ar) {
            if (!socks.containsKey(s)) {
                socks.put(s, 1);
            } else {
                socks.remove(s);
                pairFound++;
            }
        }
        return pairFound;
    }


    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] ar = new int[n];
        String[] arItems = scanner.nextLine().split(" ");
        
        for (int i=0; i<n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
            
        int result = sockMerchant(n, ar);
        System.out.println(result);

        scanner.close();
    }
}
