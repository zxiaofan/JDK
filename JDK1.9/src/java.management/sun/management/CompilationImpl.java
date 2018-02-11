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

import java.lang.management.CompilationMXBean;
import java.lang.management.ManagementFactory;
import javax.management.ObjectName;

/**
 * Implementation class for the compilation subsystem.
 * Standard and committed hotspot-specific metrics if any.
 *
 * ManagementFactory.getCompilationMXBean() returns an instance
 * of this class.
 */
class CompilationImpl implements CompilationMXBean {

    private final VMManagement jvm;
    private final String name;

    /**
     * Constructor of CompilationImpl class.
     */
    CompilationImpl(VMManagement vm) {
        this.jvm = vm;
        this.name = jvm.getCompilerName();
        if (name == null) {
            throw new AssertionError("Null compiler name");
        }
    }

    public java.lang.String getName() {
        return name;
    }

    public boolean isCompilationTimeMonitoringSupported() {
        return jvm.isCompilationTimeMonitoringSupported();
    }

    public long getTotalCompilationTime() {
        if (!isCompilationTimeMonitoringSupported()) {
            throw new UnsupportedOperationException(
                "Compilation time monitoring is not supported.");
        }

        return jvm.getTotalCompileTime();
    }

    public ObjectName getObjectName() {
        return Util.newObjectName(ManagementFactory.COMPILATION_MXBEAN_NAME);
    }


}
