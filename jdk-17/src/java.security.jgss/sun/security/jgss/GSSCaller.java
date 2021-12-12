/*
 * Copyright (c) 2009, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.jgss;

/**
 * Denotes what client is calling the JGSS-API. The object can be sent deep
 * into the mechanism level so that special actions can be performed for
 * different callers.
 */
public class GSSCaller {
    public static final GSSCaller CALLER_UNKNOWN = new GSSCaller("UNKNOWN");
    public static final GSSCaller CALLER_INITIATE = new GSSCaller("INITIATE");
    public static final GSSCaller CALLER_ACCEPT = new GSSCaller("ACCEPT");

    private String name;
    GSSCaller(String s) {
        name = s;
    }
    @Override
    public String toString() {
        return "GSSCaller{" + name + '}';
    }
}

