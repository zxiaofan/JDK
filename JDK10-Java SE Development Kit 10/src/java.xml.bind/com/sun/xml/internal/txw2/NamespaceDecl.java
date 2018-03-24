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
 * Namespace declarations.
 *
 * @author Kohsuke Kawaguchi
 */
final class NamespaceDecl {
    final String uri;

    boolean requirePrefix;

    /**
     * Dummy prefix assigned for this namespace decl.
     */
    final String dummyPrefix;

    final char uniqueId;

    /**
     * Set to the real prefix once that's computed.
     */
    String prefix;

    /**
     * Used temporarily inside {@link Document#finalizeStartTag()}.
     * true if this prefix is declared on the new element.
     */
    boolean declared;

    /**
     * Namespace declarations form a linked list.
     */
    NamespaceDecl next;

    NamespaceDecl(char uniqueId, String uri, String prefix, boolean requirePrefix ) {
        this.dummyPrefix = new StringBuilder(2).append(Document.MAGIC).append(uniqueId).toString();
        this.uri = uri;
        this.prefix = prefix;
        this.requirePrefix = requirePrefix;
        this.uniqueId = uniqueId;
    }
}
