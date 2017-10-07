/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.jfxmediaimpl;

import java.net.URI;
import com.sun.media.jfxmedia.AudioClip;
import com.sun.media.jfxmedia.logging.Logger;
import java.net.URISyntaxException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Singleton class that manages AudioClip implementations.
 */
public class AudioClipProvider {
    private static AudioClipProvider primaDonna;
    private boolean useNative;

    public static synchronized AudioClipProvider getProvider() {
        if (null == primaDonna) {
            primaDonna = new AudioClipProvider();
        }
        return primaDonna;
    }

    private AudioClipProvider() {
        // Attempt to init the native audio clip stack
        // if that fails, fall back on the NativeMediaAudioClip impl
        useNative = false;
        try {
            useNative = NativeAudioClip.init();
        } catch (UnsatisfiedLinkError ule) {
            Logger.logMsg(Logger.DEBUG, "JavaFX AudioClip native methods not linked, using NativeMedia implementation");
        } catch (Exception t) {
            Logger.logMsg(Logger.ERROR, "Exception while loading native AudioClip library: "+t);
        }
    }

    public AudioClip load(URI source) throws URISyntaxException, FileNotFoundException, IOException {
        if (useNative) {
            return NativeAudioClip.load(source);
        }
        return NativeMediaAudioClip.load(source);
    }

    public AudioClip create(byte[] data, int dataOffset, int sampleCount, int sampleFormat, int channels, int sampleRate)
            throws IllegalArgumentException
    {
        if (useNative) {
            return NativeAudioClip.create(data, dataOffset, sampleCount, sampleFormat, channels, sampleRate);
        }
        return NativeMediaAudioClip.create(data, dataOffset, sampleCount, sampleFormat, channels, sampleRate);
    }

    public void stopAllClips() {
        if (useNative) {
            NativeAudioClip.stopAllClips();
        }
        NativeMediaAudioClip.stopAllClips();
    }
}
