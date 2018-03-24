/*
 * Copyright (c) 1995, 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.applet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.applet.AudioClip;

import com.sun.media.sound.JavaSoundAudioClip;


/**
 * Applet audio clip;
 *
 * @author Arthur van Hoff, Kara Kytle
 */

@SuppressWarnings("deprecation")
public class AppletAudioClip implements AudioClip {

    // url that this AudioClip is based on
    private URL url = null;

    // the audio clip implementation
    private AudioClip audioClip = null;

    boolean DEBUG = false /*true*/;

    /**
     * Constructs an AppletAudioClip from an URL.
     */
    public AppletAudioClip(URL url) {

        // store the url
        this.url = url;

        try {
            // create a stream from the url, and use it
            // in the clip.
            InputStream in = url.openStream();
            createAppletAudioClip(in);

        } catch (IOException e) {
                /* just quell it */
            if (DEBUG) {
                System.err.println("IOException creating AppletAudioClip" + e);
            }
        }
    }

    /**
     * Constructs an AppletAudioClip from a URLConnection.
     */
    public AppletAudioClip(URLConnection uc) {

        try {
            // create a stream from the url, and use it
            // in the clip.
            createAppletAudioClip(uc.getInputStream());

        } catch (IOException e) {
                /* just quell it */
            if (DEBUG) {
                System.err.println("IOException creating AppletAudioClip" + e);
            }
        }
    }


    /**
     * For constructing directly from Jar entries, or any other
     * raw Audio data. Note that the data provided must include the format
     * header.
     */
    public AppletAudioClip(byte [] data) {

        try {

            // construct a stream from the byte array
            InputStream in = new ByteArrayInputStream(data);

            createAppletAudioClip(in);

        } catch (IOException e) {
                /* just quell it */
            if (DEBUG) {
                System.err.println("IOException creating AppletAudioClip " + e);
            }
        }
    }


    /*
     * Does the real work of creating an AppletAudioClip from an InputStream.
     * This function is used by both constructors.
     */
    void createAppletAudioClip(InputStream in) throws IOException {

        try {
            audioClip = new JavaSoundAudioClip(in);
        } catch (Exception e3) {
            // no matter what happened, we throw an IOException to avoid changing the interfaces....
            throw new IOException("Failed to construct the AudioClip: " + e3);
        }
    }


    public synchronized void play() {

                if (audioClip != null)
                        audioClip.play();
    }


    public synchronized void loop() {

                if (audioClip != null)
                        audioClip.loop();
    }

    public synchronized void stop() {

                if (audioClip != null)
                        audioClip.stop();
    }
}
