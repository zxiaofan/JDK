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
import javax.lang.model.type.*;
import javax.lang.model.SourceVersion;
import static javax.lang.model.SourceVersion.*;

/**
 * A skeletal visitor of types with default behavior appropriate for
 * source versions {@link SourceVersion#RELEASE_9 RELEASE_9} through
 * {@link SourceVersion#RELEASE_14 RELEASE_14}.
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
 * @see AbstractTypeVisitor7
 * @see AbstractTypeVisitor8
 * @see AbstractTypeVisitor14
 * @since 9
 */
@SupportedSourceVersion(RELEASE_14)
public abstract class AbstractTypeVisitor9<R, P> extends AbstractTypeVisitor8<R, P> {
    /**
     * Constructor for concrete subclasses to call.
     */
    protected AbstractTypeVisitor9() {
        super();
    }
}
