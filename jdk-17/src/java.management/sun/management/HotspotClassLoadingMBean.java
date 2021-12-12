/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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
import sun.management.counter.Counter;

/**
 * Hotspot internal management interface for the class loading system.
 *
 * This management interface is internal and uncommitted
 * and subject to change without notice.
 */
public interface HotspotClassLoadingMBean {
    /**
     * Returns the amount of memory in bytes occupied by loaded classes
     * in the Java virtual machine.
     *
     * @return the amount of memory in bytes occupied by loaded classes
     * in the Java virtual machine.
     */
    public long getLoadedClassSize();

    /**
     * Returns the number of bytes that the Java virtual machine
     * collected due to class unloading.
     *
     * @return the number of bytes that the VM collected due to
     * class unloading.
     */
    public long getUnloadedClassSize();

    /**
     * Returns the accumulated elapsed time spent by class loading
     * in milliseconds.
     *
     * @return the accumulated elapsed time spent by class loading
     * in milliseconds.
     */
    public long getClassLoadingTime();

    /**
     * Returns the amount of memory in bytes occupied by the method
     * data.
     *
     * @return the amount of memory in bytes occupied by the method
     * data.
     */
    public long getMethodDataSize();

    /**
     * Returns the number of classes for which initializers were run.
     *
     * @return the number of classes for which initializers were run.
     */
    public long getInitializedClassCount();

    /**
     * Returns the accumulated elapsed time spent in class initializers
     * in milliseconds.
     *
     * @return the accumulated elapsed time spent in class initializers
     * in milliseconds.
     */
    public long getClassInitializationTime();

    /**
     * Returns the accumulated elapsed time spent in class verifier
     * in milliseconds.
     *
     * @return the accumulated elapsed time spent in class verifier
     * in milliseconds.
     */
    public long getClassVerificationTime();

    /**
     * Returns a list of internal counters maintained in the Java
     * virtual machine for the class loading system.
     *
     * @return a list of internal counters maintained in the VM
     * for the class loading system.
     */
    public java.util.List<Counter> getInternalClassLoadingCounters();

}
