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

import java.util.Set;

import javafx.scene.input.TransferMode;

/**
 * Drag source interface. There are two implementations:
 *   - EmbeddedSceneDS, which is used, when FX scene inside JFXPanel/FXCanvas is a drag source
 *   - SwingDragSource, which is used for external drag sources
 */
public interface EmbeddedSceneDSInterface {

    public Set<TransferMode> getSupportedActions();

    public Object getData(String mimeType);

    public String[] getMimeTypes();

    public boolean isMimeTypeAvailable(String mimeType);

    public void dragDropEnd(TransferMode performedAction);
}
