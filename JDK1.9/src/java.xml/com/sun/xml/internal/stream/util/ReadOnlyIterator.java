/*
 * Copyright (c) 2005, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream.util;
/**
 *
 * @author K.Venugopal ,Neeraj Bajaj Sun Microsystems.
 */

import java.util.Iterator;

public class ReadOnlyIterator<T> implements Iterator<T> {

    Iterator<T> iterator = null;

    public ReadOnlyIterator(){
    }

    public ReadOnlyIterator(Iterator<T> itr){
        iterator = itr;
    }

    @Override
    public boolean hasNext() {
        if(iterator  != null)
            return iterator.hasNext();
        return false;
    }

    @Override
    public T next() {
        if(iterator  != null)
            return iterator.next();
        return null;
    }

    @Override
    public void remove() {
        throw new  UnsupportedOperationException("Remove operation is not supported");
    }

}
