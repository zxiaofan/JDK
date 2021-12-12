/*
 * Copyright (c) 2014, 2021, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.comp;

import javax.tools.ForwardingJavaFileObject;
import javax.tools.JavaFileManager.Location;
import javax.tools.JavaFileObject;

import com.sun.tools.javac.api.ClientCodeWrapper.Trusted;

@Trusted
public class JavaFileObjectWithLocation<F extends JavaFileObject> extends ForwardingJavaFileObject<F> {

    private final Location loc;

    public JavaFileObjectWithLocation(F delegate, Location loc) {
        super(delegate);
        this.loc = loc;
    }

    public Location getLocation() {
        return loc;
    }

    public F getDelegate() {
        return fileObject;
    }

    public String toString() {
        return "JavaFileObjectWithLocation[loc: " + loc + ", " + fileObject + "]";
    }

    @Override
    public int hashCode() {
        return loc.hashCode() ^ fileObject.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof JavaFileObjectWithLocation<?> javaFileObjectWithLocation)
                && loc.equals(javaFileObjectWithLocation.loc)
                && fileObject.equals(javaFileObjectWithLocation.fileObject);
    }
}
