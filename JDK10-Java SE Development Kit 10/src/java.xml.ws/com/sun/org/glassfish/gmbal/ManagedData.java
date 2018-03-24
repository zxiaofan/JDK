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

/** This annotation defines CompositeData.   An interface or class annotated as @ManagedData
 * has a corresponding CompositeData instance constructed according to the @ManagedAttribute
 * annotations on its methods.  All inherited annotated methods are included.
 * In the case of conflicts, the most derived method is used (that is the method
 * declared in the method
 * closest to the class annotated as @ManagedData).
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ManagedData {
    /** The name of the ManagedData.
     * <P>
     * Gmbal determines the ManagedData name as follows:
     * <ol>
     * <li>If the class has a final static field of type String with the
     * name "GMBAL_TYPE", the value of the field is the ManagedData name.
     * <li>Otherwise, if the class has an @ManagedData annotation, and the
     * value of the name is not "", the value of the name is the ManagedData name.
     * <li>Otherwise, if the package prefix of the class name matches one of
     * the type prefixes added by an stripPrefix call to the ManagedObjectManager,
     * the ManagedData name is the full class name with the matching prefix removed.
     * <li>Otherwise, if the stripPackagePrefix method was called on the
     * ManagedObjectManager, the ManagedData name is the class name without any
     * package prefixes.
     * <li>Otherwise, the ManagedData name is the class name.
     * </ol>
     *
     */
    String name() default "" ;
}
