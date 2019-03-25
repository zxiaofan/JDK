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

/**
 * A utility class used to report information about the system
 * where the javac server is running.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own
 * risk.  This code and its internal interfaces are subject to change
 * or deletion without notice.</b></p>
 */
package com.sun.tools.sjavac.server;

import java.io.Serializable;

/**
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class SysInfo implements Serializable {

    static final long serialVersionUID = -3096346807579L;

    public int numCores;
    public long maxMemory;

    public SysInfo(int nc, long mm) {
        numCores = nc;
        maxMemory = mm;
    }
}
