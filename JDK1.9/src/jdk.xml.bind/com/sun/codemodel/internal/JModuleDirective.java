/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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

// Currently only exports directive is needed in this model.
/**
 * Represents a Java module directive.
 * For example {@code "exports foo.bar;"} or {@code "requires foo.baz;"}.
 * @author Tomas Kraus
 */
public abstract class JModuleDirective {

    // Only ExportsDirective is implemented.
    /**
     * Module directive type. Child class implements {@code getType()} method which returns corresponding value.
     */
    public enum Type {
       /** Directive starting with {@code requires} keyword. */
       RequiresDirective,
       /** Directive starting with {@code exports} keyword. */
       ExportsDirective,
    }

    /** Name argument of module directive. */
    protected final String name;

    /**
     * Creates an instance of Java module directive.
     * @param name name argument of module directive.
     * @throws IllegalArgumentException if the name argument is {@code null}.
     */
    JModuleDirective(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("JModuleDirective name argument is null");
        }
        this.name = name;
    }

    /**
     * Gets the type of this module directive.
     * @return type of this module directive. Will never be {@code null}.
     */
    public abstract Type getType();

    /**
     * Print source code of this module directive.
     * @param f Java code formatter.
     * @return provided instance of Java code formatter.
     */
    public abstract JFormatter generate(final JFormatter f);

    /**
     * Compares this module directive to the specified object.
     * @param other The object to compare this {@link JModuleDirective} against.
     * @return {@code true} if the argument is not {@code null}
     *         and is a {@link JModuleDirective} object with the same type
     *         and equal name.
     */
    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof JModuleDirective) {
            final JModuleDirective otherDirective = (JModuleDirective)other;
            return this.getType() == otherDirective.getType() && this.name.equals(otherDirective.name);
        }
        return false;
    }


    /**
     * Returns a hash code for this module directive based on directive type and name.
     * The hash code for a module directive is computed as
     * <blockquote><pre>
     *     {@code 97 * (type_ordinal_value + 1) + name.hashCode()}
     * </pre></blockquote>
     * using {@code int} arithmetic.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return 97 * (getType().ordinal() + 1) + name.hashCode();
    }

    /**
     * Gets the name of this module directive.
     * @return name of this module directive.
     */
    public String name() {
        return name;
    }

}
