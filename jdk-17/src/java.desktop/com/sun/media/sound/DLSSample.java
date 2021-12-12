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

import java.io.InputStream;
import java.util.Arrays;

import javax.sound.midi.Soundbank;
import javax.sound.midi.SoundbankResource;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;

/**
 * This class is used to store the sample data itself.
 * A sample is encoded as PCM audio stream
 * and in DLS Level 1 files it is always a mono 8/16 bit stream.
 * They are stored just like RIFF WAVE files are stored.
 * It is stored inside a "wave" List Chunk inside DLS files.
 *
 * @author Karl Helgason
 */
public final class DLSSample extends SoundbankResource {

    byte[] guid = null;
    DLSInfo info = new DLSInfo();
    DLSSampleOptions sampleoptions;
    ModelByteBuffer data;
    AudioFormat format;

    public DLSSample(Soundbank soundBank) {
        super(soundBank, null, AudioInputStream.class);
    }

    public DLSSample() {
        super(null, null, AudioInputStream.class);
    }

    public DLSInfo getInfo() {
        return info;
    }

    @Override
    public Object getData() {
        AudioFormat format = getFormat();

        InputStream is = data.getInputStream();
        if (is == null)
            return null;
        return new AudioInputStream(is, format, data.capacity());
    }

    public ModelByteBuffer getDataBuffer() {
        return data;
    }

    public AudioFormat getFormat() {
        return format;
    }

    public void setFormat(AudioFormat format) {
        this.format = format;
    }

    public void setData(ModelByteBuffer data) {
        this.data = data;
    }

    public void setData(byte[] data) {
        this.data = new ModelByteBuffer(data);
    }

    public void setData(byte[] data, int offset, int length) {
        this.data = new ModelByteBuffer(data, offset, length);
    }

    @Override
    public String getName() {
        return info.name;
    }

    public void setName(String name) {
        info.name = name;
    }

    public DLSSampleOptions getSampleoptions() {
        return sampleoptions;
    }

    public void setSampleoptions(DLSSampleOptions sampleOptions) {
        this.sampleoptions = sampleOptions;
    }

    @Override
    public String toString() {
        return "Sample: " + info.name;
    }

    public byte[] getGuid() {
        return guid == null ? null : Arrays.copyOf(guid, guid.length);
    }

    public void setGuid(byte[] guid) {
        this.guid = guid == null ? null : Arrays.copyOf(guid, guid.length);
    }
}
