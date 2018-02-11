/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

import java.util.Arrays;

class RunnableQueue {

    private Runnable[] queue = new Runnable[32];
    private int start;
    private int count;

    private int modulo(int index) {
        if (index >= queue.length) {
            index -= queue.length;
        }
        return index;
    }

    synchronized void postRunnable(Runnable r) {
        if (count == queue.length) {
            Runnable[] newQueue = new Runnable[(queue.length * 3) / 2];
            System.arraycopy(queue, start, newQueue, 0, queue.length - start);
            System.arraycopy(queue, 0, newQueue, queue.length - start, start);
            queue = newQueue;
            start = 0;
        }
        queue[modulo(start + count)] = r;
        count ++;
        notifyAll();
    }

    synchronized Runnable getNextRunnable() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        Runnable r = queue[start];
        queue[start] = null;
        start = modulo(start + 1);
        count --;
        return r;
    }

    synchronized void clear() {
        Arrays.fill(queue, null);
        count = 0;
    }

}
