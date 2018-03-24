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

package javax.xml.ws.spi;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.RespectBinding;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.MTOM;

/**
 * Annotation used to identify other annotations
 * as a {@code WebServiceFeature}.
 * <p>
 * Each {@code WebServiceFeature} annotation annotated with
 * this annotation MUST contain an
 * {@code enabled} property of type
 * {@code boolean} with a default value of {@code true}.
 * <p>
 * JAX-WS defines the following
 * {@code WebServiceFeature} annotations ({@code Addressing},
 * {@code MTOM}, {@code RespectBinding}), however, an implementation
 * may define vendors specific annotations for other features.
 * <p>
 * Annotations annotated with {@code WebServiceFeatureAnnotation} MUST
 * have the same @Target of {@link WebServiceRef} annotation, so that the resulting
 * feature annotation can be used in conjunction with the {@link WebServiceRef}
 * annotation if necessary.
 * <p>
 * If a JAX-WS implementation encounters an annotation annotated
 * with the {@code WebServiceFeatureAnnotation} that it does not
 * recognize/support an error MUST be given.
 *
 * @see Addressing
 * @see MTOM
 * @see RespectBinding
 *
 * @since 1.6, JAX-WS 2.1
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServiceFeatureAnnotation {
    /**
     * Unique identifier for the WebServiceFeature.  This
     * identifier MUST be unique across all implementations
     * of JAX-WS.
     * @return unique identifier for the WebServiceFeature
     */
    String id();

    /**
     * The {@code WebServiceFeature} bean that is associated
     * with the {@code WebServiceFeature} annotation
     * @return the {@code WebServiceFeature} bean
     */
    Class<? extends WebServiceFeature> bean();
}
