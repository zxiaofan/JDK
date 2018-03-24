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
 * ModelAbstractChannelMixer is ready for use class to implement
 * ModelChannelMixer interface.
 *
 * @author Karl Helgason
 */
public abstract class ModelAbstractChannelMixer implements ModelChannelMixer {

    @Override
    public abstract boolean process(float[][] buffer, int offset, int len);

    @Override
    public abstract void stop();

    @Override
    public void allNotesOff() {
    }

    @Override
    public void allSoundOff() {
    }

    @Override
    public void controlChange(int controller, int value) {
    }

    @Override
    public int getChannelPressure() {
        return 0;
    }

    @Override
    public int getController(int controller) {
        return 0;
    }

    @Override
    public boolean getMono() {
        return false;
    }

    @Override
    public boolean getMute() {
        return false;
    }

    @Override
    public boolean getOmni() {
        return false;
    }

    @Override
    public int getPitchBend() {
        return 0;
    }

    @Override
    public int getPolyPressure(int noteNumber) {
        return 0;
    }

    @Override
    public int getProgram() {
        return 0;
    }

    @Override
    public boolean getSolo() {
        return false;
    }

    @Override
    public boolean localControl(boolean on) {
        return false;
    }

    @Override
    public void noteOff(int noteNumber) {
    }

    @Override
    public void noteOff(int noteNumber, int velocity) {
    }

    @Override
    public void noteOn(int noteNumber, int velocity) {
    }

    @Override
    public void programChange(int program) {
    }

    @Override
    public void programChange(int bank, int program) {
    }

    @Override
    public void resetAllControllers() {
    }

    @Override
    public void setChannelPressure(int pressure) {
    }

    @Override
    public void setMono(boolean on) {
    }

    @Override
    public void setMute(boolean mute) {
    }

    @Override
    public void setOmni(boolean on) {
    }

    @Override
    public void setPitchBend(int bend) {
    }

    @Override
    public void setPolyPressure(int noteNumber, int pressure) {
    }

    @Override
    public void setSolo(boolean soloState) {
    }
}
