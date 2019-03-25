/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.server;

import com.sun.tools.javac.main.Main.Result;

import java.io.Writer;


/**
 * Interface of the SjavacImpl, the sjavac client and all wrappers such as
 * PooledSjavac etc.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public interface Sjavac {
    Result compile(String[] args);
    void shutdown();
}
