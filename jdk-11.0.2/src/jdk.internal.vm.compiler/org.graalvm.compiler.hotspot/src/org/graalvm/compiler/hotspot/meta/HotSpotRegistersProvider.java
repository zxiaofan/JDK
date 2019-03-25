/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.hotspot.meta;

import jdk.vm.ci.code.Register;

/**
 * Special registers reserved by HotSpot for frequently used values.
 */
public interface HotSpotRegistersProvider {

    /**
     * Gets the register holding the current thread.
     */
    Register getThreadRegister();

    /**
     * Gets the register holding the heap base address for compressed pointers.
     */
    Register getHeapBaseRegister();

    /**
     * Gets the stack pointer register.
     */
    Register getStackPointerRegister();
}
