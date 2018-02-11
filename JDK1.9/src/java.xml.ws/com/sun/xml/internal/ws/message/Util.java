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

package com.sun.xml.internal.ws.message;

import com.sun.xml.internal.ws.api.message.Message;

/**
 * Utility code for the {@link Message} implementation.
 */
public abstract class Util {
    /**
     * Parses a stringthat represents a boolean into boolean.
     * This method assumes that the whilespace normalization has already taken place.
     *
     * @param value
     */
    public static boolean parseBool(String value) {
        if(value.length()==0)
            return false;

        char ch = value.charAt(0);
        return ch=='t' || ch=='1';
    }

}
