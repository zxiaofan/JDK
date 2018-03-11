/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.xml.ws.spi;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.xml.ws.WebServiceFeature;

/**
 * Annotation used to identify other annotations
 * as a <code>WebServiceFeature</code>.
 *
 * Each <code>WebServiceFeature</code> annotation annotated with
 * this annotation MUST contain an 
 * <code>enabled</code> property of type
 * <code>boolean</code> with a default value of <code>true</code>. 
 * JAX-WS defines the following
 * <code>WebServiceFeature</code> annotations (<code>Addressing</code>, 
 * <code>MTOM</code>, <code>RespectBinding</code>), however, an implementation
 * may define vendors specific annotations for other features.
 * If a JAX-WS implementation encounters an annotation annotated
 * with the <code>WebServiceFeatureAnnotation</code> that it does not
 * recognize/support an error MUST be given.
 *
 * @see javax.xml.ws.soap.Addressing
 * @see javax.xml.ws.soap.MTOM
 * @see javax.xml.ws.RespectBinding
 *
 * @since JAX-WS 2.1
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServiceFeatureAnnotation {
    /**
     * Unique identifier for the WebServiceFeature.  This 
     * identifier MUST be unique across all implementations
     * of JAX-WS.
     */
    String id();

    /**
     * The <code>WebServiceFeature</code> bean that is associated
     * with the <code>WebServiceFeature</code> annotation
     */
    Class<? extends WebServiceFeature> bean();
}
