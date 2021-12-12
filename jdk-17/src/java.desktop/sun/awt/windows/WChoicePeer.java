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

package sun.awt.windows;

import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.peer.ChoicePeer;

import sun.awt.AWTAccessor;
import sun.awt.SunToolkit;

final class WChoicePeer extends WComponentPeer implements ChoicePeer {

    // WComponentPeer overrides

    @Override
    public Dimension getMinimumSize() {
        FontMetrics fm = getFontMetrics(((Choice)target).getFont());
        Choice c = (Choice)target;
        int w = 0;
        for (int i = c.getItemCount() ; i-- > 0 ;) {
            w = Math.max(fm.stringWidth(c.getItem(i)), w);
        }
        return new Dimension(28 + w, Math.max(fm.getHeight() + 6, 15));
    }
    @Override
    public boolean isFocusable() {
        return true;
    }

    // ChoicePeer implementation

    @Override
    public native void select(int index);

    @Override
    public void add(String item, int index) {
        addItems(new String[] {item}, index);
    }

    @Override
    public boolean shouldClearRectBeforePaint() {
        return false;
    }

    @Override
    public native void removeAll();
    @Override
    public native void remove(int index);

    public native void addItems(String[] items, int index);

    @Override
    public synchronized native void reshape(int x, int y, int width, int height);

    private WindowListener windowListener;

    // Toolkit & peer internals

    WChoicePeer(Choice target) {
        super(target);
    }

    @Override
    native void create(WComponentPeer parent);

    @Override
    void initialize() {
        Choice opt = (Choice)target;
        int itemCount = opt.getItemCount();
        if (itemCount > 0) {
            String[] items = new String[itemCount];
            for (int i=0; i < itemCount; i++) {
                items[i] = opt.getItem(i);
            }
            addItems(items, 0);
            if (opt.getSelectedIndex() >= 0) {
                select(opt.getSelectedIndex());
            }
        }

        Window parentWindow = SunToolkit.getContainingWindow((Component)target);
        if (parentWindow != null) {
            final WWindowPeer wpeer = AWTAccessor.getComponentAccessor()
                                                 .getPeer(parentWindow);
            if (wpeer != null) {
                windowListener = new WindowAdapter() {
                        @Override
                        public void windowIconified(WindowEvent e) {
                            closeList();
                        }
                        @Override
                        public void windowClosing(WindowEvent e) {
                            closeList();
                        }
                    };
                wpeer.addWindowListener(windowListener);
            }
        }
        super.initialize();
    }

    @Override
    protected void disposeImpl() {
        // TODO: we should somehow reset the listener when the choice
        // is moved to another toplevel without destroying its peer.
        Window parentWindow = SunToolkit.getContainingWindow((Component)target);
        if (parentWindow != null) {
            final WWindowPeer wpeer = AWTAccessor.getComponentAccessor()
                                                .getPeer(parentWindow);
            if (wpeer != null) {
                wpeer.removeWindowListener(windowListener);
            }
        }
        super.disposeImpl();
    }

    // native callbacks

    void handleAction(final int index) {
        final Choice c = (Choice)target;
        WToolkit.executeOnEventHandlerThread(c, new Runnable() {
            @Override
            public void run() {
                c.select(index);
                postEvent(new ItemEvent(c, ItemEvent.ITEM_STATE_CHANGED,
                                c.getItem(index), ItemEvent.SELECTED));
            }
        });
    }

    native void closeList();
}
