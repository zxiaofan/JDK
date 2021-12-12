/*
 * Copyright (c) 1999, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.io.ObjectInputStream;


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
     * @serial A string representation of the attribute that originated this exception.
     * For example, the string value can be the return of {@code attribute.toString()}.
     */
    @SuppressWarnings("serial") // See handling in constructor and readObject
    private String val;

    /**
     * Constructs a BadAttributeValueExpException using the specified Object to
     * create the toString() value.
     *
     * @param val the inappropriate value.
     */
    public BadAttributeValueExpException (Object val) {
        this.val = val == null ? null : val.toString();
    }


    /**
     * Returns the string representing the object.
     */
    public String toString()  {
        return "BadAttributeValueException: " + val;
    }

    /**
     * Restores the fields of a BadAttributeValueExpException from the stream.
     * If the 'val' field in the stream does not contain a string
     * it is replaced with an implementation specific string representation
     * of the value in the stream.
     *
     * @param ois an ObjectInput Stream
     * @throws IOException thrown if an error occurs
     * @throws ClassNotFoundException if a class can not be found
     */
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField gf = ois.readFields();
        Object valObj = gf.get("val", null);

        if (valObj instanceof String || valObj == null) {
            val = (String)valObj;
        } else { // the serialized object is from a version without JDK-8019292 fix
            val = System.identityHashCode(valObj) + "@" + valObj.getClass().getName();
        }
    }
 }
