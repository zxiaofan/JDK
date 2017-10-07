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

import javafx.scene.input.TransferMode;

/**
 * Embedded FX drop target.
 */
public interface EmbeddedSceneDTInterface {

    public TransferMode handleDragEnter(int x, int y, int xAbs, int yAbs,
                                        TransferMode recommendedDropAction,
                                        EmbeddedSceneDSInterface dragSource);

    public void handleDragLeave();

    public TransferMode handleDragDrop(int x, int y, int xAbs, int yAbs,
                                       TransferMode recommendedDropAction);

    public TransferMode handleDragOver(int x, int y, int xAbs, int yAbs,
                                       TransferMode recommendedDropAction);
}
