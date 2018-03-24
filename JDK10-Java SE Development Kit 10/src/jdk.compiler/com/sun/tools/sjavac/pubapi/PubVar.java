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
import java.util.Optional;
import java.util.Set;

import javax.lang.model.element.Modifier;

public class PubVar implements Serializable {

    private static final long serialVersionUID = 5806536061153374575L;

    public final Set<Modifier> modifiers;
    public final TypeDesc type;
    public final String identifier;
    private final String constValue;

    public PubVar(Set<Modifier> modifiers,
                  TypeDesc type,
                  String identifier,
                  String constValue) {
        this.modifiers = modifiers;
        this.type = type;
        this.identifier = identifier;
        this.constValue = constValue;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        PubVar other = (PubVar) obj;
        return modifiers.equals(other.modifiers)
            && type.equals(other.type)
            && identifier.equals(other.identifier)
            && getConstValue().equals(other.getConstValue());
    }

    @Override
    public int hashCode() {
        return modifiers.hashCode()
             ^ type.hashCode()
             ^ identifier.hashCode()
             ^ getConstValue().hashCode();
    }

    public String toString() {
        return String.format("%s[modifiers: %s, type: %s, identifier: %s, constValue: %s]",
                             getClass().getSimpleName(),
                             modifiers,
                             type,
                             identifier,
                             constValue);
    }

    public Optional<String> getConstValue() {
        return Optional.ofNullable(constValue);
    }
}
