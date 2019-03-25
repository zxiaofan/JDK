/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdeps;

import com.sun.tools.classfile.ClassFile;
import com.sun.tools.classfile.ConstantPoolException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class VersionHelper {
    private static final String META_INF_VERSIONS = "META-INF/versions/";
    private static final Map<String,String> nameToVersion = new ConcurrentHashMap<>();

    public static String get(String classname) {
        if (nameToVersion.containsKey(classname)) {
            return nameToVersion.get(classname) + "/" + classname;
        }
        return classname;
    }

    public static void add(JarFile jarfile, JarEntry e, ClassFile cf)
            throws ConstantPoolException
    {
        String realName = e.getRealName();
        if (realName.startsWith(META_INF_VERSIONS)) {
            int len = META_INF_VERSIONS.length();
            int n = realName.indexOf('/', len);
            if (n > 0) {
                String version = realName.substring(len, n);
                assert (Integer.parseInt(version) > 8);
                String name = cf.getName().replace('/', '.');
                if (nameToVersion.containsKey(name)) {
                    if (!version.equals(nameToVersion.get(name))) {
                        throw new MultiReleaseException(
                                "err.multirelease.version.associated",
                                name, nameToVersion.get(name), version
                        );
                    }
                } else {
                    nameToVersion.put(name, version);
                }
            } else {
                throw new MultiReleaseException("err.multirelease.jar.malformed",
                        jarfile.getName(), realName);
            }
        }
    }
}
