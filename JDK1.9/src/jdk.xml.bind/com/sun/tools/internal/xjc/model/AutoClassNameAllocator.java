/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.model;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

import com.sun.tools.internal.xjc.api.ClassNameAllocator;

/**
 * {@link ClassNameAllocator} filter that performs automatic name conflict resolution.
 *
 * @author Kohsuke Kawaguchi
 */
public class AutoClassNameAllocator implements ClassNameAllocator {
    private final ClassNameAllocator core;

    private final Map<String,Set<String>> names = new HashMap<String,Set<String>>();

    public AutoClassNameAllocator(ClassNameAllocator core) {
        this.core = core;
    }

    public String assignClassName(String packageName, String className) {
        className = determineName(packageName, className);
        if(core!=null)
            className = core.assignClassName(packageName,className);
        return className;
    }

    private String determineName(String packageName, String className) {
        Set<String> s = names.get(packageName);
        if(s==null) {
            s = new HashSet<String>();
            names.put(packageName,s);
        }

        if(s.add(className))
            return className;

        for(int i=2;true;i++) {
            if(s.add(className+i))
                return className+i;
        }
    }
}
