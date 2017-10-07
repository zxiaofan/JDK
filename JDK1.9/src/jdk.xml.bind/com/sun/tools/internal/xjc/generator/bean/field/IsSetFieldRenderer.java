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
 * FieldRenderer that wraps another field generator
 * and produces isSetXXX unsetXXX methods.
 *
 * <p>
 * This follows the decorator design pattern so that
 * the caller of FieldRenderer can forget about details
 * of the method generation.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public class IsSetFieldRenderer implements FieldRenderer {
    private final FieldRenderer core;
    private final boolean generateUnSetMethod;
    private final boolean generateIsSetMethod;

    public IsSetFieldRenderer(
        FieldRenderer core,
        boolean generateUnSetMethod, boolean generateIsSetMethod ) {

        this.core = core;
        this.generateUnSetMethod = generateUnSetMethod;
        this.generateIsSetMethod = generateIsSetMethod;
    }

    public FieldOutline generate(ClassOutlineImpl context, CPropertyInfo prop) {
        return new IsSetField(context,prop,
            core.generate(context, prop),
            generateUnSetMethod,generateIsSetMethod);
    }
}
