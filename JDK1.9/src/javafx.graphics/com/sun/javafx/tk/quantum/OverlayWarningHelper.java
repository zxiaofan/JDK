/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk.quantum;

import com.sun.javafx.scene.DirtyBits;
import com.sun.javafx.scene.GroupHelper;
import com.sun.javafx.scene.shape.TextHelper;
import com.sun.javafx.util.Utils;
import javafx.scene.Node;

/**
 * Used to access internal methods of OverlayWarning.
 */
public class OverlayWarningHelper extends GroupHelper {

    private static final OverlayWarningHelper theInstance;
    private static OverlayWarningAccessor overlayWarningAccessor;

    static {
        theInstance = new OverlayWarningHelper();
        Utils.forceInit(OverlayWarning.class);
    }

    private static OverlayWarningHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(OverlayWarning overlayWarning) {
        setHelper(overlayWarning, getInstance());
    }

    @Override
    protected void updatePeerImpl(Node node) {
        overlayWarningAccessor.doUpdatePeer(node);
        super.updatePeerImpl(node);
    }

    @Override
    protected void markDirtyImpl(Node node, DirtyBits dirtyBit) {
        super.markDirtyImpl(node, dirtyBit);
        overlayWarningAccessor.doMarkDirty(node, dirtyBit);
    }

    public static void setOverlayWarningAccessor(final OverlayWarningAccessor newAccessor) {
        if (overlayWarningAccessor != null) {
            throw new IllegalStateException();
        }

        overlayWarningAccessor = newAccessor;
    }

    public interface OverlayWarningAccessor {
        void doMarkDirty(Node node, DirtyBits dirtyBit);
        void doUpdatePeer(Node node);
    }

}
