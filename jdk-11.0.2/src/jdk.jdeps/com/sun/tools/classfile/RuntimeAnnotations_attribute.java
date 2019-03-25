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
 * See JVMS, section 4.8.16 and 4.8.17.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public abstract class RuntimeAnnotations_attribute extends Attribute {
    protected RuntimeAnnotations_attribute(ClassReader cr, int name_index, int length)
            throws IOException, Annotation.InvalidAnnotation {
        super(name_index, length);
        int num_annotations = cr.readUnsignedShort();
        annotations = new Annotation[num_annotations];
        for (int i = 0; i < annotations.length; i++)
            annotations[i] = new Annotation(cr);
    }

    protected RuntimeAnnotations_attribute(int name_index, Annotation[] annotations) {
        super(name_index, length(annotations));
        this.annotations = annotations;
    }

    private static int length(Annotation[] annos) {
        int n = 2;
        for (Annotation anno: annos)
            n += anno.length();
        return n;
    }

    public final Annotation[] annotations;
}
