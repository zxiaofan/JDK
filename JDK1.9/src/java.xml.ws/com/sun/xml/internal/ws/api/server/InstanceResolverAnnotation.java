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

package com.sun.xml.internal.ws.api.server;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * Meta annotation for selecting instance resolver.
 *
 * <p>
 * When service class is annotated with an annotation that has
 * {@link InstanceResolverAnnotation} as meta annotation, the JAX-WS RI
 * runtime will use the instance resolver class specified on {@link #value()}.
 *
 * <p>
 * The {@link InstanceResolver} class must have the public constructor that
 * takes {@link Class}, which represents the type of the service.
 *
 * <p>
 * See {@link com.sun.xml.internal.ws.developer.Stateful} for a real example. This annotation is only for
 * advanced users of the JAX-WS RI.
 *
 * @since JAX-WS 2.1
 * @see com.sun.xml.internal.ws.developer.Stateful
 * @author Kohsuke Kawaguchi
 */
@Target(ANNOTATION_TYPE)
@Retention(RUNTIME)
@Documented
public @interface InstanceResolverAnnotation {
    Class<? extends InstanceResolver> value();
}
