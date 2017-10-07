/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.geom;

import java.util.Deque;
import java.util.LinkedList;

public final class DirtyRegionPool {

    private class PoolItem {

        DirtyRegionContainer container;
        long timeStamp;

        public PoolItem(DirtyRegionContainer container, long timeStamp) {
            this.container = container;
            this.timeStamp = timeStamp;
        }
    }
    private static final int POOL_SIZE_MIN = 4;
    private static final int EXPIRATION_TIME = 3000;
    private static final int COUNT_BETWEEN_EXPIRATION_CHECK = 30 * EXPIRATION_TIME / 1000;
    private final int containerSize;
    private int clearCounter = COUNT_BETWEEN_EXPIRATION_CHECK;
    private final Deque<DirtyRegionContainer> fixed;
    private final Deque<PoolItem> unlocked;
    private final Deque<PoolItem> locked;

    public DirtyRegionPool(int containerSize) {
        this.containerSize = containerSize;
        fixed = new LinkedList<DirtyRegionContainer>();
        unlocked = new LinkedList<PoolItem>();
        locked = new LinkedList<PoolItem>();
        for (int i = 0; i < POOL_SIZE_MIN; ++i) {
            fixed.add(new DirtyRegionContainer(containerSize));
        }
    }

    public DirtyRegionContainer checkOut() {
        clearExpired();
        if (!fixed.isEmpty()) {
            return fixed.pop();
        }
        if (!unlocked.isEmpty()) {
            PoolItem item = unlocked.pop();
            locked.push(item);
            return item.container;
        }
        DirtyRegionContainer c = new DirtyRegionContainer(containerSize);
        locked.push(new PoolItem(null, -1));
        return c;
    }

    public void checkIn(DirtyRegionContainer drc) {
        drc.reset();
        if (locked.isEmpty()) {
            fixed.push(drc);
        } else {
            PoolItem item = locked.pop();
            item.container = drc;
            item.timeStamp = System.currentTimeMillis();
            unlocked.push(item);
        }
    }

    private void clearExpired() {
        if (unlocked.isEmpty()) {
            return;
        }
        if (clearCounter-- == 0) {
            clearCounter = COUNT_BETWEEN_EXPIRATION_CHECK;
            PoolItem i = unlocked.peekLast();
            long now = System.currentTimeMillis();
            while (i != null && i.timeStamp + EXPIRATION_TIME < now) {
                unlocked.removeLast();
                i = unlocked.peekLast();
            }
        }
    }
}
