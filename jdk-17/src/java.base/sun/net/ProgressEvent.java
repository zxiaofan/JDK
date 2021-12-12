/*
 * Copyright (c) 2004, 2008, Oracle and/or its affiliates. All rights reserved.
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
package sun.net;

import java.util.EventObject;
import java.net.URL;

/**
 * ProgressEvent represents an progress event in monitering network input stream.
 *
 * @author Stanley Man-Kit Ho
 */
@SuppressWarnings("serial")  // never serialized
public class ProgressEvent extends EventObject  {
    // URL of the stream
    private URL url;
    // content type of the stream
    private String contentType;
    // method associated with URL
    private String method;
    // bytes read
    private long progress;
    // bytes expected
    private long expected;
    // the last thing to happen
    private ProgressSource.State state;

    /**
     * Construct a ProgressEvent object.
     */
    public ProgressEvent(ProgressSource source, URL url, String method, String contentType, ProgressSource.State state, long progress, long expected) {
        super(source);
        this.url = url;
        this.method = method;
        this.contentType = contentType;
        this.progress = progress;
        this.expected = expected;
        this.state = state;
    }

    /**
     * Return URL related to the progress.
     */
    public URL getURL()
    {
        return url;
    }

    /**
     * Return method associated with URL.
     */
    public String getMethod()
    {
        return method;
    }

    /**
     * Return content type of the URL.
     */
    public String getContentType()
    {
        return contentType;
    }

    /**
     * Return current progress value.
     */
    public long getProgress()
    {
        return progress;
    }

    /**
     * Return expected maximum progress value; -1 if expected is unknown.
     */
    public long getExpected() {
        return expected;
    }

    /**
     * Return state.
     */
    public ProgressSource.State getState() {
        return state;
    }

    public String toString()    {
        return getClass().getName() + "[url=" + url + ", method=" + method + ", state=" + state
             + ", content-type=" + contentType + ", progress=" + progress + ", expected=" + expected + "]";
    }
}
