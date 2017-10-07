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

package com.sun.scenario.effect.impl.hw.d3d;

import java.io.InputStream;
import com.sun.scenario.effect.Effect.AccelType;
import com.sun.scenario.effect.impl.hw.ShaderSource;

public class D3DShaderSource implements ShaderSource {

    public D3DShaderSource() {
    }

    public InputStream loadSource(String name) {
        return D3DShaderSource.class.
            getResourceAsStream("hlsl/" + name + ".obj");
    }

    public AccelType getAccelType() {
        return AccelType.DIRECT3D;
    }
}
