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
import static javax.lang.model.SourceVersion.*;

/**
 * A simple visitor for annotation values with default behavior
 * appropriate for source version {@link SourceVersion#RELEASE_14 RELEASE_14}.
 *
 * Visit methods call {@link #defaultAction
 * defaultAction} passing their arguments to {@code defaultAction}'s
 * corresponding parameters.
 *
 * @apiNote
 * Methods in this class may be overridden subject to their general
 * contract.
 *
 * @param <R> the return type of this visitor's methods
 * @param <P> the type of the additional parameter to this visitor's methods.
 *
 * @see <a href="SimpleAnnotationValueVisitor6.html#note_for_subclasses">
 * <strong>Compatibility note for subclasses</strong></a>
 * @see SimpleAnnotationValueVisitor6
 * @see SimpleAnnotationValueVisitor7
 * @see SimpleAnnotationValueVisitor8
 * @see SimpleAnnotationValueVisitor9
 * @since 14
 */
@SupportedSourceVersion(RELEASE_17)
public class SimpleAnnotationValueVisitor14<R, P> extends SimpleAnnotationValueVisitor9<R, P> {
    /**
     * Constructor for concrete subclasses; uses {@code null} for the
     * default value.
     */
    protected SimpleAnnotationValueVisitor14() {
        super(null);
    }

    /**
     * Constructor for concrete subclasses; uses the argument for the
     * default value.
     *
     * @param defaultValue the value to assign to {@link #DEFAULT_VALUE}
     */
    protected SimpleAnnotationValueVisitor14(R defaultValue) {
        super(defaultValue);
    }
}
