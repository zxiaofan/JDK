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

import static javax.lang.model.SourceVersion.*;
import javax.lang.model.SourceVersion;
import javax.annotation.processing.SupportedSourceVersion;

/**
 * A skeletal visitor for annotation values with default behavior
 * appropriate for source version {@link SourceVersion#RELEASE_14 RELEASE_14}.
 *
 * @param <R> the return type of this visitor's methods
 * @param <P> the type of the additional parameter to this visitor's methods.
 *
 * @see <a href="AbstractAnnotationValueVisitor6.html#note_for_subclasses">
 * <strong>Compatibility note for subclasses</strong></a>
 * @see AbstractAnnotationValueVisitor6
 * @see AbstractAnnotationValueVisitor7
 * @see AbstractAnnotationValueVisitor8
 * @see AbstractAnnotationValueVisitor9
 * @since 14
 */
@SupportedSourceVersion(RELEASE_17)
public abstract class AbstractAnnotationValueVisitor14<R, P> extends AbstractAnnotationValueVisitor9<R, P> {

    /**
     * Constructor for concrete subclasses to call.
     */
    protected AbstractAnnotationValueVisitor14() {
        super();
    }
}
