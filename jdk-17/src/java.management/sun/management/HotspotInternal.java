/*
 * Copyright (c) 2004, 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.management;

import javax.management.MBeanRegistration;
import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * Implementation class of HotspotInternalMBean interface.
 *
 * <p> This is designed for internal customer use to create
 * this MBean dynamically from an agent which will then register
 * all internal MBeans to the platform MBeanServer.
 */
public class HotspotInternal
    implements HotspotInternalMBean, MBeanRegistration {

    private static final String HOTSPOT_INTERNAL_MBEAN_NAME =
        "sun.management:type=HotspotInternal";
    private static ObjectName objName = Util.newObjectName(HOTSPOT_INTERNAL_MBEAN_NAME);
    private MBeanServer server = null;

    /**
     * Default constructor that registers all hotspot internal MBeans
     * to the MBeanServer that creates this MBean.
     */
    public HotspotInternal() {
    }

    public ObjectName preRegister(MBeanServer server,
                                  ObjectName name) throws java.lang.Exception {
        // register all internal MBeans when this MBean is instantiated
        // and to be registered in a MBeanServer.
        ManagementFactoryHelper.registerInternalMBeans(server);
        this.server = server;
        return objName;
    }

    public void postRegister(Boolean registrationDone) {};

    public void preDeregister() throws java.lang.Exception {
        // unregister all internal MBeans when this MBean is unregistered.
        ManagementFactoryHelper.unregisterInternalMBeans(server);
    }

    public void postDeregister() {};

}
