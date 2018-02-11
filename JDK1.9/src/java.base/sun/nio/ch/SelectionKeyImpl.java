/*
 * Copyright (c) 2000, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.ch;

import java.io.IOException;
import java.nio.channels.*;
import java.nio.channels.spi.*;


/**
 * An implementation of SelectionKey for Solaris.
 */

public class SelectionKeyImpl
    extends AbstractSelectionKey
{

    final SelChImpl channel;                            // package-private
    public final SelectorImpl selector;

    // Index for a pollfd array in Selector that this key is registered with
    private int index;

    private volatile int interestOps;
    private int readyOps;

    SelectionKeyImpl(SelChImpl ch, SelectorImpl sel) {
        channel = ch;
        selector = sel;
    }

    public SelectableChannel channel() {
        return (SelectableChannel)channel;
    }

    public Selector selector() {
        return selector;
    }

    int getIndex() {                                    // package-private
        return index;
    }

    void setIndex(int i) {                              // package-private
        index = i;
    }

    private void ensureValid() {
        if (!isValid())
            throw new CancelledKeyException();
    }

    public int interestOps() {
        ensureValid();
        return interestOps;
    }

    public SelectionKey interestOps(int ops) {
        ensureValid();
        return nioInterestOps(ops);
    }

    public int readyOps() {
        ensureValid();
        return readyOps;
    }

    // The nio versions of these operations do not care if a key
    // has been invalidated. They are for internal use by nio code.

    public void nioReadyOps(int ops) {
        readyOps = ops;
    }

    public int nioReadyOps() {
        return readyOps;
    }

    public SelectionKey nioInterestOps(int ops) {
        if ((ops & ~channel().validOps()) != 0)
            throw new IllegalArgumentException();
        channel.translateAndSetInterestOps(ops, this);
        interestOps = ops;
        return this;
    }

    public int nioInterestOps() {
        return interestOps;
    }

}
