/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.corba.se.spi.monitoring;

/**
 * @author Hemanth Puttaswamy
 *
 * MonitoredObject Factory to create Monitored Object.
 */
public interface MonitoredObjectFactory {
    /**
     *  A Simple Factory Method to create the Monitored Object. The name
     *  should be the leaf level name.
     */
    MonitoredObject createMonitoredObject( String name, String description );
}
