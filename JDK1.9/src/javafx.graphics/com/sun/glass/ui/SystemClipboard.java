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
package com.sun.glass.ui;

import java.util.HashMap;

public abstract class SystemClipboard extends Clipboard {
    protected SystemClipboard(String name) {
        super(name);
        Application.checkEventThread();
    }

    protected abstract boolean isOwner ();
    protected abstract void pushToSystem (HashMap<String, Object> cacheData, int supportedActions);
    protected abstract void pushTargetActionToSystem (int actionDone);
    protected abstract Object popFromSystem (String mimeType);
    protected abstract int supportedSourceActionsFromSystem ();
    protected abstract String[] mimesFromSystem ();

    @Override public void flush(
        ClipboardAssistance dataSource,
        HashMap<String, Object> cacheData,
        int supportedActions)
    {
        Application.checkEventThread();
        //Skip contentChanged() call in super.flush(cacheData, supportedActions).
        //We have get it from native instead!
        setSharedData(dataSource, cacheData, supportedActions);
        pushToSystem(cacheData, supportedActions);
    }

    @Override public int getSupportedSourceActions() {
        Application.checkEventThread();
        if (isOwner()) {
            return super.getSupportedSourceActions();
        }
        return supportedSourceActionsFromSystem ();
    }

    @Override public void setTargetAction(int actionDone) {
        Application.checkEventThread();
        pushTargetActionToSystem(actionDone);
    }

    public Object getLocalData(String mimeType) {
        return super.getData(mimeType);
    }

    @Override public Object getData(String mimeType) {
        Application.checkEventThread();
        if (isOwner()) {
            return getLocalData(mimeType);
        }
        return popFromSystem(mimeType);
    }

    @Override public String[] getMimeTypes() {
        Application.checkEventThread();
        if (isOwner()) {
            return super.getMimeTypes();
        }
        return mimesFromSystem();
    }

    @Override public String toString() {
        Application.checkEventThread();
        return "System Clipboard";
    }
}
