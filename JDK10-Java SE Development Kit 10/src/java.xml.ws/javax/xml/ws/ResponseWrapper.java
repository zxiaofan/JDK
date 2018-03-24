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
 * Used to annotate methods in the Service Endpoint Interface with the response
 * wrapper bean to be used at runtime. The default value of the {@code localName} is
 * the {@code operationName} as defined in {@code WebMethod} annotation appended with
 * {@code Response} and the {@code targetNamespace} is the target namespace of the SEI.
 * <p> When starting from Java this annotation is used resolve
 * overloading conflicts in document literal mode. Only the {@code className}
 * is required in this case.
 *
 *  @since 1.6, JAX-WS 2.0
**/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseWrapper {

    /**
     * Element's local name.
     * @return local name
     */
    public String localName() default "";

    /**
     * Element's namespace name.
     * @return target namespace name
     */
    public String targetNamespace() default "";

    /**
     * Response wrapper bean name.
     * @return bean name
     */
    public String className() default "";

    /**
     * wsdl:part name for the wrapper part
     *
     * @return wsdl:part name
     * @since 1.7, JAX-WS 2.2
     */
    public String partName() default "";

}
