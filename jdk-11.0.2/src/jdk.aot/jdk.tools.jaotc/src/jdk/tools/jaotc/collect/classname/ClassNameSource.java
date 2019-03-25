/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 */

package jdk.tools.jaotc.collect.classname;

import jdk.tools.jaotc.collect.ClassSource;

import java.util.function.BiConsumer;

public final class ClassNameSource implements ClassSource {
    private final String name;
    private final ClassLoader classLoader;

    ClassNameSource(String name, ClassLoader classLoader) {
        this.name = name;
        this.classLoader = classLoader;
    }

    @Override
    public void eachClass(BiConsumer<String, ClassLoader> consumer) {
        consumer.accept(name, classLoader);
    }
}
