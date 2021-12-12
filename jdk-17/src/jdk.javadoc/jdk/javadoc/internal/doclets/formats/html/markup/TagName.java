/*
 * Copyright (c) 2010, 2021, Oracle and/or its affiliates. All rights reserved.
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

import jdk.javadoc.internal.doclets.toolkit.util.Utils;

/**
 * Enum representing the names for HTML elements.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @see <a href="https://html.spec.whatwg.org/multipage/syntax.html#syntax-tag-name">WhatWG: Tag Name</a>
 * @see <a href="https://www.w3.org/TR/html51/syntax.html#tag-name">HTML 5.1: Tag Name</a>
 */
public enum TagName {
    A,
    BUTTON,
    BLOCKQUOTE,
    BODY,
    BR,
    CAPTION,
    CODE,
    DD,
    DIV,
    DL,
    DT,
    EM,
    FOOTER,
    H1,
    H2,
    H3,
    H4,
    H5,
    H6,
    HEAD,
    HEADER,
    HR,
    HTML,
    I,
    IMG,
    INPUT,
    LABEL,
    LI,
    LISTING,
    LINK,
    MAIN,
    MENU,
    META,
    NAV,
    NOSCRIPT,
    OL,
    P,
    PRE,
    SCRIPT,
    SECTION,
    SMALL,
    SPAN,
    STRONG,
    SUB,
    SUP,
    TABLE,
    TBODY,
    THEAD,
    TD,
    TH,
    TITLE,
    TR,
    UL,
    WBR;

    public final String value;

    TagName() {
        this.value = Utils.toLowerCase(name());
    }

    public String toString() {
        return value;
    }
}
