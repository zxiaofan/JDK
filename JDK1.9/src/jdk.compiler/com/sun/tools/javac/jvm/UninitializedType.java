/*
 * Copyright (c) 2003, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.jvm;

import com.sun.tools.javac.code.*;
import com.sun.tools.javac.util.List;

import static com.sun.tools.javac.code.TypeTag.UNINITIALIZED_OBJECT;
import static com.sun.tools.javac.code.TypeTag.UNINITIALIZED_THIS;

/** These pseudo-types appear in the generated verifier tables to
 *  indicate objects that have been allocated but not yet constructed.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
class UninitializedType extends Type.DelegatedType {

    public static UninitializedType uninitializedThis(Type qtype) {
        return new UninitializedType(UNINITIALIZED_THIS, qtype, -1,
                                     qtype.getMetadata());
    }

    public static UninitializedType uninitializedObject(Type qtype, int offset) {
        return new UninitializedType(UNINITIALIZED_OBJECT, qtype, offset,
                                     qtype.getMetadata());
    }

    public final int offset; // PC where allocation took place
    private UninitializedType(TypeTag tag, Type qtype, int offset,
                              TypeMetadata metadata) {
        super(tag, qtype, metadata);
        this.offset = offset;
    }

    @Override
    public UninitializedType cloneWithMetadata(final TypeMetadata md) {
        return new UninitializedType(tag, qtype, offset, md);
    }

    Type initializedType() {
        return qtype;
    }
}
