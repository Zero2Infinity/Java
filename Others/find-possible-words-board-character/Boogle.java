import java.lang.*;
import java.io.*;

/*
Boogle Game:
Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. 
Find all possible words that can be formed by a sequence of adjacent characters. 
Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.

Example:

Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       boggle[][]   = {{'G', 'I', 'Z'},
                       {'U', 'E', 'K'},
                       {'Q', 'S', 'E'}};
      isWord(str): returns true if str is present in dictionary else false.

       Output:  Following words of dictionary are present
                GEEKS
                QUIZ

*/                            
public class Boogle {

    static final String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };
    static final int n = dictionary.length;
    static final int M = 3, N = 3;

    static boolean isWord(String w) {
        for (String word : dictionary) {
            if (word.equals(w)) return true;
        }
        return false;
    }

    static void findWordsUtil(char[][] grid, boolean[][] visited, int row, int col, String str) {
        visited[row][col] = true;                       // first mark as visited
        str += grid[row][col];                          // append char to str
        System.out.println(str);
        if (isWord(str)) 
            System.out.println(str);

        // traverse 8 grid direction; keep edges into mind; never revisited cell for that word
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r >=0 && r < M && c >= 0 && c < N && !visited[r][c])
                    findWordsUtil(grid, visited, r, c, str);
            }
        }

        // need to do something...not sure yet?
        System.out.println("-----");
        str = "" + str.charAt(str.length() - 1);
        // str = str.substring(0, str.length()-1);
        visited[row][col] = false;
    }

    static void findWords(char[][] grid) {
        boolean[][] visited = new boolean[M][N];
        String str = "";

        // Brute force approach: grid[i][j] as current position then build words using findWordsUtil()
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                findWordsUtil(grid, visited, row, col, str);
            }
        }
    }

    public static void main(String[] args) {
        char grid[][] = { {'G','I', 'Z'},
                          {'U', 'E', 'K'},
                          {'Q', 'S', 'E'} };

        // Entry point
        findWords(grid);
    }

}
