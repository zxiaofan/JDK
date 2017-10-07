/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader.gbind;

/**
 * Sink node of a grpah.
 * @author Kohsuke Kawaguchi
 */
public final class SinkNode extends Element {
    public String toString() {
        return "#sink";
    }

    @Override
    boolean isSink() {
        return true;
    }
}
