package com.sld.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sld
 * <p>
 * leetcode 225
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class ImplementStackUsingQueues {

    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());  // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false

    }

    static class MyStack {

        Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.offer(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.offer(queue.remove());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
