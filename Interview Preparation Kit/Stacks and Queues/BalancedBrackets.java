import java.io.*;
import java.util.*;

public class BalancedBrackets {

    private static final Scanner scanner = new Scanner(System.in);

    private static Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if ( !st.isEmpty()  && ch.equals( map.get(st.peek()) ) ) {
                // System.out.println( "Pop : " + st.pop() );
                st.pop();
            } else {
                // System.out.println( "Push : " + ch );
                st.push(ch);
            }
        }

        if (st.isEmpty())
            return "YES";
        else 
            return "NO";
    }

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int it = 0; it < t; it++) {
            String s = scanner.nextLine();
            String result = isBalanced(s);
            System.out.println(result);
        }

        scanner.close();
    }
}
