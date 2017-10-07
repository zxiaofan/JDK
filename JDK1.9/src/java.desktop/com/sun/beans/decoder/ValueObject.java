/*
 * Copyright (c) 2008, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.beans.decoder;

/**
 * This interface represents the result of method execution.
 *
 * @since 1.7
 *
 * @author Sergey A. Malenkov
 */
public interface ValueObject {

    /**
     * Returns the result of method execution.
     *
     * @return the result of method execution
     */
    Object getValue();

    /**
     * Returns {@code void} state of this value object.
     *
     * @return {@code true} if value can be ignored,
     *         {@code false} otherwise
     */
    boolean isVoid();
}
