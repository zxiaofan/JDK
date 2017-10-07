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

import java.io.IOException;

/**
 * Resampler stream interface.
 *
 * @author Karl Helgason
 */
public interface SoftResamplerStreamer extends ModelOscillatorStream {

    void open(ModelWavetable osc, float outputsamplerate) throws IOException;
}
