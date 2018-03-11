/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.xml.ws;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.xml.bind.JAXBContext;
import javax.xml.namespace.QName;
import javax.xml.ws.spi.WebServiceFeatureAnnotation;


/**
 * This feature clarifies the use of the <code>wsdl:binding</code>
 * in a JAX-WS runtime.
 * <p>
 * This feature is only useful with web services that have an
 * associated WSDL. Enabling this feature requires that a JAX-WS
 * implementation inspect the <code>wsdl:binding</code> for an
 * endpoint at runtime to make sure that all <code>wsdl:extensions</code>
 * that have the <code>required</code> attribute set to <code>true</code>
 * are understood and are being used.
 * <p>
 * The following describes the affects of this feature with respect
 * to be enabled or disabled:
 * <ul>
 *  <li> ENABLED: In this Mode, a JAX-WS runtime MUST assure that all
 *  required <code>wsdl:binding</code> extensions are either understood
 *  and used by the runtime, or explicitly disabled by the web service
 *  application.  A web service application can disable a particular 
 *  extension that has a known WebServiceFeature using either the appropriate 
 *  annotation associated with that WebServiceFeature on the server, or one of 
 *  the following methods on the client:
 *    <ul>
 *      <li>{@link Service#getPort(QName,Class,WebServiceFeature...)}
 *      <li>{@link Service#getPort(Class,WebServiceFeature...)}
 *      <li>{@link Service#getPort(EndpointReference,Class,WebServiceFeature...)}
 *      <li>{@link Service#createDispatch(QName,Class,Service.Mode mode,WebServiceFeature...)}
 *      <li>{@link Service#createDispatch(EndpointReference,Class,Service.Mode,WebServiceFeature...)}
 *      <li>{@link Service#createDispatch(QName,JAXBContext,Service.Mode,WebServiceFeature...)}
 *      <li>{@link Service#createDispatch(EndpointReference,JAXBContext,Service.Mode,WebServiceFeature...)}
 *      <li>{@link EndpointReference#getPort(Class,WebServiceFeature...)}
 *      <li>One of the <code>getXXXPort(WebServiceFeatures...)</code> methods on a
 *          generated <code>Service</code>.
 *    </ul>
 *    The runtime MUST also make sure that binding of
 *    SEI parameters/return values respect the <code>wsdl:binding</code>.
 *    With this feature enabled, if a required (<code>wsdl:required="true"</code>)
 *    <code>wsdl:binding</code> extension is in the WSDL and it is not
 *    supported by a JAX-WS runtime and it has not
 *    been explicitly turned off by the web service developer, then
 *    that JAX-WS runtime MUST behave appropriately based on whether it is
 *    on the client or server:
 *    <UL>
 *      <li>Client: runtime MUST throw a
 *      <code>WebServiceException</code> no sooner than when one of the methods
 *      above is invoked but no later than the first invocation of an endpoint
 *      operation.
 *      <li>Server: throw a WebServiceException and the endpoint MUST fail to deploy
 *    </ul>
 *  <li> DISABLED: In this Mode, an implementation may choose whether
 *  to inspect the <code>wsdl:binding<code> or not and to what degree
 *  the <code>wsdl:binding</code> will be inspected.  For example,
 *  one implementation may choose to behave as if this feature is enabled,
 *  another implementation may only choose to verify the SEI's
 *  parameter/return type bindings.
 * </ul>
 *
 * @see javax.xml.ws.RespectBindingFeature
 *
 * @since JAX-WS 2.1
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@WebServiceFeatureAnnotation(id=RespectBindingFeature.ID,bean=RespectBindingFeature.class)
public @interface RespectBinding {
    /**
     * Specifies if this feature is enabled or disabled.
     */
    boolean enabled() default true;
}
