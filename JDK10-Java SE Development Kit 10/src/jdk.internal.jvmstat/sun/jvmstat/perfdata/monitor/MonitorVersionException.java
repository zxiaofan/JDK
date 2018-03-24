/*
 * Copyright (c) 2004, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvmstat.perfdata.monitor;

import sun.jvmstat.monitor.MonitorException;

/**
 * Exception thrown when version of the implementation does not
 * match the version of the instrumentation exported by a target
 * Java Virtual Machine.
 *
 * @author Brian Doherty
 * @since 1.5
 */
@SuppressWarnings("serial") // JDK implementation class
public class MonitorVersionException extends MonitorException {

    /**
     * Create a MonitorVersionException
     */
    public MonitorVersionException() {
        super();
    }

    /**
     * Create a MonitorVersionException with the given message.
     *
     * @param message the message to associate with the exception.
     */
    public MonitorVersionException(String message) {
        super(message);
    }
}
