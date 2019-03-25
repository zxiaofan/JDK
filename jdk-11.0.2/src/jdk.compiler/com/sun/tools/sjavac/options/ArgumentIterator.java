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

package com.sun.tools.sjavac.options;

import java.util.Iterator;

/**
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class ArgumentIterator implements Iterator<String> {

    /** The underlying argument iterator */
    private Iterator<String> iter;

    /** Extra state used to implement peek and current */
    private String current;
    private String buffered;

    public ArgumentIterator(Iterable<String> iter) {
        this.iter = iter.iterator();
    }

    @Override
    public boolean hasNext() {
        return buffered != null || iter.hasNext();
    }

    @Override
    public String next() {
        fillBuffer();
        current = buffered;
        buffered = null;
        return current;
    }

    /**
     * @return the last element returned by next() (or {@code null} if next has
     * never been invoked on this iterator).
     */
    public String current() {
        return current;
    }

    /** Can't remove current element, since we may have buffered it. */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /**
     * @return Returns the next element without advancing the iterator
     */
    public String peek() {
        fillBuffer();
        return buffered;
    }

    private void fillBuffer() {
        if (buffered == null && iter.hasNext())
            buffered = iter.next();
    }

}
