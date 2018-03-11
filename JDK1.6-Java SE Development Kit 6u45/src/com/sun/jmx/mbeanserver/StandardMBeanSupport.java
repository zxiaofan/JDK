/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.jmx.mbeanserver;

import static com.sun.jmx.mbeanserver.Util.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.Descriptor;
import javax.management.DynamicMBean;
import javax.management.ImmutableDescriptor;
import javax.management.InstanceAlreadyExistsException;
import javax.management.IntrospectionException;
import javax.management.InvalidAttributeValueException;
import javax.management.JMX;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.MBeanRegistration;
import javax.management.MBeanServer;
import javax.management.NotCompliantMBeanException;
import javax.management.NotificationBroadcaster;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.openmbean.OpenMBeanAttributeInfoSupport;
import javax.management.openmbean.OpenMBeanOperationInfoSupport;
import javax.management.openmbean.OpenMBeanParameterInfo;
import javax.management.openmbean.OpenMBeanParameterInfoSupport;
import javax.management.openmbean.OpenType;

/**
 * Base class for Standard MBeans.
 *
 * @since 1.6
 */
public class StandardMBeanSupport extends MBeanSupport<Method> {

    /**
       <p>Construct a Standard MBean that wraps the given resource using the
       given Standard MBean interface.</p>

       @param resource the underlying resource for the new MBean.

       @param mbeanInterface the interface to be used to determine
       the MBean's management interface.

       @param <T> a type parameter that allows the compiler to check
       that {@code resource} implements {@code mbeanInterface},
       provided that {@code mbeanInterface} is a class constant like
       {@code SomeMBean.class}.

       @throws IllegalArgumentException if {@code resource} is null or
       if it does not implement the class {@code mbeanInterface} or if
       that class is not a valid Standard MBean interface.
    */
    public <T> StandardMBeanSupport(T resource, Class<T> mbeanInterface)
            throws NotCompliantMBeanException {
        super(resource, mbeanInterface);
    }

    @Override
    MBeanIntrospector<Method> getMBeanIntrospector() {
	return StandardMBeanIntrospector.getInstance();
    }

    @Override
    Object getCookie() {
	return null;
    }
    
    @Override
    public void register(MBeanServer mbs, ObjectName name) {}
    
    @Override
    public void unregister() {}
 
    /* Standard MBeans that are NotificationBroadcasters can return a different
     * MBeanNotificationInfo[] every time getMBeanInfo() is called, so we have
     * to reconstruct this MBeanInfo if necessary.
     */
    @Override
    public MBeanInfo getMBeanInfo() {
        MBeanInfo mbi = super.getMBeanInfo();
        Class<?> resourceClass = getResource().getClass();
        if (StandardMBeanIntrospector.isDefinitelyImmutableInfo(resourceClass))
            return mbi;
        return new MBeanInfo(mbi.getClassName(), mbi.getDescription(),
                mbi.getAttributes(), mbi.getConstructors(),
                mbi.getOperations(),
                MBeanIntrospector.findNotifications(getResource()),
                mbi.getDescriptor());
    }
}
