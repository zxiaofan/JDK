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

/**
 * JAX-WS RI extension of JAX-WS API.
 *
 * <p>
 * This package hosts classes/interfaces that directly extend
 * the JAX-WS API. Sometimes objects of these types are passed
 * to external components from higher layers, only to be passed
 * back into other parts of the JAX-WS RI.
 * By defining these types, we improve the type-safety in
 * this scenario, while isolating the actual implementation classes.
 *
 * <p>
 * Sometimes these types also define additional methods.
 *
 * <p>
 * Types defined in package can only be implemented by the JAX-WS RI.
 * The code internal to the JAX-WS RI may safely case instances
 * of these types to their implementation classes. This warning doesn't
 * apply to subpackages.
 */
package com.sun.xml.internal.ws.api;
