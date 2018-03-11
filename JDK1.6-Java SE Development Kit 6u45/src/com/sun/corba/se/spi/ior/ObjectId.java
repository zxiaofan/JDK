/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.corba.se.spi.ior;

/**
 * @author Ken Cavanaugh
 */
public interface ObjectId extends Writeable
{
    public byte[] getId() ;
}
