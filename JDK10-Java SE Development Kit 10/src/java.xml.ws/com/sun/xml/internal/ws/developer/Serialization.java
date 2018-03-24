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
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Configures various aspects of serialization like encoding
 *
 * <pre>
 * for e.g.:
 *
 * &#64;WebService
 * &#64;Serialization(encoding="Shift_JIS")
 * public class HelloImpl {
 *   ...
 * }
 * </pre>
 *
 *
 * @since JAX-WS RI 2.2.6
 * @author Jitendra Kotamraju
 * @see com.sun.xml.internal.ws.developer.SerializationFeature
 */
@Retention(RUNTIME)
@Target({TYPE, ElementType.METHOD, ElementType.FIELD})
@Documented
@WebServiceFeatureAnnotation(id = SerializationFeature.ID, bean = SerializationFeature.class)
public @interface Serialization {

    /**
     * Turns validation on/off for inbound messages
     *
     * @since JAX-WS RI 2.2.6
     */
    String encoding() default "";

}
