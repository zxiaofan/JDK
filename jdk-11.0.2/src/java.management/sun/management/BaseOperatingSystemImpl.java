/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import javax.management.ObjectName;
import jdk.internal.misc.Unsafe;

/**
 * Implementation class for the operating system.
 * Standard and committed hotspot-specific metrics if any.
 *
 * ManagementFactory.getOperatingSystemMXBean() returns an instance
 * of this class.
 */
public class BaseOperatingSystemImpl implements OperatingSystemMXBean {

    private final VMManagement jvm;

    /**
     * Constructor of BaseOperatingSystemImpl class.
     */
    protected BaseOperatingSystemImpl(VMManagement vm) {
        this.jvm = vm;
    }

    public String getName() {
        return jvm.getOsName();
    }

    public String getArch() {
        return jvm.getOsArch();
    }

    public String getVersion() {
        return jvm.getOsVersion();
    }

    public int getAvailableProcessors() {
        return jvm.getAvailableProcessors();
    }

    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private double[] loadavg = new double[1];
    public double getSystemLoadAverage() {
        if (unsafe.getLoadAverage(loadavg, 1) == 1) {
             return loadavg[0];
        } else {
             return -1.0;
        }
    }
    public ObjectName getObjectName() {
        return Util.newObjectName(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME);
    }

}
