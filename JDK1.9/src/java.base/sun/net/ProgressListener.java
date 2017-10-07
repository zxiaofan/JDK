/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

import java.util.EventListener;

/**
 * ProgressListener is an interface to be implemented by parties
 * interested to be notified of progress in network input stream.
 *
 * @author Stanley Man-Kit Ho
 */
public interface ProgressListener extends EventListener
{
    /**
     * Start progress.
     */
    public void progressStart(ProgressEvent evt);

    /**
     * Update progress.
     */
    public void progressUpdate(ProgressEvent evt);

    /**
     * Finish progress.
     */
    public void progressFinish(ProgressEvent evt);
}
