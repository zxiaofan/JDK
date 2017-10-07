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

/** This annotation defines an attribute in open MBean (ManagedObject) or
 * CompositeData (ManagedData).  It is useful in cases where the parent class
 * cannot be annotated (for example, Object.toString(), or a framework class
 * that must be extended
 * but cannot be modified).  The attribute id is defined in the annotation, and
 * it is implemented by the methods inherited by the Managed entity.
 * <p>
 * An example of a use of this is to handle @ManagedData that inherits from
 * Collection<X>, and it is desired to display a read-only attribute containing
 * the elements of the Collection.  Simple add the annotation
 * <p>
 * @InheritedAttribute( methodName="iterator" )
 * <p>
 * to handle this case.  Note that this only supports read-only attributes.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedAttribute {
    /** The description of the attribute.  Can be a key to a resource
     * bundle for I18N support. Note that this needs a description, otherwise
     * the InheritedAttributes annotation won't work.  The Description
     * annotation is used in all other cases.  The description cannot be
     * empty.
     * @return The description.
     */
    String description() ;

    /** The name of the attribute,  This class must inherit a method whose name
     * corresponds to this id in one of the standard ways.
     * @return The ID.
     */
    String id() default "" ;

    /** The name of the method implementing this attribute.  At least one of
     * id and methodName must not be empty.  If only one is given, the other
     * is derived according to the extended attribute name rules.
     */
    String methodName() default "" ;
}
