import java.io.*;
import java.util.*;

public class RansomNote {

    private static final Scanner scanner = new Scanner(System.in);

    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> uniqueWords = new HashMap<>();
        for (String m : magazine) {
            if (uniqueWords.containsKey(m))
                uniqueWords.put(m, uniqueWords.get(m) +1);
            else
                uniqueWords.put(m, 1);
        }

        for (String n : note) {
            if (!uniqueWords.containsKey(n)) {
                System.out.println("No"); return;
            } else 
                if (uniqueWords.get(n) - 1 == 0) 
                    uniqueWords.remove(n);
                else 
                    uniqueWords.put(n, uniqueWords.get(n) - 1);
                
        }
        
        System.out.println("Yes");
    }

    public static void main(String[] args) {
    
        String[] mn = scanner.nextLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];
        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }
        
        checkMagazine(magazine, note);

        scanner.close();
    }
}
