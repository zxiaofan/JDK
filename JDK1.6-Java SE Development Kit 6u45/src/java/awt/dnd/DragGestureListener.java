/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */



package java.awt.dnd;

import java.util.EventListener;

/**
 * This interface is sourced from a <code>DragGestureRecognizer</code> 
 * and is invoked
 * when an object of that (sub)class detects a drag initiating
 * gesture.
 * <p>
 * The implementor of this interface is responsible for starting the drag
 * as a result of receiving such notification.
 *
 * @see java.awt.dnd.DragGestureRecognizer
 * @see java.awt.dnd.DragGestureEvent
 * @see java.awt.dnd.DragSource
 */

 public interface DragGestureListener extends EventListener {

    /**
     * A <code>DragGestureRecognizer</code> has detected 
     * a platform-dependent drag initiating gesture and 
     * is notifying this listener
     * in order for it to initiate the action for the user.
     * <P>
     * @param dge the <code>DragGestureEvent</code> describing 
     * the gesture that has just occurred
     */

     void dragGestureRecognized(DragGestureEvent dge);
}
