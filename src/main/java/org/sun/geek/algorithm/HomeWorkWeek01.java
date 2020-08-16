package org.sun.geek.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class HomeWorkWeek01 {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int cur = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[cur]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    ans += (Math.min(height[stackTop], height[i]) - height[cur]) *
                            (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }
}

class MyCircularDeque {
    private Deque<Integer> deque;

    private Integer capacity;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k;
        deque = new ArrayDeque<>(k);
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (deque.size() >= capacity) {
            return false;
        }
        return deque.offerFirst(value);
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (deque.size() >= capacity) {
            return false;
        }
        return deque.offerLast(value);
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (deque.size() == 0) {
            return false;
        }
        return deque.removeFirst() != null;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (deque.size() == 0) {
            return false;
        }
        return deque.removeLast() != null;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (deque.size() == 0) {
            return -1;
        }
        return deque.peekFirst();
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (deque.size() == 0) {
            return -1;
        }
        return deque.peekLast();
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return deque.size() == capacity;
    }
}
