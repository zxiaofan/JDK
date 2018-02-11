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
 * Monitored AttributeInfo contains the meta information of the Monitored
 * Attribute.
 */
public interface MonitoredAttributeInfo {

  ///////////////////////////////////////
  // operations

/**
 * If the Attribute is writable from ASAdmin then isWritable() will return
 * true.
 *
 * @return a boolean with true or false
 */
    public boolean isWritable();
/**
 * isStatistic() is true if the attribute is presented as a Statistic.
 *
 * @return a boolean with true or false
 */
    public boolean isStatistic();
/**
 * Class Type: We will allow only basic class types:
 * <ol>
 * <li>Boolean</li>
 * <li>Integer</li>
 * <li>Byte</li>
 * <li>Long</li>
 * <li>Float</li>
 * <li>Double</li>
 * <li>String</li>
 * <li>Character</li>
 * </ol>
 *
 * @return a Class Type
 */
    public Class type();
/**
 * Get's the description for the Monitored Attribute.
 *
 * @return a String with description
 */
    public String getDescription();

} // end MonitoredAttributeInfo
