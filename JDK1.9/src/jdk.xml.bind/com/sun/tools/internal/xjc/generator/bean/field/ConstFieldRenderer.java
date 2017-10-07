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

package com.sun.tools.internal.xjc.generator.bean.field;

import com.sun.tools.internal.xjc.generator.bean.ClassOutlineImpl;
import com.sun.tools.internal.xjc.model.CPropertyInfo;
import com.sun.tools.internal.xjc.outline.FieldOutline;

/**
 * {@link FieldRenderer} for possibly constant field.
 *
 * <p>
 * Since we don't know if the constant can be actually generated until
 * we get to the codemodel building phase, this renderer lazily
 * determines if it wants to generate a constant field or a normal property.
 *
 * @author Kohsuke Kawaguchi
 */
final class ConstFieldRenderer implements FieldRenderer {

    private final FieldRenderer fallback;

    protected ConstFieldRenderer(FieldRenderer fallback) {
        this.fallback = fallback;
    }

    public FieldOutline generate(ClassOutlineImpl outline, CPropertyInfo prop) {
        if(prop.defaultValue.compute(outline.parent())==null)
            return fallback.generate(outline, prop);
        else
            return new ConstField(outline,prop);
    }
}
