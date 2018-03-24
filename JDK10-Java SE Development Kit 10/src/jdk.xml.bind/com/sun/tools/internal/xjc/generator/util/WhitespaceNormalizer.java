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

package com.sun.tools.internal.xjc.generator.util;

import com.sun.codemodel.internal.JCodeModel;
import com.sun.codemodel.internal.JExpr;
import com.sun.codemodel.internal.JExpression;
import com.sun.codemodel.internal.JStringLiteral;
import com.sun.xml.internal.bind.WhiteSpaceProcessor;

/**
 * Generates code that performs the whitespace normalization.
 */
public abstract class WhitespaceNormalizer
{
    /**
     * Generates the expression that normalizes
     * the given expression (which evaluates to java.lang.String).
     *
     * @param codeModel
     *      The owner code model object under which a new expression
     *      will be created.
     */
    public abstract JExpression generate( JCodeModel codeModel, JExpression literal );

    /**
     * Parses "preserve","replace" or "collapse" into
     * the corresponding WhitespaceNormalizer object.
     *
     * @param method
     *      Either "preserve", "replace", or "collapse"
     *
     * @exception    IllegalArgumentException
     *        when the specified method is invalid.
     */
    public static WhitespaceNormalizer parse( String method ) {
        if( method.equals("preserve") )
            return PRESERVE;

        if( method.equals("replace") )
            return REPLACE;

        if( method.equals("collapse") )
            return COLLAPSE;

        throw new IllegalArgumentException(method);
    }

    public static final WhitespaceNormalizer PRESERVE = new WhitespaceNormalizer() {
        public JExpression generate( JCodeModel codeModel, JExpression literal ) {
            return literal;
        }
    };

    public static final WhitespaceNormalizer REPLACE = new WhitespaceNormalizer() {
        public JExpression generate( JCodeModel codeModel, JExpression literal ) {
            // WhitespaceProcessor.replace(<literal>);
            if( literal instanceof JStringLiteral )
                // optimize
                return JExpr.lit( WhiteSpaceProcessor.replace(((JStringLiteral)literal).str) );
            else
                return codeModel.ref(WhiteSpaceProcessor.class)
                    .staticInvoke("replace").arg(literal);
        }
    };

    public static final WhitespaceNormalizer COLLAPSE = new WhitespaceNormalizer() {
        public JExpression generate( JCodeModel codeModel, JExpression literal ) {
            // WhitespaceProcessor.replace(<literal>);
            if( literal instanceof JStringLiteral )
                // optimize
                return JExpr.lit( WhiteSpaceProcessor.collapse(((JStringLiteral)literal).str) );
            else
                return codeModel.ref(WhiteSpaceProcessor.class)
                    .staticInvoke("collapse").arg(literal);
        }
    };
}
