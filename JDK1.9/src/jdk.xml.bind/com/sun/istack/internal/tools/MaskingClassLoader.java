/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.istack.internal.tools;

import java.util.Collection;

/**
 * {@link ClassLoader} that masks a specified set of classes
 * from its parent class loader.
 *
 * <p>
 * This code is used to create an isolated environment.
 *
 * @author Kohsuke Kawaguchi
 */
public class MaskingClassLoader extends ClassLoader {

    private final String[] masks;

    public MaskingClassLoader(String... masks) {
        this.masks = masks;
    }

    public MaskingClassLoader(Collection<String> masks) {
        this(masks.toArray(new String[masks.size()]));
    }

    public MaskingClassLoader(ClassLoader parent, String... masks) {
        super(parent);
        this.masks = masks;
    }

    public MaskingClassLoader(ClassLoader parent, Collection<String> masks) {
        this(parent, masks.toArray(new String[masks.size()]));
    }

    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        for (String mask : masks) {
            if(name.startsWith(mask))
                throw new ClassNotFoundException();
        }

        return super.loadClass(name, resolve);
    }
}
