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

/** This annotation is applied to a method that takes no arguments and returns a value
 * that is converted into a String for use in the ObjectName when an instance of the enclosing
 * class is used to construct an open MBean.
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
    /** The description to be applied to the annotated element.
     * This value must not be empty.  It can either be the actual string that is inserted
     * into the MBean info class, or a key into a resource bundle associated with the
     * ManagedObjectManager.  If there is no bundle value associated with the key, or no
     * resource bundle is specified, the value is used directly in the MBean info class.
     */
    String value() ;

    /** Optional key to use in a resource bundle for this description. If present,
     * a gmbal tool will generate a resource bundle that contains key=value taken
     * from the description annotation.
     * <p>
     * If this key is not present, the default key is given by the class name,
     * if this annotation appears on a class, or the class name.method name if
     * this annotation appears on a method.  It is an error to use the default
     * value for more than one method of the same name, except for setters and getters.
     *
     */
    String key() default "" ;
}
