// First solution: Simple working but terminated due to timeout.
// Second solution: Reduce the time complexity of Pop to O(1)

import java.io.*;
import java.util.*;

public class QueuesTaleOfTwoStacks {

    static class MyQueue<T> {
        private Stack<T> s1 = new Stack<T>();
        private Stack<T> s2 = new Stack<T>();

        public void enqueue(T val) {
            s1.push(val);
        }

        public void dequeue() {
            if (s2.empty()) {
                while(!s1.empty()) {
                    s2.push(s1.pop());
                }
                s2.pop();
            } else {
                s2.pop();
            }
        }

        public T peek() {
            if (s2.empty()) {
                while(!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }
    }

    public static void main(String[] args) throws IOException {

        MyQueue<Integer> queue = new MyQueue<Integer>();
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { //enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { //dequeue
                queue.dequeue();
            } else if (operation == 3) {
                System.out.println(queue.peek());
            }
        }
    }
}
