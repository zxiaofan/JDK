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
import static javax.lang.model.SourceVersion.*;

/**
 * A simple visitor for annotation values with default behavior
 * appropriate for source versions {@link SourceVersion#RELEASE_9
 * RELEASE_9} through {@link SourceVersion#RELEASE_14 RELEASE_14}.
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
 * @see SimpleAnnotationValueVisitor14
 * @since 9
 */
@SupportedSourceVersion(RELEASE_14)
public class SimpleAnnotationValueVisitor9<R, P> extends SimpleAnnotationValueVisitor8<R, P> {
    /**
     * Constructor for concrete subclasses; uses {@code null} for the
     * default value.
     */
    protected SimpleAnnotationValueVisitor9() {
        super(null);
    }

    /**
     * Constructor for concrete subclasses; uses the argument for the
     * default value.
     *
     * @param defaultValue the value to assign to {@link #DEFAULT_VALUE}
     */
    protected SimpleAnnotationValueVisitor9(R defaultValue) {
        super(defaultValue);
    }
}
