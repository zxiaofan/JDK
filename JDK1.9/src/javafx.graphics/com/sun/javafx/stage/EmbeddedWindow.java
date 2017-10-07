/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.stage;

import javafx.scene.Scene;
import javafx.stage.Window;

import com.sun.javafx.embed.HostInterface;
import com.sun.javafx.tk.Toolkit;

/**
 * User: Artem
 * Date: Dec 21, 2010
 * Time: 4:30:56 PM
 */
public class EmbeddedWindow extends Window {

     static {
        EmbeddedWindowHelper.setEmbeddedWindowAccessor(new EmbeddedWindowHelper.EmbeddedWindowAccessor() {
            @Override public void doVisibleChanging(Window window, boolean visible) {
                ((EmbeddedWindow) window).doVisibleChanging(visible);
            }
        });
     }

    private HostInterface host;

    public EmbeddedWindow(HostInterface host) {
        this.host = host;
        EmbeddedWindowHelper.initHelper(this);
    }

    public HostInterface getHost() {
        return host;
    }

    /**
     * Specify the scene to be used on this stage.
     */
    @Override public final void setScene(Scene value) {
        super.setScene(value);
    }

    /**
     * Specify the scene to be used on this stage.
     */
    @Override public final void show() {
        super.show();
    }

    /*
     * This can be replaced by listening for the onShowing/onHiding events
     * Note: This method MUST only be called via its accessor method.
     */
    private void doVisibleChanging(boolean visible) {
        Toolkit toolkit = Toolkit.getToolkit();
        if (visible && (WindowHelper.getPeer(this) == null)) {
            // Setup the peer
            WindowHelper.setPeer(this, toolkit.createTKEmbeddedStage(host,
                    WindowHelper.getAccessControlContext(this)));
            WindowHelper.setPeerListener(this, new WindowPeerListener(this));
        }
    }

}
