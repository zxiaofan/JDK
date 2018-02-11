/*
 * Copyright (c) 2008, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.scenario.effect.impl.sw.sse;

import java.security.AccessController;
import java.security.PrivilegedAction;
import com.sun.glass.utils.NativeLibLoader;
import com.sun.scenario.effect.Effect.AccelType;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.sw.RendererDelegate;

public class SSERendererDelegate implements RendererDelegate {

    public static native boolean isSupported();

    static {
        AccessController.doPrivileged((PrivilegedAction) () -> {
            NativeLibLoader.loadLibrary("decora_sse");
            return null;
        });
    }

    public SSERendererDelegate() {
        if (!isSupported()) {
            throw new UnsupportedOperationException("required instruction set (SSE2)" +
                                                    " not supported on this processor");
        }
    }

    public AccelType getAccelType() {
        return AccelType.SIMD;
    }

    public String getPlatformPeerName(String name, int unrollCount) {
        return Renderer.rootPkg + ".impl.sw.sse.SSE" + name + "Peer";
    }
}
