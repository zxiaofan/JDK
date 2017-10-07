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

package com.sun.javafx.beans.event;

import javafx.beans.InvalidationListener;
import javafx.beans.WeakInvalidationListener;

/**
 * A helper base class for notify listeners. It holds reference to its
 * {@code WeakListener} wrapper.
 * <p>
 * Without this class, an observer which uses weak listeners would need to hold
 * two references. The first to the original {@code ChangeListener} to prevent
 * it from being garbage collected. The second to the {@code WeakListener}
 * wrapper so it can unregister once registered listener. The second reference
 * is eliminated by using this class.
 * <p>
 * Example:
<PRE>
public class Observer {
    private AbstractNotifyListener listener = new AbstractNotifyListener() {
        public void handle(Bean bean, PropertyReference property) {
            // do something
        }
    };

    public void start() {
        subject.addChangeListener(property, listener.getWeakListener());
    }

    public void stop() {
        subject.removeChangeListener(property, listener.getWeakListener());
    }
}
</PRE>
 */
public abstract class AbstractNotifyListener implements InvalidationListener {
    private final WeakInvalidationListener weakListener = new WeakInvalidationListener(this);

    public InvalidationListener getWeakListener() {
        return weakListener;
    }
}
