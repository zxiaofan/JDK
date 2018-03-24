/*
 * Copyright (c) 2010, 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.formats.html.markup;

/**
 *  Supported DOCTYPE declarations.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Bhavesh Patel
 */
public enum DocType {
    HTML4_TRANSITIONAL("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" "
            + "\"http://www.w3.org/TR/html4/loose.dtd\">"),
    HTML5("<!DOCTYPE HTML>");

    public final String text;

    DocType(String text) {
        this.text = text;
    }

    public static DocType forVersion(HtmlVersion v) {
        switch (v) {
            case HTML4: return HTML4_TRANSITIONAL;
            case HTML5: return HTML5;
            default: throw new IllegalArgumentException();
        }
    }
}
