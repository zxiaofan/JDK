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

import com.sun.corba.se.spi.monitoring.MonitoredAttributeInfo;
import java.util.*;

/**
 * @author Hemanth Puttaswamy
 *
 * Monitored Attribute is the interface to represent a Monitorable
 * Attribute. Using this interface, one can get the value of the attribute
 * and set the value if it is a writeable attribute.
 */
public interface MonitoredAttribute {

  ///////////////////////////////////////
  // operations

/**
 * Gets the Monitored Attribute Info for the attribute.
 *
 * @return monitoredAttributeInfo for this Monitored Attribute.
 */
    public MonitoredAttributeInfo getAttributeInfo();
/**
 * Sets the value for the Monitored Attribute if isWritable() is false, the
 * method will throw ILLEGAL Operation exception.
 *
 * Also, the type of 'value' should be same as specified in the
 * MonitoredAttributeInfo for a particular instance.
 *
 * @param value should be any one of the Basic Java Type Objects which are
 * Long, Double, Float, String, Integer, Short, Character, Byte.
 */
    public void setValue(Object value);


/**
 * Gets the value of the Monitored Attribute. The value can be obtained
 * from different parts of the module. User may choose to delegate the call
 * to getValue() to other variables.
 *
 * NOTE: It is important to make sure that the type of Object returned in
 * getvalue is same as the one specified in MonitoredAttributeInfo for this
 * attribute.
 *
 * @return the current value for this MonitoredAttribute
 */
    public Object getValue();
/**
 * Gets the name of the Monitored Attribute.
 *
 * @return name of this Attribute
 */
    public String getName();
/**
 * If this attribute needs to be cleared, the user needs to implement this
 * method to reset the state to initial state. If the Monitored Attribute
 * doesn't change like for example (ConnectionManager High Water Mark),
 * then clearState() is a No Op.
 */
    public void clearState();

} // end MonitoredAttribute
