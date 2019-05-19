import java.io.*;
import java.util.Scanner;

public class LeftRotation {

    private static final Scanner scanner = new Scanner(System.in);

    static void printArr(int[] arr) {            
        for (int i=0; i<arr.length; i++)         
            System.out.print(arr[i] + " ");      
    }                                            
                                                 
    // Perform 'd' times left rotations                
    // Formula: (d + (0..len-1) % len)           
    static int[] rotLeft(int[] a, int d) {       
        int len = a.length;                      
        int[] out = new int[len];                
        for (int i=0; i<len; i++) {              
            out[i] = a[(d+i)%len];               
        }                                        
        return out;                              
    } 

    // Rotate in the same array -> Space (1)
    static int[] rotLeftInPlace(int[] a, int d) {
        int aLen = a.length;
        for (int r =0; r<d; r++) {
            int firstElement = a[0];
            for (int i=1; i<aLen; i++) {
                a[i-1] = a[i];
            }
            a[aLen-1] = firstElement;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] a = new int[n];
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);
        printArr(result);
    }

}
