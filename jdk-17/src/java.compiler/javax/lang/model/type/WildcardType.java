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


/**
 * Represents a wildcard type argument.
 * Examples include:    <pre><code>
 *   ?
 *   ? extends Number
 *   ? super T
 * </code></pre>
 *
 * <p> A wildcard may have its upper bound explicitly set by an
 * {@code extends} clause, its lower bound explicitly set by a
 * {@code super} clause, or neither (but not both).
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @jls 4.5.1 Type Arguments of Parameterized Types
 * @since 1.6
 */
public interface WildcardType extends TypeMirror {

    /**
     * {@return the upper bound of this wildcard}
     * If no upper bound is explicitly declared,
     * {@code null} is returned.
     */
    TypeMirror getExtendsBound();

    /**
     * {@return the lower bound of this wildcard}
     * If no lower bound is explicitly declared,
     * {@code null} is returned.
     */
    TypeMirror getSuperBound();
}
