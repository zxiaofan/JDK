/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.declaration;


import java.lang.annotation.Annotation;
import java.util.Collection;

import com.sun.mirror.type.*;
import com.sun.mirror.util.*;


/**
 * Represents the declaration of a program element such as a package,
 * class, or method.  Each declaration represents a static, language-level
 * construct (and not, for example, a runtime construct of the virtual
 * machine), and typically corresponds one-to-one with a particular
 * fragment of source code.
 *
 * <p> Declarations should be compared using the {@link #equals(Object)}
 * method.  There is no guarantee that any particular declaration will
 * always be represented by the same object.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 *
 * @see Declarations
 * @see TypeMirror
 * @since 1.5
 */

public interface Declaration {

    /**
     * Tests whether an object represents the same declaration as this.
     *
     * @param obj  the object to be compared with this declaration
     * @return <tt>true</tt> if the specified object represents the same
     *		declaration as this
     */
    boolean equals(Object obj);

    /**
     * Returns the text of the documentation ("javadoc") comment of
     * this declaration.
     *
     * @return the documentation comment of this declaration, or <tt>null</tt>
     *		if there is none
     */
    String getDocComment();

    /**
     * Returns the annotations that are directly present on this declaration.
     *
     * @return the annotations directly present on this declaration;
     *		an empty collection if there are none
     */
    Collection<AnnotationMirror> getAnnotationMirrors();

    /**
     * Returns the annotation of this declaration having the specified
     * type.  The annotation may be either inherited or directly
     * present on this declaration.
     *
     * <p> The annotation returned by this method could contain an element
     * whose value is of type <tt>Class</tt>.
     * This value cannot be returned directly:  information necessary to
     * locate and load a class (such as the class loader to use) is
     * not available, and the class might not be loadable at all.
     * Attempting to read a <tt>Class</tt> object by invoking the relevant
     * method on the returned annotation
     * will result in a {@link MirroredTypeException},
     * from which the corresponding {@link TypeMirror} may be extracted.
     * Similarly, attempting to read a <tt>Class[]</tt>-valued element
     * will result in a {@link MirroredTypesException}.
     *
     * <blockquote>
     * <i>Note:</i> This method is unlike
     * others in this and related interfaces.  It operates on run-time
     * reflective information -- representations of annotation types
     * currently loaded into the VM -- rather than on the mirrored
     * representations defined by and used throughout these
     * interfaces.  It is intended for callers that are written to
     * operate on a known, fixed set of annotation types.
     * </blockquote>
     *
     * @param <A>  the annotation type
     * @param annotationType  the <tt>Class</tt> object corresponding to
     *		the annotation type
     * @return the annotation of this declaration having the specified type
     *
     * @see #getAnnotationMirrors()
     */
    <A extends Annotation> A getAnnotation(Class<A> annotationType);

    /**
     * Returns the modifiers of this declaration, excluding annotations.
     * Implicit modifiers, such as the <tt>public</tt> and <tt>static</tt>
     * modifiers of interface members, are included.
     *
     * @return the modifiers of this declaration in undefined order;
     *		an empty collection if there are none
     */
    Collection<Modifier> getModifiers();

    /**
     * Returns the simple (unqualified) name of this declaration.
     * The name of a generic type does not include any reference
     * to its formal type parameters.
     * For example, the simple name of the interface declaration
     * {@code java.util.Set<E>} is <tt>"Set"</tt>.
     * If this declaration represents the empty package, an empty
     * string is returned.
     * If it represents a constructor, the simple name of its
     * declaring class is returned.
     *
     * @return the simple name of this declaration
     */
    String getSimpleName();

    /**
     * Returns the source position of the beginning of this declaration.
     * Returns <tt>null</tt> if the position is unknown or not applicable.
     *
     * <p> This source position is intended for use in providing
     * diagnostics, and indicates only approximately where a declaration
     * begins.
     *
     * @return the source position of the beginning of this declaration,
     *		or null if the position is unknown or not applicable
     */
    SourcePosition getPosition();

    /**
     * Applies a visitor to this declaration.
     *
     * @param v the visitor operating on this declaration
     */
    void accept(DeclarationVisitor v);
}
