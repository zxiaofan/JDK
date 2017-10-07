/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.lens;

import java.util.HashMap;

import com.sun.glass.ui.Clipboard;
import com.sun.glass.ui.SystemClipboard;

import sun.util.logging.PlatformLogger.Level;

/**
 * Current supported embedded system doesn't have native clipboard, therefore
 * this class is a stub implementation of SystemClipboard that will provide
 * Clipboard functionality for a single FX application.
 */

final class LensSystemClipboard extends SystemClipboard {

    public LensSystemClipboard() {
        super(Clipboard.SYSTEM);
        if (LensLogger.getLogger().isLoggable(Level.FINE)) {
            LensLogger.getLogger().fine("LensSystemClipboard created");
        }
    }

    protected boolean isOwner() {
        //LensSystemClipboard doesn't integrate with platform clipboard as
        //it not available, so we always return true

        return true;
    }

    protected void pushToSystem(HashMap<String, Object> cacheData,
                                int supportedActions) {
        //no-op as there is no system clipboard

        if (LensLogger.getLogger().isLoggable(Level.FINE)) {
            LensLogger.getLogger().fine("LensSystemClipboard::pushToSystem " +
                                        "cacheData = " + cacheData +
                                        "supportedActions: " +
                                        getActionString(supportedActions));
        }

    }

    protected void pushTargetActionToSystem(int actionDone) {
        //no-op as there is no system clipboard
        if (LensLogger.getLogger().isLoggable(Level.FINE)) {
            LensLogger.getLogger().fine("LensSystemClipboard::pushTargetActionToSystem "
                                        + "actionDone: " +
                                        getActionString(actionDone));
        }

    }
    protected Object popFromSystem(String mimeType) {
        //this method should not be called as we are the owner of the data
        //see SystemClipboard::getData(String mimeType) for more information
        LensLogger.getLogger().warning("LensSystemClipboard::popFromSystem was called "
                                       + "mimType = " + mimeType);
        return null;
    }

    protected int supportedSourceActionsFromSystem() {
        //this method should not be called as we are the owner of the data
        //see SystemClipboard::getSupportedSourceActions() for more information
        LensLogger.getLogger().warning("LensSystemClipboard::supportedSourceActionsFromSystem "
                                       + "was called ");
        return Clipboard.ACTION_NONE;
    }

    protected String[] mimesFromSystem() {
        //this method should not be called as we are the owner of the data
        //see SystemClipboard::getMimeTypes() for more information
        LensLogger.getLogger().warning("LensSystemClipboard::mimesFromSystem "
                                       + "was called ");

        return new String[0];
    }

}
