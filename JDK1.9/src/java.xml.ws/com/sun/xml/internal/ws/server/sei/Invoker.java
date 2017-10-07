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

package com.sun.xml.internal.ws.server.sei;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.message.Packet;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Hides the detail of calling into application implementations.
 *
 * @since 2.2.6
 */
public abstract class Invoker {
    /**
     * Wrapper for reflection invoke that allows containers to adapt
     */
    public abstract Object invoke( @NotNull Packet p, @NotNull Method m, @NotNull Object... args ) throws InvocationTargetException, IllegalAccessException;
}
