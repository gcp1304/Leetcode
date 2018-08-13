package com.chandra.problems;

import java.util.Deque;
import java.util.LinkedList;

public class Problem_225 {
    public static class Solution_1 {
        class MyStack {

            Deque<Integer> queue;
            /** Initialize your data structure here. */
            public MyStack() {
                queue = new LinkedList<>();
            }

            /** Push element x onto stack. */
            public void push(int x) {
                queue.push(x);
            }

            /** Removes the element on top of the stack and returns that element. */
            public int pop() {
                return queue.pollFirst();
            }

            /** Get the top element. */
            public int top() {
                return queue.peekFirst();
            }

            /** Returns whether the stack is empty. */
            public boolean empty() {
                return queue.isEmpty();
            }
        }
    }
}
