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

import static javax.lang.model.SourceVersion.*;
import javax.lang.model.SourceVersion;
import javax.annotation.processing.SupportedSourceVersion;

/**
 * A skeletal visitor for annotation values with default behavior
 * appropriate for the {@link SourceVersion#RELEASE_8 RELEASE_8}
 * source version.
 *
 * @param <R> the return type of this visitor's methods
 * @param <P> the type of the additional parameter to this visitor's methods.
 *
 * @see <a href="AbstractAnnotationValueVisitor6.html#note_for_subclasses">
 * <strong>Compatibility note for subclasses</strong></a>
 * @see AbstractAnnotationValueVisitor6
 * @see AbstractAnnotationValueVisitor7
 * @see AbstractAnnotationValueVisitor9
 * @see AbstractAnnotationValueVisitor14
 * @since 1.8
 */
@SupportedSourceVersion(RELEASE_8)
public abstract class AbstractAnnotationValueVisitor8<R, P> extends AbstractAnnotationValueVisitor7<R, P> {

    /**
     * Constructor for concrete subclasses to call.
     */
    @SuppressWarnings("deprecation") // Superclass constructor deprecated
    protected AbstractAnnotationValueVisitor8() {
        super();
    }
}
