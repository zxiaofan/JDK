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

package com.sun.scenario.effect.impl.hw;

import java.io.InputStream;
import com.sun.scenario.effect.Effect.AccelType;

public interface ShaderSource {
    public InputStream loadSource(String name);
    public AccelType getAccelType();
}
