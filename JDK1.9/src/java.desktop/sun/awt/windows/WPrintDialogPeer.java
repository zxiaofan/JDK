/*
 * Copyright (c) 1999, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.*;
import java.awt.event.FocusEvent.Cause;
import java.awt.peer.DialogPeer;
import java.awt.peer.ComponentPeer;
import java.awt.dnd.DropTarget;
import java.util.Vector;
import sun.awt.AWTAccessor;

class WPrintDialogPeer extends WWindowPeer implements DialogPeer {

    static {
        initIDs();
    }

    private WComponentPeer parent;

    private Vector<WWindowPeer> blockedWindows = new Vector<>();

    WPrintDialogPeer(WPrintDialog target) {
        super(target);
    }

    @Override
    void create(WComponentPeer parent) {
        this.parent = parent;
    }

    // fix for CR 6178323:
    // don't use checkCreation() from WComponentPeer to avoid hwnd check
    @Override
    protected void checkCreation() {
    }

    @Override
    protected void disposeImpl() {
        WToolkit.targetDisposedPeer(target, this);
    }

    private native boolean _show();

    @Override
    public void show() {
        Runnable runnable = () -> {
            try {
                ((WPrintDialog)target).setRetVal(_show());
            } catch (Exception e) {
                // No exception should be thrown by native dialog code,
                // but if it is we need to trap it so the thread does
                // not hide is called and the thread doesn't hang.
            }
            ((WPrintDialog)target).setVisible(false);
        };
        new Thread(null, runnable, "PrintDialog", 0, false).start();
    }

    synchronized void setHWnd(long hwnd) {
        this.hwnd = hwnd;
        for (WWindowPeer window : blockedWindows) {
            if (hwnd != 0) {
                window.modalDisable((Dialog)target, hwnd);
            } else {
                window.modalEnable((Dialog)target);
            }
        }
    }

    synchronized void blockWindow(WWindowPeer window) {
        blockedWindows.add(window);
        if (hwnd != 0) {
            window.modalDisable((Dialog)target, hwnd);
        }
    }
    synchronized void unblockWindow(WWindowPeer window) {
        blockedWindows.remove(window);
        if (hwnd != 0) {
            window.modalEnable((Dialog)target);
        }
    }

    @Override
    public void blockWindows(java.util.List<Window> toBlock) {
        for (Window w : toBlock) {
            WWindowPeer wp = AWTAccessor.getComponentAccessor().getPeer(w);
            if (wp != null) {
                blockWindow(wp);
            }
        }
    }

    @Override
    public native void toFront();
    @Override
    public native void toBack();

    // unused methods.  Overridden to disable this functionality as
    // it requires HWND which is not available for FileDialog
    @Override
    void initialize() {}
    @Override
    public void updateAlwaysOnTopState() {}
    @Override
    public void setResizable(boolean resizable) {}
    @Override
    void hide() {}
    @Override
    void enable() {}
    @Override
    void disable() {}
    @Override
    public void reshape(int x, int y, int width, int height) {}
    @SuppressWarnings("deprecation")
    public boolean handleEvent(Event e) { return false; }
    @Override
    public void setForeground(Color c) {}
    @Override
    public void setBackground(Color c) {}
    @Override
    public void setFont(Font f) {}
    @Override
    public void updateMinimumSize() {}
    @Override
    public void updateIconImages() {}
    public boolean requestFocus(boolean temporary, boolean focusedWindowChangeAllowed) {
        return false;
    }

    @Override
    public boolean requestFocus
         (Component lightweightChild, boolean temporary,
          boolean focusedWindowChangeAllowed, long time, Cause cause)
    {

        return false;
    }

    @Override
    public void updateFocusableWindowState() {}
    @Override
    void start() {}
    @Override
    public void beginValidate() {}
    @Override
    public void endValidate() {}
    void invalidate(int x, int y, int width, int height) {}
    @Override
    public void addDropTarget(DropTarget dt) {}
    @Override
    public void removeDropTarget(DropTarget dt) {}
    @Override
    public void setZOrder(ComponentPeer above) {}

    /**
     * Initialize JNI field and method ids
     */
    private static native void initIDs();

    // The effects are not supported for system dialogs.
    @Override
    public void applyShape(sun.java2d.pipe.Region shape) {}
    @Override
    public void setOpacity(float opacity) {}
    @Override
    public void setOpaque(boolean isOpaque) {}
    public void updateWindow(java.awt.image.BufferedImage backBuffer) {}

    // the file/print dialogs are native dialogs and
    // the native system does their own rendering
    @Override
    public void createScreenSurface(boolean isResize) {}
    @Override
    public void replaceSurfaceData() {}
}
