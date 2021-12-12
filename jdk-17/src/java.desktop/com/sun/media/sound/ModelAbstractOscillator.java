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

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.Patch;
import javax.sound.midi.Soundbank;
import javax.sound.midi.SoundbankResource;
import javax.sound.midi.VoiceStatus;

/**
 * A abstract class used to simplify creating custom ModelOscillator.
 *
 * @author Karl Helgason
 */
public abstract class ModelAbstractOscillator
        implements ModelOscillator, ModelOscillatorStream, Soundbank {

    protected float pitch = 6000;
    protected float samplerate;
    protected MidiChannel channel;
    protected VoiceStatus voice;
    protected int noteNumber;
    protected int velocity;
    protected boolean on = false;

    public void init() {
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public void noteOff(int velocity) {
        on = false;
    }

    @Override
    public void noteOn(MidiChannel channel, VoiceStatus voice, int noteNumber,
                       int velocity) {
        this.channel = channel;
        this.voice = voice;
        this.noteNumber = noteNumber;
        this.velocity = velocity;
        on = true;
    }

    @Override
    public int read(float[][] buffer, int offset, int len) throws IOException {
        return -1;
    }

    public MidiChannel getChannel() {
        return channel;
    }

    public VoiceStatus getVoice() {
        return voice;
    }

    public int getNoteNumber() {
        return noteNumber;
    }

    public int getVelocity() {
        return velocity;
    }

    public boolean isOn() {
        return on;
    }

    @Override
    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getPitch() {
        return pitch;
    }

    public void setSampleRate(float samplerate) {
        this.samplerate = samplerate;
    }

    public float getSampleRate() {
        return samplerate;
    }

    @Override
    public float getAttenuation() {
        return 0;
    }

    @Override
    public int getChannels() {
        return 1;
    }

    @Override
    public String getName() {
        return getClass().getName();
    }

    public Patch getPatch() {
        return new Patch(0, 0);
    }

    @Override
    @SuppressWarnings("deprecation")
    public ModelOscillatorStream open(float samplerate) {
        ModelAbstractOscillator oscs;
        try {
            oscs = this.getClass().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException(e);
        }
        oscs.setSampleRate(samplerate);
        oscs.init();
        return oscs;
    }

    public ModelPerformer getPerformer() {
        // Create performer for my custom oscillirator
        ModelPerformer performer = new ModelPerformer();
        performer.getOscillators().add(this);
        return performer;

    }

    public ModelInstrument getInstrument() {
        // Create Instrument object around my performer
        SimpleInstrument ins = new SimpleInstrument();
        ins.setName(getName());
        ins.add(getPerformer());
        ins.setPatch(getPatch());
        return ins;

    }

    public Soundbank getSoundBank() {
        // Create Soundbank object around the instrument
        SimpleSoundbank sbk = new SimpleSoundbank();
        sbk.addInstrument(getInstrument());
        return sbk;
    }

    @Override
    public String getDescription() {
        return getName();
    }

    @Override
    public Instrument getInstrument(Patch patch) {
        Instrument ins = getInstrument();
        Patch p = ins.getPatch();
        if (p.getBank() != patch.getBank())
            return null;
        if (p.getProgram() != patch.getProgram())
            return null;
        if (p instanceof ModelPatch && patch instanceof ModelPatch) {
            if (((ModelPatch)p).isPercussion()
                    != ((ModelPatch)patch).isPercussion()) {
                return null;
            }
        }
        return ins;
    }

    @Override
    public Instrument[] getInstruments() {
        return new Instrument[]{getInstrument()};
    }

    @Override
    public SoundbankResource[] getResources() {
        return new SoundbankResource[0];
    }

    @Override
    public String getVendor() {
        return null;
    }

    @Override
    public String getVersion() {
        return null;
    }
}
