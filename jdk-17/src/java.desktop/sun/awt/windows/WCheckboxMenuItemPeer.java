/*
 * Copyright (c) 1996, 2014, Oracle and/or its affiliates. All rights reserved.
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
package sun.awt.windows;

import java.awt.CheckboxMenuItem;
import java.awt.event.ItemEvent;
import java.awt.peer.CheckboxMenuItemPeer;

final class WCheckboxMenuItemPeer extends WMenuItemPeer
        implements CheckboxMenuItemPeer {

    // CheckboxMenuItemPeer implementation

    @Override
    public native void setState(boolean t);

    // Toolkit & peer internals

    WCheckboxMenuItemPeer(CheckboxMenuItem target) {
        super(target, true);
        setState(target.getState());
    }

    // native callbacks

    public void handleAction(final boolean state) {
        final CheckboxMenuItem target = (CheckboxMenuItem)this.target;
        WToolkit.executeOnEventHandlerThread(target, new Runnable() {
            @Override
            public void run() {
                target.setState(state);
                postEvent(new ItemEvent(target, ItemEvent.ITEM_STATE_CHANGED,
                                        target.getLabel(), (state)
                                          ? ItemEvent.SELECTED
                                          : ItemEvent.DESELECTED));
            }
        });
    }
}
