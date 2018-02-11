/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.developer;

import javax.xml.ws.spi.WebServiceFeatureAnnotation;
import javax.xml.bind.JAXBContext;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This feature instructs that the specified {@link JAXBContextFactory} be used for performing
 * data-binding for the SEI.
 *
 * <p>
 * For example,
 * <pre>
 * &#64;WebService
 * &#64;UsesJAXBContext(MyJAXBContextFactory.class)
 * public class HelloService {
 *   ...
 * }
 * </pre>
 *
 * <p>
 * If your {@link JAXBContextFactory} needs to carry some state from your calling application,
 * you can use {@link UsesJAXBContextFeature} to pass in an instance of {@link JAXBContextFactory},
 * instead of using this to specify the type.
 *
 * @author Kohsuke Kawaguchi
 * @since 2.1.5
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@WebServiceFeatureAnnotation(id=UsesJAXBContextFeature.ID,bean=UsesJAXBContextFeature.class)
public @interface UsesJAXBContext {
    /**
     * Designates the {@link JAXBContextFactory} to be used to create the {@link JAXBContext} object,
     * which in turn will be used by the JAX-WS runtime to marshal/unmarshal parameters and return
     * values to/from XML.
     */
    Class<? extends JAXBContextFactory> value();
}
