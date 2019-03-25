/*
 * Copyright (c) 1999, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.toolkit.ctx;

import javax.naming.Name;

/**
  * A class for returning the result of p_parseComponent();
  *
  * @author Rosanna Lee
  */
public class HeadTail {
    private int status;
    private Name head;
    private Name tail;

    public HeadTail(Name head, Name tail) {
        this(head, tail, 0);
    }

    public HeadTail(Name head, Name tail, int status) {
        this.status = status;
        this.head = head;
        this.tail = tail;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Name getHead() {
        return this.head;
    }

    public Name getTail() {
        return this.tail;
    }

    public int getStatus() {
        return this.status;
    }
}
