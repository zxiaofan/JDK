/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.util.zip.ZipFile;

public interface JavaUtilZipFileAccess {
    public boolean startsWithLocHeader(ZipFile zip);
    public String[] getMetaInfEntryNames(ZipFile zip);
}

