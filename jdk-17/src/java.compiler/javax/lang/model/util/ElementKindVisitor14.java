/*
 * Copyright (c) 2019, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * SourceVersion#RELEASE_14 RELEASE_14} source version.
 *
 * For {@linkplain
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
 * @see ElementKindVisitor8
 * @see ElementKindVisitor9
 * @since 16
 */
@SupportedSourceVersion(RELEASE_17)
public class ElementKindVisitor14<R, P> extends ElementKindVisitor9<R, P> {
    /**
     * Constructor for concrete subclasses; uses {@code null} for the
     * default value.
     */
    protected ElementKindVisitor14() {
        super(null);
    }

    /**
     * Constructor for concrete subclasses; uses the argument for the
     * default value.
     *
     * @param defaultValue the value to assign to {@link #DEFAULT_VALUE}
     */
    protected ElementKindVisitor14(R defaultValue) {
        super(defaultValue);
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec This implementation calls {@code defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     * @return  the result of {@code defaultAction}
     */
    @Override
    public R visitRecordComponent(RecordComponentElement e, P p) {
        return defaultAction(e, p);
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec This implementation calls {@code defaultAction}.
     *.
     * @param e the element to visit
     * @param p a visitor-specified parameter
     * @return  the result of {@code defaultAction}
     */
    @Override
    public R visitTypeAsRecord(TypeElement e, P p) {
        return defaultAction(e, p);
    }

    /**
     * Visits a {@code BINDING_VARIABLE} variable element.
     *
     * @implSpec This implementation calls {@code defaultAction}.
     *
     * @param e {@inheritDoc}
     * @param p {@inheritDoc}
     * @return  the result of {@code defaultAction}
     *
     * @since 14
     */
    @Override
    public R visitVariableAsBindingVariable(VariableElement e, P p) {
        return defaultAction(e, p);
    }
}
