/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package javax.swing.event;

import java.util.EventObject;


/**
 * CaretEvent is used to notify interested parties that 
 * the text caret has changed in the event source.
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases. The current serialization support is
 * appropriate for short term storage or RMI between applications running
 * the same version of Swing.  As of 1.4, support for long term storage
 * of all JavaBeans<sup><font size="-2">TM</font></sup>
 * has been added to the <code>java.beans</code> package.
 * Please see {@link java.beans.XMLEncoder}.
 *
 * @version %I% %G%
 * @author  Timothy Prinzing
 */
public abstract class CaretEvent extends EventObject {

    /**
     * Creates a new CaretEvent object.
     *
     * @param source the object responsible for the event
     */
    public CaretEvent(Object source) {
        super(source);
    }

    /**
     * Fetches the location of the caret.
     *
     * @return the dot >= 0
     */
    public abstract int getDot();

    /**
     * Fetches the location of other end of a logical
     * selection.  If there is no selection, this
     * will be the same as dot.
     *
     * @return the mark >= 0
     */
    public abstract int getMark();
}

