/*
 * Copyright (c) 1995, 2015, Oracle and/or its affiliates. All rights reserved.
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
package java.awt;

/**
 * The super class of all menu related containers.
 *
 * @author      Arthur van Hoff
 */

public interface MenuContainer {

    /**
     * Returns the font in use by this container.
     *
     * @return the menu font
     */
    Font getFont();

    /**
     * Removes the specified menu component from the menu.
     *
     * @param  comp the menu component to remove
     */
    void remove(MenuComponent comp);

    /**
     * Posts an event to the listeners.
     *
     * @param  evt the event to dispatch
     * @return the results of posting the event
     * @deprecated As of JDK version 1.1
     * replaced by dispatchEvent(AWTEvent).
     */
    @Deprecated
    boolean postEvent(Event evt);
}
