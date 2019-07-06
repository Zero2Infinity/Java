import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

    static List<Integer> freqQuery(int[][] queries) {
        Map<Long, Long> ValToFreq = new HashMap<>();
        Map<Long, Long> FreqToOccur = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int row = 0; row < queries.length; row++) {
            Integer action = queries[row][0];
            Long value = Long.valueOf(queries[row][1]);
            if (action == 1) {
                if (ValToFreq.containsKey(value)) {
                    Long count = ValToFreq.get(value);
                    ValToFreq.put(value, ValToFreq.get(value) + 1);
                    Long occur = FreqToOccur.get(count);
                    Long occur2 = FreqToOccur.getOrDefault(count + 1, 0L);
                    FreqToOccur.put(count, occur - 1);
                    FreqToOccur.put(count + 1, occur2 + 1);
                } else  {
                    ValToFreq.put(value, 1L);
                    FreqToOccur.put(1L, FreqToOccur.getOrDefault(1L, 0L) + 1);
                }
            } else if (action == 2) {
                if (!ValToFreq.isEmpty() && ValToFreq.containsKey(value)) {
                    Long count = ValToFreq.get(value);
                    if (count > 1) {
                        ValToFreq.put(value, count - 1);
                        FreqToOccur.put(count, FreqToOccur.get(count) - 1);
                        FreqToOccur.put(count - 1, FreqToOccur.get(count - 1) + 1);
                    } else {
                        ValToFreq.remove(value);
                        FreqToOccur.put(count, FreqToOccur.get(count) - 1);
                    }
                }
            } else {
                if (!FreqToOccur.isEmpty() && FreqToOccur.getOrDefault(value, 0L) > 0L)
                    result.add(1);
                else 
                    result.add(0);
            }
        }
        return result;
    }

     public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                                                new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];
                                   
            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }
            
            List<Integer> ans = freqQuery(queries);
            ans.forEach(System.out::println);
        }
     }
}
