/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.jmx;

/**
 * Context used together with {@link MXNodeAlgorithm} for obtaining the Scene-graph
 * structure.
 */
public class MXNodeAlgorithmContext {

    private int counter;

    /**
     * Creates new instance of the context with the node counter initialized to zero.
     */
    public MXNodeAlgorithmContext() {
        this(0);
    }

    /**
     * Creates new instance of the context with the node counter initialized
     * to <code>initCounterValue</code>.
     *
     * @param initCounterValue initial value for node identifiers
     */
    public MXNodeAlgorithmContext(int initCounterValue) {
        counter = initCounterValue;
    }

    /**
     * Returns next number identifier. Numbers returned by this method are used
     * as node's identifiers.
     *
     * @return the next identifier
     */
    public int getNextInt() {
        return ++counter;
    }

}
