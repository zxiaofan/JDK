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
import com.sun.glass.ui.Application;

import sun.util.logging.PlatformLogger.Level;

final class LensDnDClipboard extends SystemClipboard {

    public LensDnDClipboard() {
        super(Clipboard.DND);
        if (LensLogger.getLogger().isLoggable(Level.FINE)) {
            LensLogger.getLogger().fine("constructor called");
        }
    }

    /**
     * Should be called when drag operation completed by the 'system'
     *
     * @param action mask of actions from Clipboard
     */
    public void actionPerformed(int action) {
        if (LensLogger.getLogger().isLoggable(Level.FINE)) {
            LensLogger.getLogger().fine("action =  ["+
                                         Integer.toHexString(action)+"]");
        }
        super.actionPerformed(action);
    }

    protected  boolean isOwner() {
        //called many time while the hovering over target node
        //So reduced log level to finest in order to reduce log clutter
        if (LensLogger.getLogger().isLoggable(Level.FINEST)) {
            LensLogger.getLogger().finest("returns true");
        }
        return true;//For DnD its always true
    }
    /**
     * Here the magic happens.
     * When this method is called all input events should be grabbed and
     * appropriate drag notifications should be sent instead of regular input
     * events
     */
    protected  void pushToSystem(HashMap<String, Object> cacheData, int supportedActions) {
        if (LensLogger.getLogger().isLoggable(Level.FINE)) {
            LensLogger.getLogger().fine("handling drag");
        }

        if (LensLogger.getLogger().isLoggable(Level.FINER)) {
            LensLogger.getLogger().finer("data =[cachedData = "+ cacheData+
                " supportedActions= "+Integer.toHexString(supportedActions));
        }

        LensApplication lensApp = (LensApplication)Application.GetApplication();
        lensApp.notifyDragStart();

        if (LensLogger.getLogger().isLoggable(Level.FINE)) {
            LensLogger.getLogger().fine("starting nested event loop");
        }

        lensApp.enterDnDEventLoop();
        // The loop is exited in LensApplication.LensDragEvent.dispatch()
        if (LensLogger.getLogger().isLoggable(Level.FINE)) {
            LensLogger.getLogger().fine("nested event loop finished");
            LensLogger.getLogger().fine("Drag done - notifying actionPreformed");
        }

        actionPerformed(Clipboard.ACTION_COPY_OR_MOVE);
    }




    //rest of the functionis should not be called. Only applicable for
    //SystemClipboards
    //Must be overrided thue as they are abstract functions

    protected  void pushTargetActionToSystem(int actionDone) {
        LensLogger.getLogger().warning("Not supported");
        if (LensLogger.getLogger().isLoggable(Level.FINE)) {
            LensLogger.getLogger().fine("actionDone = "+
                                         Integer.toHexString(actionDone));
        }

    }

    protected  Object popFromSystem(String mimeType) {
        LensLogger.getLogger().warning("Not supported");
        if (LensLogger.getLogger().isLoggable(Level.FINE)) {
            LensLogger.getLogger().fine("mimeType="+mimeType);
        }
        return null;
    }
    protected  int supportedSourceActionsFromSystem() {
        LensLogger.getLogger().warning("Not supported");

        return Clipboard.ACTION_COPY_OR_MOVE;
    }

    protected  String[] mimesFromSystem() {
        LensLogger.getLogger().warning("Not supported");

        return null;
    }

}
