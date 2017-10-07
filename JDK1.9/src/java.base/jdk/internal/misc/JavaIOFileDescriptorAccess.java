/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.misc;

import java.io.FileDescriptor;

/*
 * @author Chris Hegarty
 */

public interface JavaIOFileDescriptorAccess {
    public void set(FileDescriptor obj, int fd);
    public int get(FileDescriptor fd);
    public void setAppend(FileDescriptor obj, boolean append);
    public boolean getAppend(FileDescriptor obj);

    // Only valid on Windows
    public void setHandle(FileDescriptor obj, long handle);
    public long getHandle(FileDescriptor obj);
}
