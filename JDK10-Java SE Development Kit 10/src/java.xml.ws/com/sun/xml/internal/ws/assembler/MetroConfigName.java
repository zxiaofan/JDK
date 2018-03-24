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

package com.sun.xml.internal.ws.assembler;

/**
 * This interface is used to get the file name used for the metro configuration file.
 * This allows multiple configurations of metro in a single VM.
 *
 * @author Bob Naugle
 */
public interface MetroConfigName {
    public String getDefaultFileName();

    public String getAppFileName();

}
