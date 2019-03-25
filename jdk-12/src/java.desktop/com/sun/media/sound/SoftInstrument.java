/*
 * Copyright (c) 2007, 2014, Oracle and/or its affiliates. All rights reserved.
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

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;

/**
 * Software synthesizer internal instrument.
 *
 * @author Karl Helgason
 */
public final class SoftInstrument extends Instrument {

    private SoftPerformer[] performers;
    private ModelPerformer[] modelperformers;
    private final Object data;
    private final ModelInstrument ins;

    public SoftInstrument(ModelInstrument ins) {
        super(ins.getSoundbank(), ins.getPatch(), ins.getName(),
                ins.getDataClass());
        data = ins.getData();
        this.ins = ins;
        initPerformers(ins.getPerformers());
    }

    public SoftInstrument(ModelInstrument ins,
            ModelPerformer[] overrideperformers) {
        super(ins.getSoundbank(), ins.getPatch(), ins.getName(),
                ins.getDataClass());
        data = ins.getData();
        this.ins = ins;
        initPerformers(overrideperformers);
    }

    private void initPerformers(ModelPerformer[] modelperformers) {
        this.modelperformers = modelperformers;
        performers = new SoftPerformer[modelperformers.length];
        for (int i = 0; i < modelperformers.length; i++)
            performers[i] = new SoftPerformer(modelperformers[i]);
    }

    public ModelDirector getDirector(MidiChannel channel,
            ModelDirectedPlayer player) {
        return ins.getDirector(modelperformers, channel, player);
    }

    public ModelInstrument getSourceInstrument() {
        return ins;
    }

    @Override
    public Object getData() {
        return data;
    }

    /* am: currently getPerformers() is not used (replaced with getPerformer(int))
    public SoftPerformer[] getPerformers() {
        return performers;
    }
    */
    public SoftPerformer getPerformer(int index) {
        return performers[index];
    }
}
