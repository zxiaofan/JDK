/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.scenario.effect.impl.sw;

import com.sun.scenario.effect.Effect.AccelType;

public interface RendererDelegate {

    public AccelType getAccelType();
    public String getPlatformPeerName(String name, int unrollCount);
}
