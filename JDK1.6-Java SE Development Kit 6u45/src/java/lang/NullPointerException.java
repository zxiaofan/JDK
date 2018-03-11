/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang;

/**
 * Thrown when an application attempts to use <code>null</code> in a 
 * case where an object is required. These include: 
 * <ul>
 * <li>Calling the instance method of a <code>null</code> object. 
 * <li>Accessing or modifying the field of a <code>null</code> object. 
 * <li>Taking the length of <code>null</code> as if it were an array. 
 * <li>Accessing or modifying the slots of <code>null</code> as if it 
 *     were an array. 
 * <li>Throwing <code>null</code> as if it were a <code>Throwable</code> 
 *     value. 
 * </ul>
 * <p>
 * Applications should throw instances of this class to indicate 
 * other illegal uses of the <code>null</code> object. 
 *
 * @author  unascribed
 * @version %I%, %G%
 * @since   JDK1.0
 */
public
class NullPointerException extends RuntimeException {
    /**
     * Constructs a <code>NullPointerException</code> with no detail message.
     */
    public NullPointerException() {
	super();
    }

    /**
     * Constructs a <code>NullPointerException</code> with the specified 
     * detail message. 
     *
     * @param   s   the detail message.
     */
    public NullPointerException(String s) {
	super(s);
    }
}
