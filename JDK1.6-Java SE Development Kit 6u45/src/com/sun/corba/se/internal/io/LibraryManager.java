/*
 * @(#)LibraryManager.java	1.30 01/12/03
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * Licensed Materials - Property of IBM
 * RMI-IIOP v1.0
 * Copyright IBM Corp. 1998 1999  All Rights Reserved
 *
 * US Government Users Restricted Rights - Use, duplication or
 * disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 */

package com.sun.corba.se.internal.io;

public class LibraryManager
{
    native private static int getMajorVersion();

    native private static int getMinorVersion();

    private static native boolean setEnableOverride(Class targetClass, Object instance);
}
