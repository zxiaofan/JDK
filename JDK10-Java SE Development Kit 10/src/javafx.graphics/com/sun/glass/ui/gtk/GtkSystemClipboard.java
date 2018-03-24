/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui.gtk;

import com.sun.glass.ui.Clipboard;
import com.sun.glass.ui.SystemClipboard;
import java.util.HashMap;

final class GtkSystemClipboard extends SystemClipboard {

    public GtkSystemClipboard() {
        super(Clipboard.SYSTEM);
        init();
    }

    @Override
    protected void close() {
        super.close();
        dispose();
    }

    private native void init();

    private native void dispose();

    @Override
    protected native boolean isOwner();

    @Override
    protected native void pushToSystem(HashMap<String, Object> cacheData, int supportedActions);

    @Override
    protected native void pushTargetActionToSystem(int actionDone);

    @Override
    protected native Object popFromSystem(String mimeType);

    @Override
    protected native int supportedSourceActionsFromSystem();

    @Override
    protected native String[] mimesFromSystem();

}
