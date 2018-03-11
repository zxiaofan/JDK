/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.xml.ws;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The <code>FaultAction</code> annotation is used inside an {@link Action}
 * annotation to allow an explicit association of a WS-Addressing 
 * <code>Action</code> message addressing property with the <code>fault</code> 
 * messages of the WSDL operation mapped from the exception class.
 * <p>
 * In this version of JAX-WS there is no standard way to specify 
 * <code>Action</code> values in a WSDL and there is no standard default value.  It is intended that, 
 * after the W3C WG on WS-Addressing has defined these items in a recommendation,
 * a future version of JAX-WS will require the new standards.
 * 
 * @see Action
 *
 * @since JAX-WS 2.1
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FaultAction {
    /**
     * Name of the exception class
     */
    Class className();

    /**
     * Value of WS-Addressing <code>Action</code> message addressing property for the exception
     */
    String value() default "";
}
