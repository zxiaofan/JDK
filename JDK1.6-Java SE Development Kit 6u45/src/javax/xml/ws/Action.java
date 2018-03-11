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

import javax.xml.ws.soap.Addressing;

/**

 * The <code>Action</code> annotation allows explicit association of a 
 * WS-Addressing <code>Action</code> message addressing property with 
 * <code>input</code>, <code>output</code>, and 
 * <code>fault</code> messages of the mapped WSDL operation. 
 * <p>
 * In this version of JAX-WS there is no standard way to specify 
 * <code>Action</code> values in a WSDL and there is no standard default value.  It is intended that, 
 * after the W3C WG on WS-Addressing has defined these items in a recommendation,
 * a future version of JAX-WS will require the new standards.
 * 
 * @see Addressing
 * @see FaultAction
 *
 * @since JAX-WS 2.1
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Action {
    /**
     * Explicit value of the WS-Addressing <code>Action</code> message addressing property for the <code>input</code>
     * message of the operation. 
     */
    String input() default "";

    /**
     * Explicit value of the WS-Addressing <code>Action</code> message addressing property for the <code>output</code>
     * message of the operation. 
     */
    String output() default "";
    
    /**
     * Explicit value of the WS-Addressing <code>Action</code> message addressing property for the <code>fault</code>
     * message(s) of the operation. Each exception that is mapped to a fault and requires an explicit WS-Addressing
     * <code>Action</code> message addressing property, needs to be specified as a value in this property 
     * using {@link FaultAction} annotation.
     */
    FaultAction[] fault() default { };
}
