/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * See JSR 308 specification, Section 3.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class RuntimeInvisibleTypeAnnotations_attribute extends RuntimeTypeAnnotations_attribute {
    RuntimeInvisibleTypeAnnotations_attribute(ClassReader cr, int name_index, int length)
            throws IOException, Annotation.InvalidAnnotation {
        super(cr, name_index, length);
    }

    public RuntimeInvisibleTypeAnnotations_attribute(ConstantPool cp, TypeAnnotation[] annotations)
            throws ConstantPoolException {
        this(cp.getUTF8Index(Attribute.RuntimeInvisibleTypeAnnotations), annotations);
    }

    public RuntimeInvisibleTypeAnnotations_attribute(int name_index, TypeAnnotation[] annotations) {
        super(name_index, annotations);
    }

    public <R, P> R accept(Visitor<R, P> visitor, P p) {
        return visitor.visitRuntimeInvisibleTypeAnnotations(this, p);
    }
}
