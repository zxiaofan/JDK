/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.xsom;

import java.util.Iterator;
import java.util.Collection;

import com.sun.xml.internal.xsom.visitor.XSWildcardFunction;
import com.sun.xml.internal.xsom.visitor.XSWildcardVisitor;

/**
 * Wildcard schema component (used for both attribute wildcard
 * and element wildcard.)
 *
 * XSWildcard interface can always be downcasted to either
 * Any, Other, or Union.
 */
public interface XSWildcard extends XSComponent, XSTerm
{
    static final int LAX = 1;
    static final int STRTICT = 2;
    static final int SKIP = 3;
    /**
     * Gets the processing mode.
     *
     * @return
     *      Either LAX, STRICT, or SKIP.
     */
    int getMode();

    /**
     * Returns true if the specified namespace URI is valid
     * wrt this wildcard.
     *
     * @param namespaceURI
     *      Use the empty string to test the default no-namespace.
     */
    boolean acceptsNamespace(String namespaceURI);

    /** Visitor support. */
    void visit(XSWildcardVisitor visitor);
    <T> T apply(XSWildcardFunction<T> function);

    /**
     * <code>##any</code> wildcard.
     */
    interface Any extends XSWildcard {
    }
    /**
     * <code>##other</code> wildcard.
     */
    interface Other extends XSWildcard {
        /**
         * Gets the namespace URI excluded from this wildcard.
         */
        String getOtherNamespace();
    }
    /**
     * Wildcard of a set of namespace URIs.
     */
    interface Union extends XSWildcard {
        /**
         * Short for <code>getNamespaces().iterator()</code>
         */
        Iterator<String> iterateNamespaces();

        /**
         * Read-only list of namespace URIs.
         */
        Collection<String> getNamespaces();
    }
}
