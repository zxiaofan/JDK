/*
 * Copyright (c) 2003, 2008, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import javax.management.ObjectName;

/**
 * Implementation class for the class loading subsystem.
 * Standard and committed hotspot-specific metrics if any.
 *
 * ManagementFactory.getClassLoadingMXBean() returns an instance
 * of this class.
 */
class ClassLoadingImpl implements ClassLoadingMXBean {

    private final VMManagement jvm;

    /**
     * Constructor of ClassLoadingImpl class.
     */
    ClassLoadingImpl(VMManagement vm) {
        this.jvm = vm;
    }

    public long getTotalLoadedClassCount() {
        return jvm.getTotalClassCount();
    }

    public int getLoadedClassCount() {
        return jvm.getLoadedClassCount();
    }

    public long getUnloadedClassCount() {
        return jvm.getUnloadedClassCount();
    }

    public boolean isVerbose() {
        return jvm.getVerboseClass();
    }

    public void setVerbose(boolean value) {
        Util.checkControlAccess();

        setVerboseClass(value);
    }
    native static void setVerboseClass(boolean value);

    public ObjectName getObjectName() {
        return Util.newObjectName(ManagementFactory.CLASS_LOADING_MXBEAN_NAME);
    }
}
