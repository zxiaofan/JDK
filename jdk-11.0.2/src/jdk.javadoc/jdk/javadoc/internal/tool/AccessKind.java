/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.tool;

/**
 * The access value kinds.
 */

public enum AccessKind {
    /** Limits access to public entities */
    PUBLIC,
    /** Limits access to public and protected entities */
    PROTECTED,
    /** Limits access to public, protected and package private entities */
    PACKAGE,
    /** No limits */
    PRIVATE;
}
