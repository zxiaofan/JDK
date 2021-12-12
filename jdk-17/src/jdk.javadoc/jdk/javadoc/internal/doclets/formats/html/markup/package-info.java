/*
 * Copyright (c) 2007, 2018, Oracle and/or its affiliates. All rights reserved.
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

/**
 *  This package contains classes that create and write HTML markup tags.
 *
 *  <p>The primary low level classes are
 *  {@link jdk.javadoc.internal.doclets.formats.html.markup.HtmlTree HtmlTree}
 *  and other subtypes of {@code Content}. In addition, there are mid-level builders
 *  like {@link jdk.javadoc.internal.doclets.formats.html.TableHeader TableHeader}
 *  and {@link jdk.javadoc.internal.doclets.formats.html.Table Table}
 *  to help build more complex HTML trees.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @see <a href="https://html.spec.whatwg.org/multipage/">HTML: Living Standard</a>
 * @see <a href="https://html.spec.whatwg.org/multipage/syntax,html">HTML: Living Standard: The HTML Syntax</a>
 * @see <a href="https://www.w3.org/TR/html51/">HTML 5.1</a>
 */
package jdk.javadoc.internal.doclets.formats.html.markup;
