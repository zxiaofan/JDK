/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.jmx.remote.util;

public class OrderClassLoaders extends ClassLoader {
    public OrderClassLoaders(ClassLoader cl1, ClassLoader cl2) {
	super(cl1);

	this.cl2 = cl2;
    }

    protected Class findClass(String name) throws ClassNotFoundException {
	try {
	    return super.findClass(name);
	} catch (ClassNotFoundException cne) {
	    if (cl2 != null) {
		return cl2.loadClass(name);
	    } else {
		throw cne;
	    }
	}
    }

    private ClassLoader cl2;
}
