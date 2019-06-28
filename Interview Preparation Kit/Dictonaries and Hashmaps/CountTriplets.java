import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    static boolean isGeometricProgression(Long a, Long b, Long c, long r) {
        if (r*a == b && r*b == c)
            return true;
        return false;
    }
   
    // cubic time = O(n^3)
    static long countTriplets(List<Long> arr, long r) {
        int arrSize = arr.size();
        long count = 0;
        for (int i = 0; i < arrSize; i++) {
            for (int j = i + 1; j < arrSize; j++) {
                for (int k = j + 1; k < arrSize; k++) {
                    if ( isGeometricProgression(arr.get(i), arr.get(j), arr.get(k), r) ) {
                        // System.out.print("[" + arr.get(i) + "," + arr.get(j) + "," + arr.get(k) + "]");
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // ------------------------------------
    // O(n+n): Idea is to find triplet condition and add to answer.
    static long countTriplets_v2(List<Long> arr, long r) {
        Map<Long, Long> left = new HashMap<>();
        Map<Long, Long> right = new HashMap<>();

        for (Long a : arr) {
            right.put(a, right.getOrDefault(a, 0L) + 1L);
        }

        Long ans = 0L;
        for (int i = 0; i < arr.size(); i++) {
            Long num = arr.get(i);
            right.put(num, right.get(num) - 1L);
            if (num % r == 0) {
                ans += left.getOrDefault(num / r, 0L) * right.getOrDefault(num * r, 0L);
            }
            left.put(num, left.getOrDefault(num, 0L) + 1L);
        }
        
        return ans;
    }

    // ------------------------------------
    // O(n): Singlet -> Couplet -> Triplet and then add to answer.
    static long countTriplets_v3(List<Long> arr, long r) {
        Map<Long, Long> t2 = new HashMap<>();
        Map<Long, Long> t3 = new HashMap<>();

        Long result = 0L;
        for (Long a : arr) {
            result += t3.getOrDefault(a, 0L);
            if (t2.containsKey(a)) {
                t3.put(a * r, t3.getOrDefault(a * r, 0L) + t2.getOrDefault(a, 0L));
            }
            t2.put(a * r, t2.getOrDefault(a * r, 0L) + 1);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(nr[0]);
        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                                            .map(Long::parseLong).collect(toList());

        long ans = countTriplets_v3(arr, r);
        System.out.println(ans);

        bufferedReader.close(); 
    }
}
