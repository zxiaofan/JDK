/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.code.site;

/**
 * A reason for infopoint insertion.
 */
public enum InfopointReason {

    SAFEPOINT,
    CALL,
    IMPLICIT_EXCEPTION,
    METHOD_START,
    METHOD_END,
    BYTECODE_POSITION;
}
