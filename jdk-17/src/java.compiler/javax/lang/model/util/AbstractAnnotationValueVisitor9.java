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
 * appropriate for source versions {@link SourceVersion#RELEASE_9
 * RELEASE_9} through {@link SourceVersion#RELEASE_14 RELEASE_14}.
 *
 * @param <R> the return type of this visitor's methods
 * @param <P> the type of the additional parameter to this visitor's methods.
 *
 * @see <a href="AbstractAnnotationValueVisitor6.html#note_for_subclasses">
 * <strong>Compatibility note for subclasses</strong></a>
 * @see AbstractAnnotationValueVisitor6
 * @see AbstractAnnotationValueVisitor7
 * @see AbstractAnnotationValueVisitor8
 * @see AbstractAnnotationValueVisitor14
 * @since 9
 */
@SupportedSourceVersion(RELEASE_14)
public abstract class AbstractAnnotationValueVisitor9<R, P> extends AbstractAnnotationValueVisitor8<R, P> {

    /**
     * Constructor for concrete subclasses to call.
     */
    protected AbstractAnnotationValueVisitor9() {
        super();
    }
}
