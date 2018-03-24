/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclint;

/**
 * Enum representing HTML version of the documentation comment.
 *
 * @author Bhavesh Patel
 */
public enum HtmlVersion {

    HTML4,
    HTML5,
    ALL;

    public static HtmlVersion getHtmlVersion(String argsVersion) {
        switch (argsVersion) {
            case "html4":
                return HtmlVersion.HTML4;
            case "html5":
                return HtmlVersion.HTML5;
            default:
                return null;
        }
    }
}
