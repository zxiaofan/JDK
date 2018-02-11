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

package com.sun.xml.internal.bind.v2.model.impl;

import com.sun.xml.internal.bind.v2.model.core.EnumConstant;
import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

/**
 * @author Kohsuke Kawaguchi
 */
class EnumConstantImpl<T,C,F,M> implements EnumConstant<T,C> {
    protected final String lexical;
    protected final EnumLeafInfoImpl<T,C,F,M> owner;
    protected final String name;

    /**
     * All the constants of the {@link EnumConstantImpl} is linked in one list.
     */
    protected final EnumConstantImpl<T,C,F,M> next;

    public EnumConstantImpl(EnumLeafInfoImpl<T,C,F,M> owner, String name, String lexical, EnumConstantImpl<T,C,F,M> next) {
        this.lexical = lexical;
        this.owner = owner;
        this.name = name;
        this.next = next;
    }

    public EnumLeafInfo<T,C> getEnclosingClass() {
        return owner;
    }

    public final String getLexicalValue() {
        return lexical;
    }

    public final String getName() {
        return name;
    }
}
