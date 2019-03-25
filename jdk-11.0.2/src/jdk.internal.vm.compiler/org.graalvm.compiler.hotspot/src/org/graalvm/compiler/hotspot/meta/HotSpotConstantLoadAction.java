/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.hotspot.meta;

public enum HotSpotConstantLoadAction {
    RESOLVE(0),
    INITIALIZE(1),
    MAKE_NOT_ENTRANT(2),
    LOAD_COUNTERS(3);

    private int value;

    HotSpotConstantLoadAction(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
