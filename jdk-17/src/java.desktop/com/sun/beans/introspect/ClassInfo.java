/*
 * Copyright (c) 2014, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.beans.introspect;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.sun.beans.util.Cache;

import static sun.reflect.misc.ReflectUtil.checkPackageAccess;

public final class ClassInfo {
    private static final ClassInfo DEFAULT = new ClassInfo(null);
    private static final Cache<Class<?>,ClassInfo> CACHE
            = new Cache<Class<?>,ClassInfo>(Cache.Kind.SOFT, Cache.Kind.SOFT) {
        @Override
        public ClassInfo create(Class<?> type) {
            return new ClassInfo(type);
        }
    };

    public static ClassInfo get(Class<?> type) {
        if (type == null) {
            return DEFAULT;
        }
        try {
            checkPackageAccess(type);
            return CACHE.get(type);
        } catch (SecurityException exception) {
            return DEFAULT;
        }
    }

    public static void clear() {
        CACHE.clear();
    }

    public static void remove(Class<?> clz) {
        CACHE.remove(clz);
    }

    private final Object mutex = new Object();
    private final Class<?> type;
    private List<Method> methods;
    private Map<String,PropertyInfo> properties;
    private Map<String,EventSetInfo> eventSets;

    private ClassInfo(Class<?> type) {
        this.type = type;
    }

    public List<Method> getMethods() {
        if (this.methods == null) {
            synchronized (this.mutex) {
                if (this.methods == null) {
                    this.methods = MethodInfo.get(this.type);
                }
            }
        }
        return this.methods;
    }

    public Map<String,PropertyInfo> getProperties() {
        if (this.properties == null) {
            synchronized (this.mutex) {
                if (this.properties == null) {
                    this.properties = PropertyInfo.get(this.type);
                }
            }
        }
        return this.properties;
    }

    public Map<String,EventSetInfo> getEventSets() {
        if (this.eventSets == null) {
            synchronized (this.mutex) {
                if (this.eventSets == null) {
                    this.eventSets = EventSetInfo.get(this.type);
                }
            }
        }
        return this.eventSets;
    }
}
