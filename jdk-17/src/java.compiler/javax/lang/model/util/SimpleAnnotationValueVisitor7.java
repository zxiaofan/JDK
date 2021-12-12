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
import javax.lang.model.SourceVersion;
import static javax.lang.model.SourceVersion.*;

/**
 * A simple visitor for annotation values with default behavior
 * appropriate for the {@link SourceVersion#RELEASE_7 RELEASE_7}
 * source version.  Visit methods call {@link #defaultAction
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
 * @see SimpleAnnotationValueVisitor8
 * @see SimpleAnnotationValueVisitor9
 * @see SimpleAnnotationValueVisitor14
 * @since 1.7
 */
@SupportedSourceVersion(RELEASE_7)
public class SimpleAnnotationValueVisitor7<R, P> extends SimpleAnnotationValueVisitor6<R, P> {
    /**
     * Constructor for concrete subclasses; uses {@code null} for the
     * default value.
     *
     * @deprecated Release 7 is obsolete; update to a visitor for a newer
     * release level.
     */
    @Deprecated(since="12")
    protected SimpleAnnotationValueVisitor7() {
        super(null); // Superclass constructor deprecated too
    }

    /**
     * Constructor for concrete subclasses; uses the argument for the
     * default value.
     *
     * @param defaultValue the value to assign to {@link #DEFAULT_VALUE}
     *
     * @deprecated Release 7 is obsolete; update to a visitor for a newer
     * release level.
     */
    @Deprecated(since="12")
    protected SimpleAnnotationValueVisitor7(R defaultValue) {
        super(defaultValue); // Superclass constructor deprecated too
    }
}
