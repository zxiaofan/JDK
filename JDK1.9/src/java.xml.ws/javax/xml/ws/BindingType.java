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
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.soap.SOAPBinding;

/**
 *  The {@code BindingType} annotation is used to
 *  specify the binding to use for a web service
 *  endpoint implementation class.
 *  <p>
 *  This annotation may be overridden programmatically or via
 *  deployment descriptors, depending on the platform in use.
 *
 *  @since 1.6, JAX-WS 2.0
 *
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BindingType {
     /**
      * A binding identifier (a URI). If not specified, the default is the SOAP 1.1 / HTTP binding.<br>
      * See the {@link SOAPBinding} and {@link HTTPBinding}
      * for the definition of the standard binding identifiers.
      *
      * @return A binding identifier (a URI)
      * @see javax.xml.ws.Binding
      * @see javax.xml.ws.soap.SOAPBinding#SOAP11HTTP_BINDING
      * @see javax.xml.ws.soap.SOAPBinding#SOAP12HTTP_BINDING
      * @see javax.xml.ws.http.HTTPBinding#HTTP_BINDING
      */
     String value() default "" ;
}
