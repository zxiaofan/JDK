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

/** This annotation is applied to a class or interface representing ManagedData
 * to indicate that the
 * listed subclasses should have their attributes included in the corresponding
 * CompositeData of the superclass.  Any given instance of this class will have
 * values for those attributes that are defined in the parent class
 * or the subclass for the particular type of the instance.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IncludeSubclass {
    /** List of subclasses that should be analyzed for attributes and operations.
     *
     * @return List of classes.
     */
    Class[] value() ;
}
