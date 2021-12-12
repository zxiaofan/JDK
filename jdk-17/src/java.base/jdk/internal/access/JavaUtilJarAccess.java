/*
 * Copyright (c) 2002, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public interface JavaUtilJarAccess {
    public boolean jarFileHasClassPathAttribute(JarFile jar) throws IOException;
    public CodeSource[] getCodeSources(JarFile jar, URL url);
    public CodeSource getCodeSource(JarFile jar, URL url, String name);
    public Enumeration<String> entryNames(JarFile jar, CodeSource[] cs);
    public Enumeration<JarEntry> entries2(JarFile jar);
    public void setEagerValidation(JarFile jar, boolean eager);
    public List<Object> getManifestDigests(JarFile jar);
    public Attributes getTrustedAttributes(Manifest man, String name);
    public void ensureInitialization(JarFile jar);
    public boolean isInitializing();
    public JarEntry entryFor(JarFile file, String name);
}
