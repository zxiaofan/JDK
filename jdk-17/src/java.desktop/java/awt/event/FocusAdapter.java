/*
 * Copyright (c) 1996, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.event;

/**
 * An abstract adapter class for receiving keyboard focus events.
 * The methods in this class are empty. This class exists as
 * convenience for creating listener objects.
 * <P>
 * Extend this class to create a {@code FocusEvent} listener
 * and override the methods for the events of interest. (If you implement the
 * {@code FocusListener} interface, you have to define all of
 * the methods in it. This abstract class defines null methods for them
 * all, so you can only have to define methods for events you care about.)
 * <P>
 * Create a listener object using the extended class and then register it with
 * a component using the component's {@code addFocusListener}
 * method. When the component gains or loses the keyboard focus,
 * the relevant method in the listener object is invoked,
 * and the {@code FocusEvent} is passed to it.
 *
 * @see FocusEvent
 * @see FocusListener
 * @see <a href="https://docs.oracle.com/javase/tutorial/uiswing/events/focuslistener.html">Tutorial: Writing a Focus Listener</a>
 *
 * @author Carl Quinn
 * @since 1.1
 */
public abstract class FocusAdapter implements FocusListener {

    /**
     * Constructs a {@code FocusAdapter}.
     */
    protected FocusAdapter() {}

    /**
     * Invoked when a component gains the keyboard focus.
     */
    public void focusGained(FocusEvent e) {}

    /**
     * Invoked when a component loses the keyboard focus.
     */
    public void focusLost(FocusEvent e) {}
}
