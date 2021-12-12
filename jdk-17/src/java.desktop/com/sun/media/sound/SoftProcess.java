/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.sound;

/**
 * Control signal processor interface.
 *
 * @author Karl Helgason
 */
public interface SoftProcess extends SoftControl {

    void init(SoftSynthesizer synth);

    @Override
    double[] get(int instance, String name);

    void processControlLogic();

    void reset();
}
