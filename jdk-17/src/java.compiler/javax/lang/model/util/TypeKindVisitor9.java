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
import javax.lang.model.type.*;
import static javax.lang.model.SourceVersion.*;

/**
 * A visitor of types based on their {@linkplain TypeKind kind} with
 * default behavior appropriate for source versions {@link
 * SourceVersion#RELEASE_9 RELEASE_9} through {@link
 * SourceVersion#RELEASE_14 RELEASE_14}.
 *
 * For {@linkplain
 * TypeMirror types} <code><i>Xyz</i></code> that may have more than one
 * kind, the <code>visit<i>Xyz</i></code> methods in this class delegate
 * to the <code>visit<i>Xyz</i>As<i>Kind</i></code> method corresponding to the
 * first argument's kind.  The <code>visit<i>Xyz</i>As<i>Kind</i></code> methods
 * call {@link #defaultAction defaultAction}, passing their arguments
 * to {@code defaultAction}'s corresponding parameters.
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
 * @see <a href="TypeKindVisitor6.html#note_for_subclasses">
 * <strong>Compatibility note for subclasses</strong></a>
 * @see TypeKindVisitor6
 * @see TypeKindVisitor7
 * @see TypeKindVisitor8
 * @see TypeKindVisitor14
 * @since 9
 */
@SupportedSourceVersion(RELEASE_14)
public class TypeKindVisitor9<R, P> extends TypeKindVisitor8<R, P> {
    /**
     * Constructor for concrete subclasses to call; uses {@code null}
     * for the default value.
     */
    protected TypeKindVisitor9() {
        super(null);
    }

    /**
     * Constructor for concrete subclasses to call; uses the argument
     * for the default value.
     *
     * @param defaultValue the value to assign to {@link #DEFAULT_VALUE}
     */
    protected TypeKindVisitor9(R defaultValue) {
        super(defaultValue);
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec This implementation calls {@code defaultAction}.
     *
     * @param t {@inheritDoc}
     * @param p {@inheritDoc}
     * @return  the result of {@code defaultAction}
     *
     * @since 10
     */
    @Override
    public R visitNoTypeAsModule(NoType t, P p) {
        return defaultAction(t, p);
    }
}
