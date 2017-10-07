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
import java.lang.annotation.*;
import java.io.File;

/**
 * This feature represents the use of StreamingAttachment attachments with a
 * web service.
 *
 * <p>
 * for e.g.: To keep all MIME attachments in memory, do the following
 *
 * <pre>
 * &#64;WebService
 * &#64;MIME(memoryThreshold=-1L)
 * public class HelloService {
 * }
 * </pre>
 *
 * @see StreamingAttachmentFeature
 *
 * @author Jitendra Kotamraju
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Documented
@WebServiceFeatureAnnotation(id = StreamingAttachmentFeature.ID, bean = StreamingAttachmentFeature.class)
public @interface StreamingAttachment {

    /**
     * Directory in which large attachments are stored. {@link File#createTempFile}
     * methods are used to create temp files for storing attachments. This
     * value is used in {@link File#createTempFile}, if specified. If a file
     * cannot be created in this dir, then all the content is kept in memory.
     */
    String dir() default "";

    /**
     * MIME message is parsed eagerly.
     */
    boolean parseEagerly() default false;

    /**
     * After this threshold(no of bytes per attachment), large attachment is
     * written to file system.
     *
     * If the value is -1, then all the attachment content is kept in memory.
     */
    long memoryThreshold() default 1048576L;

}
