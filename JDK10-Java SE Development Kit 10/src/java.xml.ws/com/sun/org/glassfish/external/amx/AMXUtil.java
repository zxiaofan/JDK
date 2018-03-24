/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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


package com.sun.org.glassfish.external.amx;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

/**
    Small utilities for AMXBooter and related.
 */
@com.sun.org.glassfish.external.arc.Taxonomy(stability = com.sun.org.glassfish.external.arc.Stability.UNCOMMITTED)
public final class AMXUtil
{
    private AMXUtil() {}

    /**
        Make a new ObjectName (unchecked exception).
     */
    public static ObjectName newObjectName(final String s)
    {
        try
        {
            return new ObjectName( s );
        }
        catch( final Exception e )
        {
            throw new RuntimeException("bad ObjectName", e);
        }
    }

    /**
        Make a new ObjectName (unchecked exception).
        @param domain
        @param props
     */
    public static ObjectName newObjectName(
            final String domain,
            final String props)
    {
        return newObjectName(domain + ":" + props);
    }

    /**
        Get the ObjectName of the MBeanServerDelegateObjectName.
     */
    public static ObjectName getMBeanServerDelegateObjectName()
    {
        return newObjectName( "JMImplementation:type=MBeanServerDelegate" );
    }

    public static String prop(final String key, final String value)
    {
        return key + "=" + value;
    }
}
