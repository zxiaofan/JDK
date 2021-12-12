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

package com.sun.management;

/**
 * Platform-specific management interface for the Unix
 * operating system on which the Java virtual machine is running.
 *
 * @author  Mandy Chung
 * @since   1.5
 */
public interface UnixOperatingSystemMXBean extends
    com.sun.management.OperatingSystemMXBean {

    /**
     * Returns the number of open file descriptors.
     *
     * @return the number of open file descriptors.
     */
    public long getOpenFileDescriptorCount();

    /**
     * Returns the maximum number of file descriptors.
     *
     * @return the maximum number of file descriptors.
     */
    public long getMaxFileDescriptorCount();
}
