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

import javax.management.ObjectName;
import javax.management.remote.JMXServiceURL;

/**
    MBean responsible for booting the AMX system.
    To get its ObjectName, use {@link AMXGlassfish#getBootAMXMBeanObjectName}.
 */
@com.sun.org.glassfish.external.arc.Taxonomy(stability = com.sun.org.glassfish.external.arc.Stability.UNCOMMITTED)
public interface BootAMXMBean
{
    /**
    Start AMX and return the ObjectName of DomainRoot.
     */
    public ObjectName bootAMX();

    /** same as method above */
    public static final String BOOT_AMX_OPERATION_NAME = "bootAMX";

    public JMXServiceURL[] getJMXServiceURLs();
}
