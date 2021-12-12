/*
 *  Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
 *  ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
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
 *
 */

package jdk.internal.access.foreign;

import java.io.FileDescriptor;

/**
 * This proxy interface is required to allow instances of the {@code FileChannelImpl.Unmapper} interface (which is a non-public class
 * inside the {@code sun.nio.ch} package) to be accessed from the mapped memory segment factory.
 */
public interface UnmapperProxy {
    long address();
    FileDescriptor fileDescriptor();
    boolean isSync();
    void unmap();
}
