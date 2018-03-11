/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang.annotation;

/**
 * Thrown when the annotation parser attempts to read an annotation
 * from a class file and determines that the annotation is malformed.
 *
 * @author  Josh Bloch
 * @since   1.5
 */
public class AnnotationFormatError extends Error {
    /**
     * Constructs a new <tt>AnnotationFormatError</tt> with the specified
     * detail message. 
     *
     * @param   message   the detail message.
     */
    public AnnotationFormatError(String message) {
	super(message);
    }

    /**
     * Constructs a new <tt>AnnotationFormatError</tt> with the specified
     * detail message and cause.  Note that the detail message associated
     * with <code>cause</code> is <i>not</i> automatically incorporated in
     * this error's detail message.
     *
     * @param  message the detail message 
     * @param  cause the cause (A <tt>null</tt> value is permitted, and
     *     indicates that the cause is nonexistent or unknown.)
     */
    public AnnotationFormatError(String message, Throwable cause) {
        super(message, cause);
    }


    /**
     * Constructs a new <tt>AnnotationFormatError</tt> with the specified
     * cause and a detail message of
     * <tt>(cause == null ? null : cause.toString())</tt> (which
     * typically contains the class and detail message of <tt>cause</tt>).
     *
     * @param  cause the cause (A <tt>null</tt> value is permitted, and
     *     indicates that the cause is nonexistent or unknown.)
     */
    public AnnotationFormatError(Throwable cause) {
        super(cause);
    }
}
