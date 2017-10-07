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

/**
 * See JVMS, section 4.8.15.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class AnnotationDefault_attribute extends Attribute {
    AnnotationDefault_attribute(ClassReader cr, int name_index, int length)
            throws IOException, Annotation.InvalidAnnotation {
        super(name_index, length);
        default_value = Annotation.element_value.read(cr);
    }

    public AnnotationDefault_attribute(ConstantPool constant_pool, Annotation.element_value default_value)
            throws ConstantPoolException {
        this(constant_pool.getUTF8Index(Attribute.AnnotationDefault), default_value);
    }

    public AnnotationDefault_attribute(int name_index, Annotation.element_value default_value) {
        super(name_index, default_value.length());
        this.default_value = default_value;
    }

    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitAnnotationDefault(this, data);
    }

    public final Annotation.element_value default_value;
}

