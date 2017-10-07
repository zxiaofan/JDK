/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/**
 * This is a helper class for handling weak references across all devices.
 * We tried to use WeakHashMap, but it isn't available on mobile. We tried to
 * add it to mobile, but it requires ReferenceQueue and it appears that
 * ReferenceQueue requires support from the VM which we don't know that we
 * have on mobile. So this class attempts to lesson the likelyhood of
 * memory leaks.
 *
 * As we abandoned mobile, we considered removal of this class. But replacement
 * by WeakHashMap is not always possible as we use mutable elements. At least
 * it was now possible to optimize this class using the ReferenceQueue.
 */
public class WeakReferenceQueue<E> {
    /**
     * Reference queue for cleared weak references
     */
    private final ReferenceQueue garbage = new ReferenceQueue();

    /**
     * Strongly referenced list head
     */
    private Object strongRef = new Object();
    private ListEntry head = new ListEntry(strongRef, garbage);

    /**
     * Size of the queue
     */
    int size = 0;

    @SuppressWarnings("unchecked")
    public void add(E obj) {
        cleanup();
        size++;
        new ListEntry(obj, garbage).insert(head.prev);
    }

    public void remove(E obj) {
        cleanup();

        ListEntry entry = head.next;
        while (entry != head) {
            Object other = entry.get();
            if (other == obj) {
                size--;
                entry.remove();
                return;
            }
            entry = entry.next;
        }
    }

    public void cleanup() {
        ListEntry entry;
        while ((entry = (ListEntry) garbage.poll()) != null) {
            size--;
            entry.remove();
        }
    }

    public Iterator<? super E> iterator() {
        return new Iterator() {
            private ListEntry index = head;
            private Object next = null;

            public boolean hasNext() {
                next = null;
                while (next == null) {
                    ListEntry nextIndex = index.prev;
                    if (nextIndex == head) {
                        break;
                    }
                    next = nextIndex.get();
                    if (next == null) {
                        size--;
                        nextIndex.remove();
                    }
                }

                return next != null;
            }

            public Object next() {
                hasNext(); // forces us to clear out crap up to the next
                           // valid spot
                index = index.prev;
                return next;
            }

            public void remove() {
                if (index != head) {
                    ListEntry nextIndex = index.next;
                    size--;
                    index.remove();
                    index = nextIndex;
                }
            }
        };
    }

    private static class ListEntry extends WeakReference {
        ListEntry prev, next;

        public ListEntry(Object o, ReferenceQueue queue) {
            super(o, queue);
            prev = this;
            next = this;
        }

        public void insert(ListEntry where) {
            prev = where;
            next = where.next;
            where.next = this;
            next.prev = this;
        }

        public void remove() {
            prev.next = next;
            next.prev = prev;
            next = this;
            prev = this;
        }
    }

}
