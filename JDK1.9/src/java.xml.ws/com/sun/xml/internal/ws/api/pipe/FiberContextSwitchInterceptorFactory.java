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

package com.sun.xml.internal.ws.api.pipe;

/**
 * Factory for (@link FiberContextSwitchInterceptor} instances
 *
 * @since 2.2.6
 */
public interface FiberContextSwitchInterceptorFactory {
        /**
         * Creates {@link FiberContextSwitchInterceptor} instance.
         * @return interceptor instance
         */
        public FiberContextSwitchInterceptor create();
}
