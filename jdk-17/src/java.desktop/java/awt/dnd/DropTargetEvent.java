/*
 * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.dnd;

import java.io.Serial;

/**
 * The {@code DropTargetEvent} is the base
 * class for both the {@code DropTargetDragEvent}
 * and the {@code DropTargetDropEvent}.
 * It encapsulates the current state of the Drag and
 * Drop operations, in particular the current
 * {@code DropTargetContext}.
 *
 * @since 1.2
 *
 */

public class DropTargetEvent extends java.util.EventObject {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 2821229066521922993L;

    /**
     * Construct a {@code DropTargetEvent} object with
     * the specified {@code DropTargetContext}.
     *
     * @param dtc The {@code DropTargetContext}
     * @throws NullPointerException if {@code dtc} equals {@code null}.
     * @see #getSource()
     * @see #getDropTargetContext()
     */

    public DropTargetEvent(DropTargetContext dtc) {
        super(dtc.getDropTarget());

        context  = dtc;
    }

    /**
     * This method returns the {@code DropTargetContext}
     * associated with this {@code DropTargetEvent}.
     *
     * @return the {@code DropTargetContext}
     */

    public DropTargetContext getDropTargetContext() {
        return context;
    }

    /**
     * The {@code DropTargetContext} associated with this
     * {@code DropTargetEvent}.
     *
     * @serial
     */
    protected DropTargetContext   context;
}
