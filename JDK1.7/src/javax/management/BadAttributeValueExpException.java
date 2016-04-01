/*
 * Copyright (c) 1999, 2003, Oracle and/or its affiliates. All rights reserved.
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

package javax.management;


/**
 * Thrown when an invalid MBean attribute is passed to a query
 * constructing method.  This exception is used internally by JMX
 * during the evaluation of a query.  User code does not usually
 * see it.
 *
 * @since 1.5
 */
public class BadAttributeValueExpException extends Exception   {


    /* Serial version */
    private static final long serialVersionUID = -3105272988410493376L;

    /**
     * @serial The attribute value that originated this exception
     */
    private Object val;

    /**
     * Constructs an <CODE>BadAttributeValueExpException</CODE> with the specified Object.
     *
     * @param val the inappropriate value.
     */
    public BadAttributeValueExpException (Object val) {
        this.val = val;
    }


    /**
     * Returns the string representing the object.
     */
    public String toString()  {
        return "BadAttributeValueException: " + val;
    }

 }
