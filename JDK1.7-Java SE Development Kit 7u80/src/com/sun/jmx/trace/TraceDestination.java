/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sun.jmx.trace;

import java.io.IOException;

/**
 * Defines the methods that a trace destination must implement.
 *
 * @since 1.5
 */
@Deprecated
public interface TraceDestination {

    /**
     * Verify whether the specified info level and the info type are
     * selected by a listener.
     *
     * <P>It is strongly recommended to call this method before sending
     *    information to this Trace class.
     *
     * @param level the level of trace information.
     * @param type the type of the trace information.
     */
    public boolean isSelected(int level, int type);

    /**
     * Send a new information to this Trace destination
     *
     * @param level the level of trace information to be sent.
     * @param type the type of trace information to be sent.
     * @param className  the name of the class from which the trace
     *                   information is from.
     * @param methodName the name of the method from which the trace
     *                   information is from.
     * @param info the trace information to be sent.
     * @return false if the level and the type are not selected.
     */
    public boolean send(int level,
                        int type,
                        String className,
                        String methodName,
                        String info);

   /**
     * Send an exception to this Trace class.
     *
     * @param level the level of trace information to be sent.
     * @param type the type of trace information to be sent.
     * @param className the name of the class from which the trace
     *        information is from.
     * @param methodName the name of the method from which the trace
     *        information is from.
     * @param exception exception sent as the trace information.
     */
    public boolean send(int level,
                        int type,
                        String className,
                        String methodName,
                        Throwable exception);

    /**
     * Reset the trace destination.
     * The behavior of this method is implementation dependent.
     * It could be used, for instance, to (re)initialize the traces
     * according to some default System properties, or to flush
     * (empty) the log file, etc...
     **/
    public void reset() throws IOException;
}
