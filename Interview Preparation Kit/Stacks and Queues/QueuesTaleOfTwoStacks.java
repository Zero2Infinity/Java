// First solution: Simple working but terminated due to timeout.

import java.io.*;
import java.util.*;

public class QueuesTaleOfTwoStacks {

    static class MyQueue<T> {
        private Stack<T> stack = new Stack<T>();
        private Stack<T> tmp = new Stack<T>();

        public void enqueue(T val) {
            // enqueue
            if (stack.empty()) {
                stack.push(val);
            } else {
                // dump stack to tmp
                while ( !stack.empty() ) {
                    tmp.push(stack.pop());
                }
                // insert as first element
                stack.push(val);
                // dump tmp to stack
                while( !tmp.empty() ) {
                    stack.push(tmp.pop());
                }
            }
            // System.out.println(stack);
        }

        public void dequeue() {
            // dequeue
            stack.pop();
        }

        public T peek() {
            // peek
            return stack.peek();
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
