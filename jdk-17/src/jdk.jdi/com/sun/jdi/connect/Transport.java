/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi.connect;

import com.sun.jdi.connect.spi.TransportService;

/**
 * A method of communication between a debugger and a target VM.
 *
 * <p> A Transport represents the transport mechanism used by a
 * {@link Connector Connector} to establish a connection with a
 * target VM. It consists of a name which is obtained by invoking
 * the {@link #name} method. Furthermore, a Transport encapsulates a
 * {@link TransportService TransportService} which is the underlying
 * service used to establish connections and exchange
 * Java Debug Wire Protocol (JDWP) packets with a target VM.
 *
 * @author Gordon Hirsch
 * @since  1.3
 */
public interface Transport {

    /**
     * Returns a short identifier for the transport.
     *
     * @return the name of this transport.
     */
    String name();
}
