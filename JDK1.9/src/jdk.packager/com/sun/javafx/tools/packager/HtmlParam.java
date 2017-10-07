/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tools.packager;


public class HtmlParam extends Param {
    boolean needEscape = true;

    //html parameters could be strings
    // or references to the code
    // In later case we should not escape them
    public void setEscape(String v) {
        needEscape = !"false".equals(v);
    }
}
