/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.model;

import com.sun.codemodel.internal.JClass;
import com.sun.codemodel.internal.JType;
import com.sun.tools.internal.xjc.model.nav.NClass;
import com.sun.tools.internal.xjc.model.nav.NType;
import com.sun.tools.internal.xjc.outline.Aspect;
import com.sun.tools.internal.xjc.outline.Outline;
import com.sun.xml.internal.bind.v2.model.core.TypeInfo;

/**
 * {@link TypeInfo} at the compile-time.
 * Either {@link CClassInfo}, {@link CBuiltinLeafInfo}, or {@link CElementInfo}.
 *
 * @author Kohsuke Kawaguchi
 */
public interface CTypeInfo extends TypeInfo<NType,NClass>, CCustomizable {

    /**
     * Returns the {@link JClass} that represents the class being bound,
     * under the given {@link Outline}.
     *
     * @see NType#toType(Outline, com.sun.tools.internal.xjc.outline.Aspect)
     */
    JType toType(Outline o, Aspect aspect);
}
