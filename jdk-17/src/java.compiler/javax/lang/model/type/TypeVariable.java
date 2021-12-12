/*
 * Copyright (c) 2005, 2020, Oracle and/or its affiliates. All rights reserved.
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

package javax.lang.model.type;


import javax.lang.model.element.Element;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.util.Types;


/**
 * Represents a type variable.
 * A type variable may be explicitly declared by a
 * {@linkplain TypeParameterElement type parameter} of a
 * type, method, or constructor.
 * A type variable may also be declared implicitly, as by
 * the capture conversion of a wildcard type argument
 * (see chapter {@jls 5} of
 * <cite>The Java Language Specification</cite>).
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see TypeParameterElement
 * @jls 4.4 Type Variables
 * @since 1.6
 */
public interface TypeVariable extends ReferenceType {

    /**
     * {@return the element corresponding to this type variable}
     */
    Element asElement();

    /**
     * {@return the upper bound of this type variable}
     *
     * <p> If this type variable was declared with no explicit
     * upper bounds, the result is {@code java.lang.Object}.
     * If it was declared with multiple upper bounds,
     * the result is an {@linkplain IntersectionType intersection type};
     * individual bounds can be found by examining the result's
     * {@linkplain IntersectionType#getBounds() bounds}.
     *
     * @jls 4.9 Intersection Types
     */
    TypeMirror getUpperBound();

    /**
     * {@return the lower bound of this type variable}  While a type
     * parameter cannot include an explicit lower bound declaration,
     * capture conversion can produce a type variable with a
     * non-trivial lower bound.  Type variables otherwise have a
     * lower bound of {@link NullType}.
     *
     * @jls 18.1.3. Bounds
     */
    TypeMirror getLowerBound();
}
