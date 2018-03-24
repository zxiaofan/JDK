/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk;

import javafx.stage.Stage;
import java.util.Map;

/**
 * Applets must run within a parent window, so this interface will allow the
 * plugin access to the underlying parent window that all Stages will be created
 * in.
 */
public interface AppletWindow {
    /*
     * topStage must be a primary stage and it's backing window a child window
     * of this AppletWindow or this method will have no effect.
     * The window will do what it can to make sure the given stage is on top of
     * the other primary applet stages. In the future we will allow specifying
     * Z order but that requires low level changes to Glass to do properly.
     */
    public void setStageOnTop(Stage topStage);

    public void setBackgroundColor(int color); // RGB triplet: 0xRRGGBB
    public void setForegroundColor(int color);

    public void setVisible(boolean state);

    public void setSize(int width, int height);
    public int getWidth();
    public int getHeight();

    public void setPosition(int x, int y);
    public int getPositionX();
    public int getPositionY();

    public float getPlatformScaleX();
    public float getPlatformScaleY();

    // returns CARemoteLayer id (only used on Mac)
    public int getRemoteLayerId();
    // dispatchEvent (only used on Mac)
    public void dispatchEvent(Map eventInfo);
}
