/*
 * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
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

package javax.lang.model.util;

import javax.lang.model.element.*;
import javax.annotation.processing.SupportedSourceVersion;
import static javax.lang.model.SourceVersion.*;
import javax.lang.model.SourceVersion;

/**
 * A visitor of program elements based on their {@linkplain
 * ElementKind kind} with default behavior appropriate for the {@link
 * SourceVersion#RELEASE_8 RELEASE_8} source version.  For {@linkplain
 * Element elements} <code><i>Xyz</i></code> that may have more than one
 * kind, the <code>visit<i>Xyz</i></code> methods in this class delegate
 * to the <code>visit<i>Xyz</i>As<i>Kind</i></code> method corresponding to the
 * first argument's kind.  The <code>visit<i>Xyz</i>As<i>Kind</i></code> methods
 * call {@link #defaultAction defaultAction}, passing their arguments
 * to {@code defaultAction}'s corresponding parameters.
 *
 * @apiNote
 * Methods in this class may be overridden subject to their general
 * contract.
 *
 * @param <R> the return type of this visitor's methods.  Use {@link
 *            Void} for visitors that do not need to return results.
 * @param <P> the type of the additional parameter to this visitor's
 *            methods.  Use {@code Void} for visitors that do not need an
 *            additional parameter.
 *
 * @see <a href="ElementKindVisitor6.html#note_for_subclasses">
 * <strong>Compatibility note for subclasses</strong></a>
 * @see ElementKindVisitor6
 * @see ElementKindVisitor7
 * @see ElementKindVisitor9
 * @see ElementKindVisitor14
 * @since 1.8
 */
@SupportedSourceVersion(RELEASE_8)
public class ElementKindVisitor8<R, P> extends ElementKindVisitor7<R, P> {
    /**
     * Constructor for concrete subclasses; uses {@code null} for the
     * default value.
     */
    @SuppressWarnings("deprecation") // Superclass constructor deprecated
    protected ElementKindVisitor8() {
        super(null);
    }

    /**
     * Constructor for concrete subclasses; uses the argument for the
     * default value.
     *
     * @param defaultValue the value to assign to {@link #DEFAULT_VALUE}
     */
    @SuppressWarnings("deprecation") // Superclass constructor deprecated
    protected ElementKindVisitor8(R defaultValue) {
        super(defaultValue);
    }
}
