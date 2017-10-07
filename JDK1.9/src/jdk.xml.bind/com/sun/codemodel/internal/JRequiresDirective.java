/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.codemodel.internal;

/**
 * Represents a Java module {@code requires} directive.
 * For example {@code "requires foo.bar;"} or {@code "requires public foo.baz;"}.
 * @author Tomas Kraus
 */
public class JRequiresDirective extends JModuleDirective {

    /** Public readability modifier. */
    final boolean isPublic;

    /** Static modifier. */
    final boolean isStatic;

    /**
     * Creates an instance of Java module {@code requires} directive.
     * @param name name of required module or service.
     * @param isPublic Use {@code public} modifier.
     * @param isStatic Use {@code static} modifier.
     * @throws IllegalArgumentException if the name argument is {@code null}.
     */
    JRequiresDirective(final String name, final boolean isPublic, final boolean isStatic) {
        super(name);
        this.isPublic = isPublic;
        this.isStatic = isStatic;
    }

    /**
     * Gets the type of this module directive.
     * @return type of this module directive. Will always return {@code Type.RequiresDirective}.
     */
    @Override
    public Type getType() {
        return Type.RequiresDirective;
    }

    /**
     * Print source code of {@code requires} module directive modifiers:
     * {@code public} and {@code static} keywords for module dependency.
     * @param f Java code formatter.
     */
    protected void generateModifiers(final JFormatter f) {
        if (isPublic) {
            f.p("public");
        }
        if (isStatic) {
            f.p("static");
        }
    }

    /**
     * Print source code of this module directive.
     * @param f Java code formatter.
     * @return provided instance of Java code formatter.
     */
    @Override
    public JFormatter generate(final JFormatter f) {
        f.p("requires");
        generateModifiers(f);
        f.p(name);
        f.p(';').nl();
        return f;
    }

}
