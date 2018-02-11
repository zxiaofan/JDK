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

// TODO: Implement "[to ModuleName {, ModuleName}]".
// Only minimal form of exports directive is needed now so it was not implemented in full form.
/**
 * Represents a Java module {@code exports} directive.
 * For example {@code "exports foo.bar;"}.
 * @author Tomas Kraus
 */

public class JExportsDirective extends JModuleDirective {

    /**
     * Creates an instance of Java module {@code exports} directive.
     * @param name name of package to be exported in this directive.
     * @throws IllegalArgumentException if the name argument is {@code null}.
     */
    JExportsDirective(final String name) {
        super(name);
    }

    /**
     * Gets the type of this module directive.
     * @return type of this module directive. Will always return {@code Type.ExportsDirective}.
     */
    @Override
    public Type getType() {
        return Type.ExportsDirective;
    }

    /**
     * Print source code of this module directive.
     * @param f Java code formatter.
     * @return provided instance of Java code formatter.
     */
    @Override
    public JFormatter generate(final JFormatter f) {
        f.p("exports").p(name).p(';').nl();
        return f;
    }

}
