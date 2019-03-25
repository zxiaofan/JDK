/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.access;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public interface JavaIORandomAccessFileAccess {
    public RandomAccessFile openAndDelete(File file, String mode)
        throws IOException;
}
