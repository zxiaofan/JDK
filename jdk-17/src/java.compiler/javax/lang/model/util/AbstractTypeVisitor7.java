/*
 * Copyright (c) 2010, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * the {@link javax.lang.model.SourceVersion#RELEASE_7 RELEASE_7}
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
 * @see AbstractTypeVisitor8
 * @see AbstractTypeVisitor9
 * @see AbstractTypeVisitor14
 * @since 1.7
 */
@SupportedSourceVersion(RELEASE_7)
public abstract class AbstractTypeVisitor7<R, P> extends AbstractTypeVisitor6<R, P> {
    /**
     * Constructor for concrete subclasses to call.
     *
     * @deprecated Release 7 is obsolete; update to a visitor for a newer
     * release level.
     */
    @Deprecated(since="12")
    protected AbstractTypeVisitor7() {
        super();  // Superclass constructor deprecated too
    }

    /**
     * Visits a {@code UnionType} in a manner defined by a subclass.
     *
     * @param t  {@inheritDoc}
     * @param p  {@inheritDoc}
     * @return the result of the visit as defined by a subclass
     */
    @Override
    public abstract R visitUnion(UnionType t, P p);
}
