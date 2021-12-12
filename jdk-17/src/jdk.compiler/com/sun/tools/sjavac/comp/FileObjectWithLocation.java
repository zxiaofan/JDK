/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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

import javax.tools.FileObject;
import javax.tools.ForwardingFileObject;
import javax.tools.JavaFileManager.Location;

import com.sun.tools.javac.api.ClientCodeWrapper.Trusted;

@Trusted
public class FileObjectWithLocation<F extends FileObject> extends ForwardingFileObject<F> {

    private final Location loc;

    public FileObjectWithLocation(F delegate, Location loc) {
        super(delegate);
        this.loc = loc;
    }

    public Location getLocation() {
        return loc;
    }

    public FileObject getDelegate() {
        return fileObject;
    }

    public String toString() {
        return "FileObjectWithLocation[" + fileObject + "]";
    }
}
