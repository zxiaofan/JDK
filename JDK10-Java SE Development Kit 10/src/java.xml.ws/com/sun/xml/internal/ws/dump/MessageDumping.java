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

package com.sun.xml.internal.ws.dump;


import javax.xml.ws.spi.WebServiceFeatureAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Marek Potociar (marek.potociar at sun.com)
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@WebServiceFeatureAnnotation(id = MessageDumpingFeature.ID, bean = MessageDumpingFeature.class)
public @interface MessageDumping {
    /**
     * Specifies if this feature is enabled or disabled.
     */
    boolean enabled() default true;

    /**
     * Message logging root
     */
    String messageLoggingRoot() default MessageDumpingTube.DEFAULT_MSGDUMP_LOGGING_ROOT;

    /**
     * Message logging level
     */
    String messageLoggingLevel() default "FINE";

    /**
     * Turns on or off storing messages
     */
    boolean storeMessages() default false;
}
