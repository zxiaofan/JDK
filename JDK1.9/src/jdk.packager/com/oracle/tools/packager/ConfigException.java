/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.oracle.tools.packager;

public class ConfigException extends Exception {
    final String advice;

    public ConfigException(String msg, String advice) {
        super(msg);
        this.advice = advice;
    }

    public ConfigException(Exception cause) {
        super(cause);
        this.advice = null;
    }

    public String getAdvice() {
        return advice;
    }
}
