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
 * A skeletal visitor of program elements with default behavior
 * appropriate for the {@link SourceVersion#RELEASE_8 RELEASE_8}
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
 * @see AbstractElementVisitor9
 * @see AbstractElementVisitor14
 * @since 1.8
 */
@SupportedSourceVersion(RELEASE_8)
public abstract class AbstractElementVisitor8<R, P> extends AbstractElementVisitor7<R, P> {
    /**
     * Constructor for concrete subclasses to call.
     */
    @SuppressWarnings("deprecation") // Superclass constructor deprecated
    protected AbstractElementVisitor8(){
        super();
    }
}
