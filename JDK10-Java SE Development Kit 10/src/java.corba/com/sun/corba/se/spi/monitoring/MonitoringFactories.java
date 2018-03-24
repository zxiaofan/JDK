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

import com.sun.corba.se.impl.monitoring.MonitoredObjectFactoryImpl;
import com.sun.corba.se.impl.monitoring.MonitoredAttributeInfoFactoryImpl;
import com.sun.corba.se.impl.monitoring.MonitoringManagerFactoryImpl;

/**
 * @author Hemanth Puttaswamy
 *
 *  This is used for getting the default factories for
 *  MonitoredObject, MonitoredAttributeInfo and MonitoringManager. We do not
 *  expect users to use the MonitoredAttributeInfo factory most of the time
 *  because the Info is automatically built by StringMonitoredAttributeBase
 *  and LongMonitoredAttributeBase.
 */
public class MonitoringFactories {
    ///////////////////////////////////////
    // attributes
    private static final MonitoredObjectFactoryImpl monitoredObjectFactory =
        new MonitoredObjectFactoryImpl( );
    private static final MonitoredAttributeInfoFactoryImpl
        monitoredAttributeInfoFactory =
        new MonitoredAttributeInfoFactoryImpl( );
    private static final MonitoringManagerFactoryImpl monitoringManagerFactory =
        new MonitoringManagerFactoryImpl( );


    ///////////////////////////////////////
    // operations

/**
 * Gets the MonitoredObjectFactory
 *
 * @return a MonitoredObjectFactory
 */
    public static MonitoredObjectFactory getMonitoredObjectFactory( ) {
        return monitoredObjectFactory;
    }

/**
 * Gets the MonitoredAttributeInfoFactory. The user is not expected to use this
 * Factory, since the MonitoredAttributeInfo is internally created by
 * StringMonitoredAttributeBase, LongMonitoredAttributeBase and
 * StatisticMonitoredAttribute. If User wants to create a MonitoredAttribute
 * of some other special type like a DoubleMonitoredAttribute, they can
 * build a DoubleMonitoredAttributeBase like LongMonitoredAttributeBase
 * and build a MonitoredAttributeInfo required by MonitoredAttributeBase
 * internally by using this Factory.
 *
 * @return a MonitoredAttributeInfoFactory
 */
    public static MonitoredAttributeInfoFactory
        getMonitoredAttributeInfoFactory( )
    {
        return monitoredAttributeInfoFactory;
    }

/**
 * Gets the MonitoredManagerFactory. The user is not expected to use this
 * Factory, since the ORB will be automatically initialized with the
 * MonitoringManager.
 *
 * User can get hold of MonitoringManager associated with ORB by calling
 * orb.getMonitoringManager( )
 *
 * @return a MonitoredManagerFactory
 */
    public static MonitoringManagerFactory getMonitoringManagerFactory( ) {
        return monitoringManagerFactory;
    }
}
