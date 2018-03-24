/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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

import javax.sound.midi.MidiChannel;
import javax.sound.midi.Patch;
import javax.sound.sampled.AudioFormat;

/**
 * This class is used to map instrument to another patch.
 *
 * @author Karl Helgason
 */
public final class ModelMappedInstrument extends ModelInstrument {

    private final ModelInstrument ins;

    public ModelMappedInstrument(ModelInstrument ins, Patch patch) {
        super(ins.getSoundbank(), patch, ins.getName(), ins.getDataClass());
        this.ins = ins;
    }

    @Override
    public Object getData() {
        return ins.getData();
    }

    @Override
    public ModelPerformer[] getPerformers() {
        return ins.getPerformers();
    }

    @Override
    public ModelDirector getDirector(ModelPerformer[] performers,
                                     MidiChannel channel, ModelDirectedPlayer player) {
        return ins.getDirector(performers, channel, player);
    }

    @Override
    public ModelChannelMixer getChannelMixer(MidiChannel channel,
                                             AudioFormat format) {
        return ins.getChannelMixer(channel, format);
    }
}
