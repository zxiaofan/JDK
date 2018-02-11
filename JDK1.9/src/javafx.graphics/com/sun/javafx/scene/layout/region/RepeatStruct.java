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

package com.sun.javafx.scene.layout.region;

import javafx.scene.layout.BackgroundRepeat;

/**
 * An implementation class used by CSS as a struct for moving
 * data discovered during parsing to the Background and Border
 * converters.
 */
public final class RepeatStruct {
    public final BackgroundRepeat repeatX;
    public final BackgroundRepeat repeatY;

    public RepeatStruct(BackgroundRepeat repeatX, BackgroundRepeat repeatY) {
        this.repeatX = repeatX;
        this.repeatY = repeatY;
    }
}
