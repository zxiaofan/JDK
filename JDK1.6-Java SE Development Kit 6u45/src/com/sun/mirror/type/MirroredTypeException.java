/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.type;


import java.lang.annotation.Annotation;

import com.sun.mirror.declaration.Declaration;


/**
 * Thrown when an application attempts to access the {@link Class} object
 * corresponding to a {@link TypeMirror}.
 *
 * @see MirroredTypesException
 * @see Declaration#getAnnotation(Class)
 */
public class MirroredTypeException extends RuntimeException {

    private static final long serialVersionUID = 1;

    private transient TypeMirror type;		// cannot be serialized
    private String name;			// type's qualified "name"

    /**
     * Constructs a new MirroredTypeException for the specified type.
     *
     * @param type  the type being accessed
     */
    public MirroredTypeException(TypeMirror type) {
	super("Attempt to access Class object for TypeMirror " + type);
	this.type = type;
	name = type.toString();
    }

    /**
     * Returns the type mirror corresponding to the type being accessed.
     * The type mirror may be unavailable if this exception has been
     * serialized and then read back in.
     *
     * @return the type mirror, or <tt>null</tt> if unavailable
     */
    public TypeMirror getTypeMirror() {
	return type;
    }

    /**
     * Returns the fully qualified name of the type being accessed.
     * More precisely, returns the canonical name of a class,
     * interface, array, or primitive, and returns <tt>"void"</tt> for
     * the pseudo-type representing the type of <tt>void</tt>.
     *
     * @return the fully qualified name of the type being accessed
     */
    public String getQualifiedName() {
	return name;
    }
}
