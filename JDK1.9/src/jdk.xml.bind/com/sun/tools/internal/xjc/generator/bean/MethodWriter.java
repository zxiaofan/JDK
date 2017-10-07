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

/*
 * Use is subject to the license terms.
 */
package com.sun.tools.internal.xjc.generator.bean;

import com.sun.codemodel.internal.JCodeModel;
import com.sun.codemodel.internal.JDocComment;
import com.sun.codemodel.internal.JMethod;
import com.sun.codemodel.internal.JType;
import com.sun.codemodel.internal.JVar;
import com.sun.tools.internal.xjc.outline.ClassOutline;

/**
 * The back-end may or may not generate the content interface
 * separately from the implementation class. If so, a method
 * needs to be declared on both the interface and the implementation class.
 * <p>
 * This class hides those details and allow callers to declare
 * methods just once.
 *
 * @author Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public abstract class MethodWriter {
    protected final JCodeModel codeModel;

    protected MethodWriter(ClassOutline context) {
        this.codeModel = context.parent().getCodeModel();
    }

    /**
     * Declares a method in both the interface and the implementation.
     *
     * @return
     *      JMethod object that represents a newly declared method
     *      on the implementation class.
     */
    public abstract JMethod declareMethod( JType returnType, String methodName );

    public final JMethod declareMethod( Class returnType, String methodName ) {
        return declareMethod( codeModel.ref(returnType), methodName );
    }

    /**
     * To generate javadoc for the previously declared method, use this method
     * to obtain a {@link JDocComment} object. This may return a value
     * different from declareMethod().javadoc().
     */
    public abstract JDocComment javadoc();


    /**
     * Adds a parameter to the previously declared method.
     *
     * @return
     *      JVar object that represents a newly added parameter
     *      on the implementation class.
     */
    public abstract JVar addParameter( JType type, String name );

    public final JVar addParameter( Class type, String name ) {
        return addParameter( codeModel.ref(type), name );
    }
}
