/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.spi;

import org.graalvm.compiler.core.common.LIRKind;

/**
 * This interface can be used to access platform and VM specific kinds.
 */
public interface LIRKindTool {

    /**
     * Get an architecture specific integer kind of a certain size.
     */
    LIRKind getIntegerKind(int bits);

    /**
     * Get an architecture specific floating point kind of a certain size.
     */
    LIRKind getFloatingKind(int bits);

    /**
     * Get the architecture specific kind used to represent Java objects.
     */
    LIRKind getObjectKind();

    /**
     * Get the architecture specific kind pointer-sized integer kind.
     */
    LIRKind getWordKind();

    /**
     * Get the platform specific kind used to represent compressed oops.
     */
    LIRKind getNarrowOopKind();

    /**
     * Gets the platform specific kind used to represent compressed metaspace pointers.
     */
    LIRKind getNarrowPointerKind();
}
