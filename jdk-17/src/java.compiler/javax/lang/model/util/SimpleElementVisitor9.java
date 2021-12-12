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
import javax.lang.model.element.ModuleElement;
import static javax.lang.model.SourceVersion.*;

/**
 * A simple visitor of program elements with default behavior
 * appropriate for source versions {@link SourceVersion#RELEASE_9
 * RELEASE_9} through {@link SourceVersion#RELEASE_14 RELEASE_14}.
 *
 * Visit methods corresponding to {@code RELEASE_9} and earlier
 * language constructs call {@link #defaultAction defaultAction},
 * passing their arguments to {@code defaultAction}'s corresponding
 * parameters.
 *
 * @apiNote
 * Methods in this class may be overridden subject to their general
 * contract.
 *
 * @param <R> the return type of this visitor's methods.  Use {@code Void}
 *             for visitors that do not need to return results.
 * @param <P> the type of the additional parameter to this visitor's methods.  Use {@code Void}
 *              for visitors that do not need an additional parameter.
 *
 * @see <a href="SimpleElementVisitor6.html#note_for_subclasses">
 * <strong>Compatibility note for subclasses</strong></a>
 * @see SimpleElementVisitor6
 * @see SimpleElementVisitor7
 * @see SimpleElementVisitor8
 * @see SimpleElementVisitor14
 * @since 9
 */
@SupportedSourceVersion(RELEASE_14)
public class SimpleElementVisitor9<R, P> extends SimpleElementVisitor8<R, P> {
    /**
     * Constructor for concrete subclasses; uses {@code null} for the
     * default value.
     */
    protected SimpleElementVisitor9(){
        super(null);
    }

    /**
     * Constructor for concrete subclasses; uses the argument for the
     * default value.
     *
     * @param defaultValue the value to assign to {@link #DEFAULT_VALUE}
     */
    protected SimpleElementVisitor9(R defaultValue){
        super(defaultValue);
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec Visits a {@code ModuleElement} by calling {@code
     * defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     * @return  {@inheritDoc}
     */
    @Override
    public R visitModule(ModuleElement e, P p) {
        return defaultAction(e, p);
    }
}
