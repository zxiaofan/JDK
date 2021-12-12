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

import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.type.IntersectionType;
import static javax.lang.model.SourceVersion.*;

/**
 * A simple visitor of types with default behavior appropriate for the
 * {@link SourceVersion#RELEASE_8 RELEASE_8} source version.
 *
 * Visit methods corresponding to {@code RELEASE_8} and earlier
 * language constructs call {@link #defaultAction defaultAction},
 * passing their arguments to {@code defaultAction}'s corresponding
 * parameters.
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
 * @see <a href="SimpleTypeVisitor6.html#note_for_subclasses">
 * <strong>Compatibility note for subclasses</strong></a>
 * @see SimpleTypeVisitor6
 * @see SimpleTypeVisitor7
 * @see SimpleTypeVisitor9
 * @see SimpleTypeVisitor14
 * @since 1.8
 */
@SupportedSourceVersion(RELEASE_8)
public class SimpleTypeVisitor8<R, P> extends SimpleTypeVisitor7<R, P> {
    /**
     * Constructor for concrete subclasses; uses {@code null} for the
     * default value.
     */
    @SuppressWarnings("deprecation") // Superclass constructor deprecated
    protected SimpleTypeVisitor8(){
        super(null);
    }

    /**
     * Constructor for concrete subclasses; uses the argument for the
     * default value.
     *
     * @param defaultValue the value to assign to {@link #DEFAULT_VALUE}
     */
    @SuppressWarnings("deprecation") // Superclass constructor deprecated
    protected SimpleTypeVisitor8(R defaultValue){
        super(defaultValue);
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec This implementation calls {@code defaultAction}.
     *
     * @param t {@inheritDoc}
     * @param p {@inheritDoc}
     * @return  the result of {@code defaultAction}
     */
    @Override
    public R visitIntersection(IntersectionType t, P p){
        return defaultAction(t, p);
    }
}
