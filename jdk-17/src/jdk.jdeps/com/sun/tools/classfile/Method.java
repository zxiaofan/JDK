/*
 * Copyright (c) 2007, 2008, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.classfile;

import java.io.IOException;

/*
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class Method {
    Method(ClassReader cr) throws IOException {
        access_flags = new AccessFlags(cr);
        name_index = cr.readUnsignedShort();
        descriptor = new Descriptor(cr);
        attributes = new Attributes(cr);
    }

    public Method(AccessFlags access_flags,
            int name_index, Descriptor descriptor,
            Attributes attributes) {
        this.access_flags = access_flags;
        this.name_index = name_index;
        this.descriptor = descriptor;
        this.attributes = attributes;
    }

    public int byteLength() {
        return 6 + attributes.byteLength();
    }

    public String getName(ConstantPool constant_pool) throws ConstantPoolException {
        return constant_pool.getUTF8Value(name_index);
    }

    public final AccessFlags access_flags;
    public final int name_index;
    public final Descriptor descriptor;
    public final Attributes attributes;
}
