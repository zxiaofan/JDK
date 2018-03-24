/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

import javafx.scene.input.TransferMode;

/**
 * Listens for drag source events on a TKScene.
 * <br>
 * TODO: extend this interface to include dropActionChanged() notification
 */
public interface TKDragSourceListener {

    void dragDropEnd(double x, double y, double screenX, double screenY, TransferMode transferMode);
}
