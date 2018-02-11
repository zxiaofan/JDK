/*
 * Copyright (c) 1998, 1999, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Insets;
import java.awt.Point;

/**
 * During DnD operations it is possible that a user may wish to drop the
 * subject of the operation on a region of a scrollable GUI control that is
 * not currently visible to the user.
 * <p>
 * In such situations it is desirable that the GUI control detect this
 * and institute a scroll operation in order to make obscured region(s)
 * visible to the user. This feature is known as autoscrolling.
 * <p>
 * If a GUI control is both an active {@code DropTarget}
 * and is also scrollable, it
 * can receive notifications of autoscrolling gestures by the user from
 * the DnD system by implementing this interface.
 * <p>
 * An autoscrolling gesture is initiated by the user by keeping the drag
 * cursor motionless with a border region of the {@code Component},
 * referred to as
 * the "autoscrolling region", for a predefined period of time, this will
 * result in repeated scroll requests to the {@code Component}
 * until the drag {@code Cursor} resumes its motion.
 *
 * @since 1.2
 */

public interface Autoscroll {

    /**
     * This method returns the {@code Insets} describing
     * the autoscrolling region or border relative
     * to the geometry of the implementing Component.
     * <P>
     * This value is read once by the {@code DropTarget}
     * upon entry of the drag {@code Cursor}
     * into the associated {@code Component}.
     *
     * @return the Insets
     */

    public Insets getAutoscrollInsets();

    /**
     * notify the {@code Component} to autoscroll
     *
     * @param cursorLocn A {@code Point} indicating the
     * location of the cursor that triggered this operation.
     */

    public void autoscroll(Point cursorLocn);

}
