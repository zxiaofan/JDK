/*
 * Copyright (c) 2005, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.ws;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
/**
 * Used to annotate a Provider implementation class.
 *
 * @since 1.6, JAX-WS 2.0
 * @see javax.xml.ws.Provider
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServiceProvider {
    /**
     * Location of the WSDL description for the service.
     *
     * @return location of the WSDL description
     */
    String wsdlLocation() default "";

    /**
     * Service name.
     *
     * @return service name
     */
    String serviceName() default "";

    /**
     * Target namespace for the service
     *
     * @return target namespace
     */
    String targetNamespace() default "";

    /**
     * Port name.
     *
     * @return port name
     */
    String portName() default "";
}
