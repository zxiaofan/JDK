/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.org.apache.xerces.internal.util;

public class PropertyState {

    public final Status status;
    public final Object state;

    public static final PropertyState UNKNOWN = new PropertyState(Status.UNKNOWN, null);
    public static final PropertyState RECOGNIZED = new PropertyState(Status.RECOGNIZED, null);
    public static final PropertyState NOT_SUPPORTED = new PropertyState(Status.NOT_SUPPORTED, null);
    public static final PropertyState NOT_RECOGNIZED = new PropertyState(Status.NOT_RECOGNIZED, null);
    public static final PropertyState NOT_ALLOWED = new PropertyState(Status.NOT_ALLOWED, null);


    public PropertyState(Status status, Object state) {
        this.status = status;
        this.state = state;
    }

    public static PropertyState of(Status status) {
        return new PropertyState(status, null);
    }

    public static PropertyState is(Object value) {
        return new PropertyState(Status.SET, value);
    }

    public boolean isExceptional() {
        return this.status.isExceptional();
    }
}
