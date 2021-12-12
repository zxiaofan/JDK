/*
 * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
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

package javax.print.event;

import java.io.Serial;

/**
 * Class {@code PrintEvent} is the super class of all Print Service API events.
 */
public class PrintEvent extends java.util.EventObject {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 2286914924430763847L;

    /**
     * Constructs a {@code PrintEvent} object.
     *
     * @param  source is the source of the event
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public PrintEvent (Object source) {
        super(source);
    }

    /**
     * Returns a string representation of this {@code PrintEvent}.
     *
     * @return a message describing the event
     */
    public String toString() {
        return ("PrintEvent on " + getSource().toString());
    }
}
