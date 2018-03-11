/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.corba.se.spi.legacy.connection;

/**
 * This interface represents the connection on which a request is made.
 */

public interface Connection
{
    public java.net.Socket getSocket();
}
