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
 * A director chooses what performers should be  played for each note on
 * and note off events.
 *
 * ModelInstrument can implement custom performer who chooses what performers
 * to play for example by sustain pedal is off or on.
 *
 * The default director (ModelStandardDirector) chooses performers
 * by there keyfrom,keyto,velfrom,velto properties.
 *
 * @author Karl Helgason
 */
public interface ModelDirector {

    void noteOn(int noteNumber, int velocity);

    void noteOff(int noteNumber, int velocity);

    void close();
}
