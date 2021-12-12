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
import javax.lang.model.type.*;

import static javax.lang.model.SourceVersion.*;

/**
 * A skeletal visitor of types with default behavior appropriate for
 * the {@link javax.lang.model.SourceVersion#RELEASE_8 RELEASE_8}
 * source version.
 *
 * @param <R> the return type of this visitor's methods.  Use {@link
 *            Void} for visitors that do not need to return results.
 * @param <P> the type of the additional parameter to this visitor's
 *            methods.  Use {@code Void} for visitors that do not need an
 *            additional parameter.
 *
 * @see <a href="AbstractTypeVisitor6.html#note_for_subclasses">
 * <strong>Compatibility note for subclasses</strong></a>
 * @see AbstractTypeVisitor6
 * @see AbstractTypeVisitor7
 * @see AbstractTypeVisitor9
 * @see AbstractTypeVisitor14
 * @since 1.8
 */
@SupportedSourceVersion(RELEASE_8)
public abstract class AbstractTypeVisitor8<R, P> extends AbstractTypeVisitor7<R, P> {
    /**
     * Constructor for concrete subclasses to call.
     */
    @SuppressWarnings("deprecation") // Superclass constructor deprecated
    protected AbstractTypeVisitor8() {
        super();
    }

    /**
     * Visits an {@code IntersectionType} in a manner defined by a subclass.
     *
     * @param t  {@inheritDoc}
     * @param p  {@inheritDoc}
     * @return the result of the visit as defined by a subclass
     */
    @Override
    public abstract R visitIntersection(IntersectionType t, P p);
}
