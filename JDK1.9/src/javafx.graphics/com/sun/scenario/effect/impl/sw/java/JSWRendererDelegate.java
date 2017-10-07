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

package com.sun.scenario.effect.impl.sw.java;

import com.sun.scenario.effect.Effect.AccelType;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.sw.RendererDelegate;

public class JSWRendererDelegate implements RendererDelegate {

    public JSWRendererDelegate() {
    }

    public AccelType getAccelType() {
        return AccelType.NONE;
    }

    public String getPlatformPeerName(String name, int unrollCount) {
        return Renderer.rootPkg + ".impl.sw.java.JSW" + name + "Peer";
    }
}
