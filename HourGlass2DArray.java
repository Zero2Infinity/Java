import java.io.*;
import java.util.Scanner;

public class HourGlass2DArray {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int SIZE = 6;
    /** Hourglass digram:
    *  X X X           
    *    X
    *  X X X
    **/
    static int hourGlassSum(int[][] arr) {
        int largestSum = Integer.MIN_VALUE;
        for (int i=0; i<SIZE-2; i++) {
            for (int j=0; j<SIZE-2; j++) {
                 int sum = arr[i+0][j+0] + arr[i+0][j+1] + arr[i+0][j+2] 
                            + arr[i+1][j+1] 
                            + arr[i+2][j+0] + arr[i+2][j+1] + arr[i+2][j+2];
                if (largestSum < sum)
                    largestSum = sum; 
            }
        }
       return largestSum; 
    }

    public static void main(String[] args) throws IOException {

        int[][] arr = new int[SIZE][SIZE];
        for (int i=0; i<SIZE; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            for (int j=0; j<SIZE; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourGlassSum(arr);
        System.out.print(result);
    }
}
