/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset.util;

import com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetException;
import com.sun.xml.internal.fastinfoset.CommonResourceBundle;


public class DuplicateAttributeVerifier {
    public static final int MAP_SIZE = 256;

    public int _currentIteration;

    public static class Entry {
        private int iteration;
        private int value;

        private Entry hashNext;

        private Entry poolNext;
    }

    private Entry[] _map;

    public final Entry _poolHead;
    public Entry _poolCurrent;
    private Entry _poolTail;


    public DuplicateAttributeVerifier() {
        _poolTail = _poolHead = new Entry();
    }

    public final void clear() {
        _currentIteration = 0;

        Entry e = _poolHead;
        while (e != null) {
            e.iteration = 0;
            e = e.poolNext;
        }

        reset();
    }

    public final void reset() {
        _poolCurrent = _poolHead;
        if (_map == null) {
            _map = new Entry[MAP_SIZE];
        }
    }

    private final void increasePool(int capacity) {
        if (_map == null) {
            _map = new Entry[MAP_SIZE];
            _poolCurrent = _poolHead;
        } else {
            final Entry tail = _poolTail;
            for (int i = 0; i < capacity; i++) {
                final Entry e = new Entry();
                _poolTail.poolNext = e;
                _poolTail = e;
            }

            _poolCurrent = tail.poolNext;
        }
    }

    public final void checkForDuplicateAttribute(int hash, int value) throws FastInfosetException {
        if (_poolCurrent == null) {
            increasePool(16);
        }

        // Get next free entry
        final Entry newEntry = _poolCurrent;
        _poolCurrent = _poolCurrent.poolNext;

        final Entry head = _map[hash];
        if (head == null || head.iteration < _currentIteration) {
            newEntry.hashNext = null;
            _map[hash] = newEntry;
            newEntry.iteration = _currentIteration;
            newEntry.value = value;
        } else {
            Entry e = head;
            do {
                if (e.value == value) {
                    reset();
                    throw new FastInfosetException(CommonResourceBundle.getInstance().getString("message.duplicateAttribute"));
                }
            } while ((e = e.hashNext) != null);

            newEntry.hashNext = head;
            _map[hash] = newEntry;
            newEntry.iteration = _currentIteration;
            newEntry.value = value;
        }
    }
}
