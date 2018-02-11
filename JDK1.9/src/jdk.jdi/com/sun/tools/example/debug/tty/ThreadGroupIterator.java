/*
 * Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved.
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

/*
 * This source code is provided to illustrate the usage of a given feature
 * or technique and has been deliberately simplified. Additional steps
 * required for a production-quality application, such as security checks,
 * input validation and proper error handling, might not be present in
 * this sample code.
 */


package com.sun.tools.example.debug.tty;

import com.sun.jdi.ThreadGroupReference;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Descend the tree of thread groups.
 * @author Robert G. Field
 */
class ThreadGroupIterator implements Iterator<ThreadGroupReference> {
    private final Stack<Iterator<ThreadGroupReference>> stack = new Stack<Iterator<ThreadGroupReference>>();

    ThreadGroupIterator(List<ThreadGroupReference> tgl) {
        push(tgl);
    }

    ThreadGroupIterator(ThreadGroupReference tg) {
        List<ThreadGroupReference> tgl = new ArrayList<ThreadGroupReference>();
        tgl.add(tg);
        push(tgl);
    }

    ThreadGroupIterator() {
        this(Env.vm().topLevelThreadGroups());
    }

    private Iterator<ThreadGroupReference> top() {
        return stack.peek();
    }

    /**
     * The invariant in this class is that the top iterator
     * on the stack has more elements.  If the stack is
     * empty, there is no top.  This method assures
     * this invariant.
     */
    private void push(List<ThreadGroupReference> tgl) {
        stack.push(tgl.iterator());
        while (!stack.isEmpty() && !top().hasNext()) {
            stack.pop();
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public ThreadGroupReference next() {
        return nextThreadGroup();
    }

    public ThreadGroupReference nextThreadGroup() {
        ThreadGroupReference tg = top().next();
        push(tg.threadGroups());
        return tg;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    static ThreadGroupReference find(String name) {
        ThreadGroupIterator tgi = new ThreadGroupIterator();
        while (tgi.hasNext()) {
            ThreadGroupReference tg = tgi.nextThreadGroup();
            if (tg.name().equals(name)) {
                return tg;
            }
        }
        return null;
    }

}
