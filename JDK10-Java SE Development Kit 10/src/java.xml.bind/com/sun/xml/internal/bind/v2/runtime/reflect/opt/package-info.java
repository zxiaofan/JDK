/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 * Hosts optimized
 * {@link com.sun.xml.internal.bind.v2.runtime.reflect.Accessor},
 * {@link com.sun.xml.internal.bind.v2.runtime.reflect.TransducedAccessor}, and {@link com.sun.xml.internal.bind.v2.runtime.Transducer}.
 *
 * <h2>How it works</h2>
 * <p>
 * Most of the classes in this package are "templates." At run-time, A template class file is slightly modified to match
 * the target Java Bean, then it will be loaded into the VM.
 */
package com.sun.xml.internal.bind.v2.runtime.reflect.opt;
