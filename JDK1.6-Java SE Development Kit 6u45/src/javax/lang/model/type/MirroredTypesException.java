/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.lang.model.type;


import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import javax.lang.model.element.Element;


/**
 * Thrown when an application attempts to access a sequence of {@link
 * Class} objects each corresponding to a {@link TypeMirror}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @version %I% %E%
 * @see MirroredTypeException
 * @see Element#getAnnotation(Class)
 * @since 1.6
 */
public class MirroredTypesException extends RuntimeException {

    private static final long serialVersionUID = 269;

    // Should this be non-final for a custum readObject method?
    private final transient List<? extends TypeMirror> types;	// cannot be serialized
    
    /**
     * Constructs a new MirroredTypesException for the specified types.
     *
     * @param types  the types being accessed
     */
    public MirroredTypesException(List<? extends TypeMirror> types) {
	super("Attempt to access Class objects for TypeMirrors " + types);
	this.types = Collections.unmodifiableList(types);
    }

    /**
     * Returns the type mirrors corresponding to the types being accessed.
     * The type mirrors may be unavailable if this exception has been
     * serialized and then read back in.
     *
     * @return the type mirrors in construction order, or {@code null} if unavailable
     */
    public List<? extends TypeMirror> getTypeMirrors() {
	return types;
    }
}
