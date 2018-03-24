/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
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


package com.sun.org.glassfish.gmbal ;

import java.lang.annotation.Documented ;
import java.lang.annotation.Target ;
import java.lang.annotation.ElementType ;
import java.lang.annotation.Retention ;
import java.lang.annotation.RetentionPolicy ;

/** This annotation defines an attribute in either CompositeData (ManagedData) or
 * an open MBean (ManagedObject).  An attribute may be read/write (has a setter
 * and a getter), read only (only has a getter),
 * or write only (only has a setter) depending on the declared methods in the class.
 * <p>
 * A method defines a getter if it returns a non-void type and takes no argument types.
 * Likewise a method defines a setter if it return void and takes exactly one
 * argument.
 * <p>An id is derived from a method name as follows:
 * <ol>
 * <li>If the method is a getter, and has a name of the form getXXX, the derived
 * id is xXX (note the initial lower case change).
 * <li>If the method is a getter with a boolean return type, and has a name of
 * the form isXXX, the derived id is xXX
 * <li>If the method is a setter, and has a name of the form setXXX, the
 * detived id is xXX.
 * <li>Otherwise the derived ID is the method name.
 * </ol>
 * <p>
 * In certain cases, a field annotated with @ManagedAttribute
 * may also represent a read-only attribute.
 * The field must be final, and its type must be one of:
 * <ol>
 * <li>A primitive type (boolean, byte, short, char, int, long, float, double)
 * <li>A primitive type wrapper (Boolean, Byte, Short, Character, Integer,
 * Long, Float, Double)
 * <li>A String
 * <li>A BigDecimal or BigInteger
 * <li>A java.util.Date
 * <li>An ObjectName
 * <li>An enum (which is translated to its ordinal name)
 * </ol>
 * Any such field can be accessed safely by multiple threads, because its value
 * cannot change after an instance of the containing class has completed its
 * constructor.  Note that Date is not truly immutable (it should be!), but it's
 * one of the Open MBean simple types, so it is included here.
 */
@Documented
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ManagedAttribute {
    /** The id of the attribute.  Defaults to value derived from method name.
     * @return The id (default "").
     */
    String id() default "" ;
}
