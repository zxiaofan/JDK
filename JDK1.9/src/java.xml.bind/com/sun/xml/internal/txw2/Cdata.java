/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.txw2;

/**
 * CDATA section.
 *
 * @author Kohsuke Kawaguchi
 */
final class Cdata extends Text {
    Cdata(Document document, NamespaceResolver nsResolver, Object obj) {
        super(document, nsResolver, obj);
    }

    void accept(ContentVisitor visitor) {
        visitor.onCdata(buffer);
    }
}
