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

import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.RecordComponentElement;
import static javax.lang.model.SourceVersion.*;

/**
 * A skeletal visitor of program elements with default behavior
 * appropriate for the {@link SourceVersion#RELEASE_14 RELEASE_14}
 * source version.
 *
 * @param <R> the return type of this visitor's methods.  Use {@link
 *            Void} for visitors that do not need to return results.
 * @param <P> the type of the additional parameter to this visitor's
 *            methods.  Use {@code Void} for visitors that do not need an
 *            additional parameter.
 *
 * @see <a href="AbstractElementVisitor6.html#note_for_subclasses">
 * <strong>Compatibility note for subclasses</strong></a>
 * @see AbstractElementVisitor6
 * @see AbstractElementVisitor7
 * @see AbstractElementVisitor8
 * @see AbstractElementVisitor9
 * @since 16
 */
@SupportedSourceVersion(RELEASE_17)
public abstract class AbstractElementVisitor14<R, P> extends AbstractElementVisitor9<R, P> {
    /**
     * Constructor for concrete subclasses to call.
     */
    protected AbstractElementVisitor14(){
        super();
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec Visits a {@code RecordComponentElement} in a manner defined by a
     * subclass.
     *
     * @param t  {@inheritDoc}
     * @param p  {@inheritDoc}
     * @return   {@inheritDoc}
     */
    @Override
    public abstract R visitRecordComponent(RecordComponentElement t, P p);
}
