/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.input;

import com.sun.javafx.tk.TKClipboard;
import com.sun.javafx.util.Utils;
import javafx.scene.input.Dragboard;

/**
 * Used to access internal methods of Dragboard.
 */
public class DragboardHelper {
    private static DragboardAccessor dragboardAccessor;

    static {
        Utils.forceInit(Dragboard.class);
    }

    private DragboardHelper() {
    }

    public static void setDataAccessRestriction(Dragboard dragboard,
            boolean restricted) {
        dragboardAccessor.setDataAccessRestriction(dragboard, restricted);
    }

    public static TKClipboard getPeer(Dragboard dragboard) {
        return dragboardAccessor.getPeer(dragboard);
    }

    public static Dragboard createDragboard(TKClipboard peer) {
        return dragboardAccessor.createDragboard(peer);
    }

    public static void setDragboardAccessor(final DragboardAccessor newAccessor) {
        if (dragboardAccessor != null) {
            throw new IllegalStateException();
        }

        dragboardAccessor = newAccessor;
    }

    public interface DragboardAccessor {
        void setDataAccessRestriction(Dragboard dragboard, boolean restricted);
        TKClipboard getPeer(Dragboard dragboard);
        Dragboard createDragboard(TKClipboard peer);
    }

}
