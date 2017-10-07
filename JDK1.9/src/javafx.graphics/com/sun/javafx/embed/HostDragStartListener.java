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

package com.sun.javafx.embed;

import javafx.scene.input.TransferMode;

/*
 * Interface, which is implemented by the host UI toolkit to track,
 * when DnD is started in embedded FX scene.
 */
public interface HostDragStartListener {
    public void dragStarted(EmbeddedSceneDSInterface dragSource, TransferMode dragAction);
}
