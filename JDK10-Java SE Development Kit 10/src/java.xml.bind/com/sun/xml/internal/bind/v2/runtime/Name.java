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

import javax.xml.namespace.QName;

/**
 * The internal representation of an XML name.
 *
 * <p>
 * This class keeps indicies for URI and local name for enabling faster processing.
 *
 * <p>
 * {@link Name}s are ordered lexicographically (nsUri first, local name next.)
 * This is the same order required by canonical XML.
 *
 * @author Kohsuke Kawaguchi
 */
public final class Name implements Comparable<Name> {
    /**
     * Namespace URI. interned.
     */
    public final String nsUri;

    /**
     * Local name. interned.
     */
    public final String localName;

    /**
     * Index -1 is reserved for representing the empty namespace URI of attributes.
     */
    public final short nsUriIndex;
    public final short localNameIndex;

    /**
     * Index of the Name for an EII or AII
     */
    public final short qNameIndex;

    /**
     * Specifies if the Name is associated with an EII or AII
     */
    public final boolean isAttribute;

    Name(int qNameIndex, int nsUriIndex, String nsUri, int localIndex, String localName, boolean isAttribute) {
        this.qNameIndex = (short)qNameIndex;
        this.nsUri = nsUri;
        this.localName = localName;
        this.nsUriIndex = (short)nsUriIndex;
        this.localNameIndex = (short)localIndex;
        this.isAttribute = isAttribute;
    }

    public String toString() {
        return '{'+nsUri+'}'+localName;
    }

    /**
     * Creates a {@link QName} from this.
     */
    public QName toQName() {
        return new QName(nsUri,localName);
    }

    public boolean equals( String nsUri, String localName ) {
        return localName.equals(this.localName) && nsUri.equals(this.nsUri);
    }

    public int compareTo(Name that) {
        int r = this.nsUri.compareTo(that.nsUri);
        if(r!=0)    return r;
        return this.localName.compareTo(that.localName);
    }
}
