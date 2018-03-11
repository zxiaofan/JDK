/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.lang.model.type;


import java.lang.annotation.Annotation;
import javax.lang.model.element.Element;


/**
 * Thrown when an application attempts to access the {@link Class} object
 * corresponding to a {@link TypeMirror}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @version %I% %E%
 * @see MirroredTypesException
 * @see Element#getAnnotation(Class)
 * @since 1.6
 */
public class MirroredTypeException extends RuntimeException {

    private static final long serialVersionUID = 269;

    private transient TypeMirror type;		// cannot be serialized

    /**
     * Constructs a new MirroredTypeException for the specified type.
     *
     * @param type  the type being accessed
     */
    public MirroredTypeException(TypeMirror type) {
	super("Attempt to access Class object for TypeMirror " + type);
	this.type = type;
    }

    /**
     * Returns the type mirror corresponding to the type being accessed.
     * The type mirror may be unavailable if this exception has been
     * serialized and then read back in.
     *
     * @return the type mirror, or {@code null} if unavailable
     */
    public TypeMirror getTypeMirror() {
	return type;
    }
}
