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

package com.sun.scenario.effect.impl.es2;

import java.io.InputStream;
import com.sun.scenario.effect.Effect.AccelType;
import com.sun.scenario.effect.impl.hw.ShaderSource;

public class ES2ShaderSource implements ShaderSource {

    public ES2ShaderSource() {
    }

    public InputStream loadSource(String name) {
        return ES2ShaderSource.class.
            getResourceAsStream("glsl/" + name + ".frag");
    }

    public AccelType getAccelType() {
        return AccelType.OPENGL;
    }
}
