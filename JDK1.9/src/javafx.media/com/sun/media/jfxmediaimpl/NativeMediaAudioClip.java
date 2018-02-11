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

import com.sun.media.jfxmedia.AudioClip;
import com.sun.media.jfxmedia.locator.Locator;
import com.sun.media.jfxmedia.logging.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AudioClip implementation that uses NativeMediaPlayer to play sounds.
 */
final class NativeMediaAudioClip extends AudioClip {
    private URI sourceURI;
    private Locator mediaLocator;
    private AtomicInteger playCount; // track current and scheduled play requests

    private NativeMediaAudioClip(URI source) throws URISyntaxException, FileNotFoundException, IOException  {
        sourceURI = source;
        playCount = new AtomicInteger(0);

        if (Logger.canLog(Logger.DEBUG)) {
            Logger.logMsg(Logger.DEBUG, "Creating AudioClip for URI " + source);
        }

        mediaLocator = new Locator(sourceURI);
        mediaLocator.init();
        mediaLocator.cacheMedia(); // load into memory
    }

    Locator getLocator() {
        return mediaLocator;
    }

    public static AudioClip load(URI source) throws URISyntaxException, FileNotFoundException, IOException {
        return new NativeMediaAudioClip(source);
    }

    /*
     * TODO: Implement unsupported methods
     * http://javafx-jira.kenai.com/browse/RT-27007
     */
    public static AudioClip create(byte[] data, int dataOffset, int sampleCount, int sampleFormat, int channels, int sampleRate) {
        throw new UnsupportedOperationException("NativeMediaAudioClip does not support creating clips from raw sample data");
    }

    @Override
    public AudioClip createSegment(double startTime, double stopTime) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AudioClip createSegment(int startSample, int endSample) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AudioClip resample(int startSample, int endSample, int newSampleRate) throws IllegalArgumentException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AudioClip append(AudioClip clip) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AudioClip flatten() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isPlaying() {
        return playCount.get() > 0;
    }

    @Override
    public void play() {
        play(clipVolume, clipBalance, clipRate, clipPan, loopCount, clipPriority);
    }

    @Override
    public void play(double volume) {
        play(volume, clipBalance, clipRate, clipPan, loopCount, clipPriority);
    }

    @Override
    public void play(double volume, double balance, double rate, double pan, int loopCount, int priority) {
        // this schedules the clip for playing so we can return asap
        playCount.getAndIncrement();
        NativeMediaAudioClipPlayer.playClip(this, volume, balance, rate, pan, loopCount, priority);
    }

    @Override
    public void stop() {
        NativeMediaAudioClipPlayer.stopPlayers(mediaLocator);
    }

    public static void stopAllClips() {
        NativeMediaAudioClipPlayer.stopPlayers(null);
    }

    // called by the player when it's either finished (removed from activePlayer
    // list) or unscheduled due to queue overload
    void playFinished() {
        playCount.decrementAndGet();
    }
}
