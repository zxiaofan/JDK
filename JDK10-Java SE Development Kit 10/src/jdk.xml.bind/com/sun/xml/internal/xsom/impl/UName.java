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

package com.sun.xml.internal.xsom.impl;

import com.sun.xml.internal.xsom.XSDeclaration;

import java.util.Comparator;

/**
 * UName.
 *
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public final class UName {
    /**
     * @param _nsUri
     *      Use "" to indicate the no namespace.
     */
    public UName( String _nsUri, String _localName, String _qname ) {
        if(_nsUri==null || _localName==null || _qname==null) {
            throw new NullPointerException(_nsUri+" "+_localName+" "+_qname);
        }
        this.nsUri = _nsUri.intern();
        this.localName = _localName.intern();
        this.qname = _qname.intern();
    }

    public UName( String nsUri, String localName ) {
        this(nsUri,localName,localName);
    }

    public UName(XSDeclaration decl) {
        this(decl.getTargetNamespace(),decl.getName());
    }

    private final String nsUri;
    private final String localName;
    private final String qname;

    public String getName() { return localName; }
    public String getNamespaceURI() { return nsUri; }
    public String getQualifiedName() { return qname; }


    // Issue 540; XSComplexType.getAttributeUse(String,String) always return null
    // UName was used in HashMap without overriden equals and hashCode methods.

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof UName) {
            UName u = (UName)obj;

            return ((this.getName().compareTo(u.getName()) == 0) &&
                    (this.getNamespaceURI().compareTo(u.getNamespaceURI()) == 0) &&
                    (this.getQualifiedName().compareTo(u.getQualifiedName()) == 0));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.nsUri != null ? this.nsUri.hashCode() : 0);
        hash = 13 * hash + (this.localName != null ? this.localName.hashCode() : 0);
        hash = 13 * hash + (this.qname != null ? this.qname.hashCode() : 0);
        return hash;
    }

    /**
     * Compares {@link UName}s by their names.
     */
    public static final Comparator comparator = new Comparator() {
        public int compare(Object o1, Object o2) {
            UName lhs = (UName)o1;
            UName rhs = (UName)o2;
            int r = lhs.nsUri.compareTo(rhs.nsUri);
            if(r!=0)    return r;
            return lhs.localName.compareTo(rhs.localName);
        }
    };
}
