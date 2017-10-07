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
package com.sun.glass.events;

import java.lang.annotation.Native;

public class DndEvent {
    @Native final static public int ENTER   = 611;
    @Native final static public int UPDATE  = 612;
    @Native final static public int PERFORM = 613;
    @Native final static public int EXIT    = 614;
    @Native final static public int END     = 615;
}
