/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * <h1>Runtime API for the JAX-WS RI</h1>.
 *
 * This API is designed for the use by the JAX-WS RI runtime. The API is is subject to
 * change without notice.
 *
 * <p>
 * In an container environment, such as in J2SE/J2EE, if a new version with
 * a modified runtime API is loaded into a child class loader, it will still be bound
 * against the old runtime API in the base class loader.
 *
 * <p>
 * So the compatibility of this API has to be managed carefully.
 */
package com.sun.xml.internal.bind.api;
