/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.util;


/**
 * Provides a listener to monitor the activity of the JDK Java Compiler, javac.
 *
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface TaskListener
{
    /**
     * Invoked when an event has begun.
     *
     * @implSpec The default implementation of this method does nothing.
     *
     * @param e the event
     */
    default void started(TaskEvent e) { }

    /**
     * Invoked when an event has been completed.
     *
     * @implSpec The default implementation of this method does nothing.
     *
     * @param e the event
     */
    default void finished(TaskEvent e) { }
}
