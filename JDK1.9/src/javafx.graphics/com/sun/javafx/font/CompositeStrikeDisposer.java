/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.font;
import java.lang.ref.WeakReference;

import com.sun.javafx.font.DisposerRecord;
import com.sun.javafx.font.FontResource;
import com.sun.javafx.font.FontStrikeDesc;

class CompositeStrikeDisposer implements DisposerRecord {

    FontResource fontResource;
    FontStrikeDesc desc;
    boolean disposed = false;

    public CompositeStrikeDisposer(FontResource font, FontStrikeDesc desc) {
        this.fontResource = font;
        this.desc = desc;
    }

    public synchronized void dispose() {
        if (!disposed) {
            // Careful here. The original strike we are collecting
            // may now be superseded in the map, so only remove
            // the desc if the value reference has been cleared
            WeakReference ref = fontResource.getStrikeMap().get(desc);
            if (ref != null) {
                Object o = ref.get();
                if (o == null) {
                    fontResource.getStrikeMap().remove(desc);
                }
            }

            disposed = true;
        }
    }
}
