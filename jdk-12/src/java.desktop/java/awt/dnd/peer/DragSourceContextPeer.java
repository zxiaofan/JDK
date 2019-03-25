/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.dnd.peer;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.InvalidDnDOperationException;


/**
 * <p>
 * This interface is supplied by the underlying window system platform to
 * expose the behaviors of the Drag and Drop system to an originator of
 * the same
 * </p>
 *
 * @since 1.2
 *
 */

public interface DragSourceContextPeer {

    /**
     * start a drag
     * @param dsc the DragSourceContext
     * @param c the cursor
     * @param dragImage the image to be dragged
     * @param imageOffset the offset
     */

    void startDrag(DragSourceContext dsc, Cursor c, Image dragImage, Point imageOffset) throws InvalidDnDOperationException;

    /**
     * return the current drag cursor
     * @return the current drag cursor
     */

    Cursor getCursor();

    /**
     * set the current drag cursor
     * @param c the cursor
     */

    void setCursor(Cursor c) throws InvalidDnDOperationException;

    /**
     * notify the peer that the Transferables DataFlavors have changed
     */

    void transferablesFlavorsChanged();
}
