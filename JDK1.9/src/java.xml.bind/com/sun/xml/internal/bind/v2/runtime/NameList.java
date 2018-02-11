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

package com.sun.xml.internal.bind.v2.runtime;

/**
 * Namespace URIs and local names sorted by their indices.
 * Number of Names used for EIIs and AIIs
 *
 * @author Kohsuke Kawaguchi
 */
public final class NameList {
    /**
     * Namespace URIs by their indices. No nulls in this array.
     * Read-only.
     */
    public final String[] namespaceURIs;

    /**
     * For each entry in {@link #namespaceURIs}, whether the namespace URI
     * can be declared as the default. If namespace URI is used in attributes,
     * we always need a prefix, so we can't.
     *
     * True if this URI has to have a prefix.
     */
    public final boolean[] nsUriCannotBeDefaulted;

    /**
     * Local names by their indices. No nulls in this array.
     * Read-only.
     */
    public final String[] localNames;

    /**
     * Number of Names for elements
     */
    public final int numberOfElementNames;

    /**
     * Number of Names for attributes
     */
    public final int numberOfAttributeNames;

    public NameList(String[] namespaceURIs, boolean[] nsUriCannotBeDefaulted, String[] localNames, int numberElementNames, int numberAttributeNames) {
        this.namespaceURIs = namespaceURIs;
        this.nsUriCannotBeDefaulted = nsUriCannotBeDefaulted;
        this.localNames = localNames;
        this.numberOfElementNames = numberElementNames;
        this.numberOfAttributeNames = numberAttributeNames;
    }
}
