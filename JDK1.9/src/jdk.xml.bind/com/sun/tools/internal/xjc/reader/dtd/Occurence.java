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

package com.sun.tools.internal.xjc.reader.dtd;

import java.util.List;

import com.sun.xml.internal.dtdparser.DTDEventListener;


/**
 * @author Kohsuke Kawaguchi
 */
final class Occurence extends Term {
    final Term term;
    final boolean isOptional;
    final boolean isRepeated;

    Occurence(Term term, boolean optional, boolean repeated) {
        this.term = term;
        isOptional = optional;
        isRepeated = repeated;
    }

    static Term wrap( Term t, int occurence ) {
        switch(occurence) {
        case DTDEventListener.OCCURENCE_ONCE:
            return t;
        case DTDEventListener.OCCURENCE_ONE_OR_MORE:
            return new Occurence(t,false,true);
        case DTDEventListener.OCCURENCE_ZERO_OR_MORE:
            return new Occurence(t,true,true);
        case DTDEventListener.OCCURENCE_ZERO_OR_ONE:
            return new Occurence(t,true,false);
        default:
            throw new IllegalArgumentException();
        }
    }

    void normalize(List<Block> r, boolean optional) {
        if(isRepeated) {
            Block b = new Block(isOptional||optional,true);
            addAllElements(b);
            r.add(b);
        } else {
            term.normalize(r,optional||isOptional);
        }
    }

    void addAllElements(Block b) {
        term.addAllElements(b);
    }

    boolean isOptional() {
        return isOptional||term.isOptional();
    }

    boolean isRepeated() {
        return isRepeated||term.isRepeated();
    }
}
