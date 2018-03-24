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

package com.sun.javafx.embed;

/**
 * An interface for embedded FX stage peer. It is used by HostInterface
 * object to send various notifications to the stage, for example,
 * when the size of embedding container is changed.
 *
 */
public interface EmbeddedStageInterface {

    public void setLocation(int x, int y);

    /*
     * A notification about the embedding container is resized.
     */
    public void setSize(int width, int height);

    /*
     * A notification about the embedding container received or lost
     * input focus because of various reasons, for example, it was
     * traversed forward in the focus chain in embedding app.
     */
    public void setFocused(boolean focused, int focusCause);

    /*
     * FOCUS_UNGRAB notification.
     */
    public void focusUngrab();
}
