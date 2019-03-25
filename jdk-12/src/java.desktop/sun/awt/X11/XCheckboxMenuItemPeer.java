/*
 * Copyright (c) 2003, 2016, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.X11;

import java.awt.*;
import java.awt.peer.*;
import java.awt.event.*;

import sun.awt.AWTAccessor;

final class XCheckboxMenuItemPeer extends XMenuItemPeer
        implements CheckboxMenuItemPeer {

    /************************************************
     *
     * Construction
     *
     ************************************************/
    XCheckboxMenuItemPeer(CheckboxMenuItem target) {
        super(target);
    }

    /************************************************
     *
     * Implementaion of interface methods
     *
     ************************************************/

    //Prom CheckboxMenuItemtPeer
    @Override
    public void setState(boolean t) {
        repaintIfShowing();
    }

    /************************************************
     *
     * Access to target's fields
     *
     ************************************************/
    boolean getTargetState() {
        return AWTAccessor.getCheckboxMenuItemAccessor()
                   .getState((CheckboxMenuItem)getTarget());
    }

    /************************************************
     *
     * Utility functions
     *
     ************************************************/

    /**
     * Toggles state and generates ItemEvent
     */
    @Override
    void action(long when, int modifiers) {
        XToolkit.executeOnEventHandlerThread((CheckboxMenuItem)getTarget(), new Runnable() {
                @Override
                public void run() {
                    doToggleState(when);
                }
            });
    }


    /************************************************
     *
     * Private
     *
     ************************************************/
    private void doToggleState(long when) {
        CheckboxMenuItem cb = (CheckboxMenuItem)getTarget();
        boolean newState = !getTargetState();
        cb.setState(newState);
        ItemEvent e = new ItemEvent(cb,
                                    ItemEvent.ITEM_STATE_CHANGED,
                                    getTargetLabel(),
                                    getTargetState() ? ItemEvent.SELECTED : ItemEvent.DESELECTED);
        XWindow.postEventStatic(e);
        //WToolkit does not post ActionEvent when clicking on menu item
        //MToolkit _does_ post.
        //Fix for 5005195 MAWT: CheckboxMenuItem fires action events
        //Events should not be fired
        //XWindow.postEventStatic(new ActionEvent(cb, ActionEvent.ACTION_PERFORMED,
        //                                        getTargetActionCommand(), when,
        //                                        0));
    }

} // class XCheckboxMenuItemPeer
