/*
 * Copyright (c) 2013, 2021, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public interface JavaUtilZipFileAccess {
    public boolean startsWithLocHeader(ZipFile zip);
    public List<String> getManifestAndSignatureRelatedFiles(JarFile zip);
    public String getManifestName(JarFile zip, boolean onlyIfSignatureRelatedFiles);
    public int getManifestNum(JarFile zip);
    public int[] getMetaInfVersions(JarFile zip);
    public Enumeration<JarEntry> entries(ZipFile zip);
    public Stream<JarEntry> stream(ZipFile zip);
    public Stream<String> entryNameStream(ZipFile zip);
    public void setExtraAttributes(ZipEntry ze, int extraAttrs);
    public int getExtraAttributes(ZipEntry ze);
}

