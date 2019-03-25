/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/**
 * A compile chunk is a list of sources/packages to be compiled. Possibly a subset of
 * the total number of sources/packages to be compiled for this sjavac invocation.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class CompileChunk implements Comparable<CompileChunk> {
    public int numPackages;
    public int numDependents;
    public Set<URI> srcs = new HashSet<>();
    public StringBuilder pkgNames = new StringBuilder();
    public String pkgFromTos = "";

    public int compareTo(CompileChunk c) {
        if (numDependents == c.numDependents) return 0;
        if (numDependents > c.numDependents) return -1;
        return -1;
    }

    boolean equal(CompileChunk c) {
        return numDependents == c.numDependents;
    }
}
