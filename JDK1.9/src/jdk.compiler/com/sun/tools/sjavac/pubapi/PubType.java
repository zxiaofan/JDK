/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.pubapi;

import java.io.Serializable;
import java.util.Set;

import javax.lang.model.element.Modifier;

public class PubType implements Serializable {

    private static final long serialVersionUID = -7423416049253889793L;

    public final Set<Modifier> modifiers;
    public final String fqName;
    public final PubApi pubApi;

    public PubType(Set<Modifier> modifiers,
                   String fqName,
                   PubApi pubApi) {
        this.modifiers = modifiers;
        this.fqName = fqName;
        this.pubApi = pubApi;
    }

    public String getFqName() {
        return fqName.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        PubType other = (PubType) obj;
        return modifiers.equals(other.modifiers)
            && fqName.equals(other.fqName)
            && pubApi.equals(other.pubApi);
    }

    @Override
    public int hashCode() {
        return modifiers.hashCode() ^ fqName.hashCode() ^ pubApi.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s[modifiers: %s, fqName: %s, pubApi: %s]",
                             getClass().getSimpleName(),
                             modifiers,
                             fqName,
                             pubApi);
    }
}
