/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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
    Contains the base classes that make up a doclet.  Doclets that reuse
    the functionality provided by the toolkit should have the following
    characteristics:
    <ul>
        <li>
            The main driver class should extend
            {@link com.sun.tools.doclets.internal.toolkit.AbstractDoclet}.
        </li>
        <li>
            The doclet configuration class should extend
            {@link com.sun.tools.doclets.internal.toolkit.Configuration}.
        </li>
        <li>
            The doclet should have a writer factory that implements
            {@link com.sun.tools.doclets.internal.toolkit.WriterFactory}.
            This class constructs writers that write doclet specific output.
        </li>
        <li>
            The doclet should have a taglet writer that extends
            {@link com.sun.tools.doclets.internal.toolkit.taglets.TagletWriter}.
             This writer determines how to output each given tag.
        </li>
    </ul>

    <p><b>This is NOT part of any supported API.
    If you write code that depends on this, you do so at your own risk.
    This code and its internal interfaces are subject to change or
    deletion without notice.</b>
*/

package com.sun.tools.doclets.internal.toolkit;
