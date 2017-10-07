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

package com.sun.javafx.font.directwrite;

import com.sun.javafx.font.DisposerRecord;
import com.sun.javafx.font.PrismFontFactory;

class DWDisposer implements DisposerRecord  {
    IUnknown resource;

    DWDisposer(IUnknown resource) {
        this.resource = resource;
    }

    public synchronized void dispose() {
        if (resource != null) {
            resource.Release();
            if (PrismFontFactory.debugFonts) {
                System.err.println("DisposerRecord=" + resource);
            }
            resource = null;
        }
    }
}
