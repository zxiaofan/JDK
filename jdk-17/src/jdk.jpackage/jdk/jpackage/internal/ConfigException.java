/*
 * Copyright (c) 2012, 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jpackage.internal;

public class ConfigException extends Exception {
    private static final long serialVersionUID = 1L;
    final String advice;

    public ConfigException(String msg, String advice) {
        super(msg);
        this.advice = advice;
    }

    public ConfigException(String msg, String advice, Exception cause) {
        super(msg, cause);
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
