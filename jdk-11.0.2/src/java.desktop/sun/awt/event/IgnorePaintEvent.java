/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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
package sun.awt.event;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.PaintEvent;

/**
 * PaintEvents that are effectively ignored.  This class is used only for
 * tagging.  If a heavy weight peer is asked to handle an event of this
 * class it'll ignore it.  This class is used by Swing.
 * Look at {@code javax.swing.SwingPaintEventDispatcher} for more.
 *
 */
@SuppressWarnings("serial") // JDK-implementation class
public class IgnorePaintEvent extends PaintEvent {
    public IgnorePaintEvent(Component source, int id, Rectangle updateRect) {
        super(source, id, updateRect);
    }
}
