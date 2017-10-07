/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.util.xml;

import java.util.Iterator;

import org.w3c.dom.NodeList;

/**
 * @author WS Development Team
 */
public class NodeListIterator implements Iterator {

    protected NodeList _list;
    protected int _index;

    public NodeListIterator(NodeList list) {
        _list = list;
        _index = 0;
    }

    public boolean hasNext() {
        if (_list == null)
            return false;
        return _index < _list.getLength();
    }

    public Object next() {
        Object obj = _list.item(_index);
        if (obj != null)
            ++_index;
        return obj;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
