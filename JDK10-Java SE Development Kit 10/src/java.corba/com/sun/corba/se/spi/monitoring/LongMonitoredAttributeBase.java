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

import java.util.*;

/**
 * @author Hemanth Puttaswamy
 *
 * A Cleaner Abstraction to provide a Monitored Attribute of type 'Long'
 */
public abstract class LongMonitoredAttributeBase extends MonitoredAttributeBase {

  ///////////////////////////////////////
  // operations


/**
 * Constructs LongMonitoredAttribute, by creating the
 * MonitoredAttributeInfo with 'Long' as the class type.
 * Users are expected to extend this class and provide the implementation
 * for getValue() and if needed clearState() as well.
 *
 * @param name of the MonitoredAttribute
 * @param description of the Attribute, Please provid a well thought out
 * description, so that the admin can make sense of the attribute supplied.
 */
    public  LongMonitoredAttributeBase(String name, String description) {
        super( name );
        MonitoredAttributeInfoFactory f =
            MonitoringFactories.getMonitoredAttributeInfoFactory();
        MonitoredAttributeInfo maInfo = f.createMonitoredAttributeInfo(
                description, Long.class, false, false );
        this.setMonitoredAttributeInfo( maInfo );
    } // end LongMonitoredAttributeBase


} // end LongMonitoredAttributeBase
