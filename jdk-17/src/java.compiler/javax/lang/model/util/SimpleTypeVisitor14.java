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
 * A simple visitor of types with default behavior appropriate for
 * source version {@link SourceVersion#RELEASE_14 RELEASE_14}.
 *
 * Visit methods corresponding to {@code RELEASE_14} and earlier
 * language constructs call {@link #defaultAction defaultAction},
 * passing their arguments to {@code defaultAction}'s corresponding
 * parameters.
 *
 * @apiNote
 * Methods in this class may be overridden subject to their general
 * contract.
 *
 * @param <R> the return type of this visitor's methods.  Use {@link
 *            Void} for visitors that do not need to return results.
 * @param <P> the type of the additional parameter to this visitor's
 *            methods.  Use {@code Void} for visitors that do not need an
 *            additional parameter.
 *
 * @see <a href="SimpleTypeVisitor6.html#note_for_subclasses">
 * <strong>Compatibility note for subclasses</strong></a>
 * @see SimpleTypeVisitor6
 * @see SimpleTypeVisitor7
 * @see SimpleTypeVisitor8
 * @see SimpleTypeVisitor9
 * @since 14
 */
@SupportedSourceVersion(RELEASE_17)
public class SimpleTypeVisitor14<R, P> extends SimpleTypeVisitor9<R, P> {
    /**
     * Constructor for concrete subclasses; uses {@code null} for the
     * default value.
     */
    protected SimpleTypeVisitor14(){
        super(null);
    }

    /**
     * Constructor for concrete subclasses; uses the argument for the
     * default value.
     *
     * @param defaultValue the value to assign to {@link #DEFAULT_VALUE}
     */
    protected SimpleTypeVisitor14(R defaultValue){
        super(defaultValue);
    }
}
