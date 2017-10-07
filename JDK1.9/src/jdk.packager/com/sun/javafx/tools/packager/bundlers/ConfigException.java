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

package com.sun.javafx.tools.packager.bundlers;

public class ConfigException extends com.oracle.tools.packager.ConfigException {

    public ConfigException(String msg, String advice) {
        super(msg, advice);
    }

    public ConfigException(Exception cause) {
        super(cause);
    }
}
