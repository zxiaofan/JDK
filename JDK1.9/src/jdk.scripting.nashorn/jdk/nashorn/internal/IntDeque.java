/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package jdk.nashorn.internal;

/**
 * Small helper class for fast int deques
 */
public class IntDeque {
    private int[] deque = new int[16];
    private int nextFree = 0;

    /**
     * Push an int value
     * @param value value
     */
    public void push(final int value) {
        if (nextFree == deque.length) {
            final int[] newDeque = new int[nextFree * 2];
            System.arraycopy(deque, 0, newDeque, 0, nextFree);
            deque = newDeque;
        }
        deque[nextFree++] = value;
    }

    /**
     * Pop an int value
     * @return value
     */
    public int pop() {
        return deque[--nextFree];
    }

    /**
     * Peek
     * @return top value
     */
    public int peek() {
        return deque[nextFree - 1];
    }

    /**
     * Get the value of the top element and increment it.
     * @return top value
     */
    public int getAndIncrement() {
        return deque[nextFree - 1]++;
    }

    /**
     * Decrement the value of the top element and return it.
     * @return decremented top value
     */
    public int decrementAndGet() {
        return --deque[nextFree - 1];
    }

    /**
     * Check if deque is empty
     * @return true if empty
     */
    public boolean isEmpty() {
        return nextFree == 0;
    }
}
