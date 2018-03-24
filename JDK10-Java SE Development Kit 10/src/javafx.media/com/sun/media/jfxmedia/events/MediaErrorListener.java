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

package com.sun.media.jfxmedia.events;

/**
 * An interface used to receive notifications of errors, encountered while
 * processing media.
 */
public interface MediaErrorListener {
    /**
     * Reports the occurrence of a error in media processing.  An error may
     * or may not cause a stop in processing.
     *
     * @param source the source of the warning, likely the object calling this
     * method.
     * @param errorCode an error code from the internal playback processor
     * @param message a <code>String</code> containing the warning.
     */
    void onError(Object source, int errorCode, String message);
}
