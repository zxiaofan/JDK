/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.corba.se.internal.io;

public class ObjectStreamClass {

    /* Find out if the class has a static class initializer <clinit> */
    private static native boolean hasStaticInitializer(Class cl);

}
