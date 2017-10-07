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
 * See JVMS, section 4.8.17.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class RuntimeInvisibleAnnotations_attribute extends RuntimeAnnotations_attribute {
    RuntimeInvisibleAnnotations_attribute(ClassReader cr, int name_index, int length)
            throws IOException, AttributeException {
        super(cr, name_index, length);
    }

    public RuntimeInvisibleAnnotations_attribute(ConstantPool cp, Annotation[] annotations)
            throws ConstantPoolException {
        this(cp.getUTF8Index(Attribute.RuntimeInvisibleAnnotations), annotations);
    }

    public RuntimeInvisibleAnnotations_attribute(int name_index, Annotation[] annotations) {
        super(name_index, annotations);
    }

    public <R, P> R accept(Visitor<R, P> visitor, P p) {
        return visitor.visitRuntimeInvisibleAnnotations(this, p);
    }
}
