/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.swing.interop;

import java.awt.Component;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.InvalidDnDOperationException;
import java.awt.dnd.peer.DragSourceContextPeer;
import java.awt.dnd.DropTarget;
import javax.swing.JComponent;
import sun.swing.LightweightContent;

/**
 * This class provides a wrapper over inner LightweightContentProxy class
 * which implements jdk internal sun.swing.LightweightContent interface
 * and provides APIs to be used by FX swing interop to access and use
 * LightweightContent APIs.
 *
 * @since 11
 */
public abstract class LightweightContentWrapper {
    private LightweightContentProxy lwCnt;

    public LightweightContentWrapper() {
        lwCnt = new LightweightContentProxy();
    }

    LightweightContentProxy getContent() {
        return lwCnt;
    }

    public abstract void imageBufferReset(int[] data, int x, int y, int width,
                                          int height, int linestride);

    public abstract void imageBufferReset(int[] data, int x, int y, int width,
                                     int height,
                                     int linestride, double scaleX,
                                     double scaleY);

    public abstract JComponent getComponent();

    public abstract void paintLock();

    public abstract void paintUnlock();

    public abstract void imageReshaped(int x, int y, int width, int height);

    public abstract void imageUpdated(int dirtyX, int dirtyY,int dirtyWidth,
                                      int dirtyHeight);

    public abstract void focusGrabbed();

    public abstract void focusUngrabbed();

    public abstract void preferredSizeChanged(int width, int height);

    public abstract void maximumSizeChanged(int width, int height);

    public abstract void minimumSizeChanged(int width, int height);

    public abstract <T extends DragGestureRecognizer> T createDragGestureRecognizer(
            Class<T> abstractRecognizerClass,
            DragSource ds, Component c, int srcActions,
            DragGestureListener dgl);

    public abstract DragSourceContextWrapper createDragSourceContext(DragGestureEvent dge)
                                            throws InvalidDnDOperationException;

    public abstract void addDropTarget(DropTarget dt);

    public abstract void removeDropTarget(DropTarget dt);

    private class LightweightContentProxy implements LightweightContent {

        public JComponent getComponent() {
            return LightweightContentWrapper.this.getComponent();
        }

        public void paintLock() {
            LightweightContentWrapper.this.paintLock();
        }

        public void paintUnlock() {
            LightweightContentWrapper.this.paintUnlock();
        }

        public void imageBufferReset(int[] data, int x, int y, int width,
                                     int height, int linestride) {
            LightweightContentWrapper.this.imageBufferReset(data, x, y, width,
                                     height, linestride);
        }

        public void imageBufferReset(int[] data, int x, int y, int width,
                                     int height, int linestride, double scaleX,
                                     double scaleY) {
            LightweightContentWrapper.this.imageBufferReset(data, x, y, width,
                                     height, linestride, scaleX, scaleY);
        }

        public void imageReshaped(int x, int y, int width, int height) {
            LightweightContentWrapper.this.imageReshaped(x, y, width, height);
        }

        public void imageUpdated(int dirtyX, int dirtyY,int dirtyWidth, int dirtyHeight) {
            LightweightContentWrapper.this.imageUpdated(dirtyX, dirtyY, dirtyWidth, dirtyHeight);
        }

        public void focusGrabbed() {
            LightweightContentWrapper.this.focusGrabbed();
        }

        public void focusUngrabbed() {
            LightweightContentWrapper.this.focusUngrabbed();
        }

        public void preferredSizeChanged(int width, int height) {
            LightweightContentWrapper.this.preferredSizeChanged(width, height);
        }

        public void maximumSizeChanged(int width, int height) {
            LightweightContentWrapper.this.maximumSizeChanged(width, height);
        }

        public void minimumSizeChanged(int width, int height) {
            LightweightContentWrapper.this.minimumSizeChanged(width, height);
        }

        public <T extends DragGestureRecognizer> T createDragGestureRecognizer(
            Class<T> abstractRecognizerClass,
            DragSource ds, Component c, int srcActions,
            DragGestureListener dgl) {
            return LightweightContentWrapper.this.createDragGestureRecognizer(
                          abstractRecognizerClass, ds, c, srcActions, dgl);
        }

        public DragSourceContextPeer createDragSourceContextPeer(DragGestureEvent dge)
                        throws InvalidDnDOperationException {
            DragSourceContextWrapper peerWrapper =
                    LightweightContentWrapper.this.createDragSourceContext(dge);
            return peerWrapper.getPeer();
        }

        public void addDropTarget(DropTarget dt) {
            LightweightContentWrapper.this.addDropTarget(dt);
        }

        public void removeDropTarget(DropTarget dt) {
            LightweightContentWrapper.this.removeDropTarget(dt);
        }
    }
}
