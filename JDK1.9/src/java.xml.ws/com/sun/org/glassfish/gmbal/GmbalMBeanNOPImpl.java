/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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


package com.sun.org.glassfish.gmbal;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.ReflectionException;

/** A simple no-op implementation of GmbalMBean for use in the no-op impl of
 * ManagedObjectManager.
 *
 * @author ken
 */
public class GmbalMBeanNOPImpl implements GmbalMBean {
    public Object getAttribute(String attribute)
        throws AttributeNotFoundException, MBeanException, ReflectionException {

        return null ;
    }

    public void setAttribute(Attribute attribute)
        throws AttributeNotFoundException, InvalidAttributeValueException,
            MBeanException, ReflectionException {

        // NO-OP
    }

    public AttributeList getAttributes(String[] attributes) {
        return null ;
    }

    public AttributeList setAttributes(AttributeList attributes) {
        return null ;
    }

    public Object invoke(String actionName, Object[] params, String[] signature)
        throws MBeanException, ReflectionException {

        return null ;
    }

    public MBeanInfo getMBeanInfo() {
        return null ;
    }

    public void removeNotificationListener(NotificationListener listener,
        NotificationFilter filter, Object handback)
        throws ListenerNotFoundException {

        // NO-OP
    }

    public void addNotificationListener(NotificationListener listener,
        NotificationFilter filter, Object handback) throws IllegalArgumentException {

        // NO-OP
    }

    public void removeNotificationListener(NotificationListener listener)
        throws ListenerNotFoundException {

        // NO-OP
    }

    public MBeanNotificationInfo[] getNotificationInfo() {
        return new MBeanNotificationInfo[0] ;
    }

}
