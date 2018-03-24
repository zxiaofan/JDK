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

package com.sun.xml.internal.ws.wsdl.writer;

import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.api.server.SDDocument;

/**
 * Resolves relative references among the metadata(WSDL, schema)
 * documents.
 *
 * <p>
 * This interface is implemented by the caller of
 * {@link SDDocument#writeTo} method so that the {@link SDDocument} can
 * correctly produce references to other documents.
 *
 * <h2>Usage Example 1</h2>
 * <p>
 * Say: http://localhost/hello?wsdl has reference to
 * <p>
 *   &lt;xsd:import namespace="urn:test:types" schemaLocation="http://localhost/hello?xsd=1"/>
 *
 * <p>
 * Using this class, it is possible to write A.wsdl to a local filesystem with
 * a local file schema import.
 * <p>
 *   &lt;xsd:import namespace="urn:test:types" schemaLocation="hello.xsd"/>
 *
 * @author Jitendra Kotamraju
 */
public interface DocumentLocationResolver {
    /**
     * Produces a relative reference from one document to another.
     *
     * @param namespaceURI
     *      The namespace urI for the referenced document.
     *      for e.g. wsdl:import/@namespace, xsd:import/@namespace
     * @param systemId
     *      The location value for the referenced document.
     *      for e.g. wsdl:import/@location, xsd:import/@schemaLocation
     * @return
     *      The reference to be put inside {@code current} to refer to
     *      {@code referenced}. This can be a relative URL as well as
     *      an absolute. If null is returned, then the document
     *      will produce a "implicit reference" (for example, &lt;xs:import>
     *      without the @schemaLocation attribute, etc).
     */
    @Nullable String getLocationFor(String namespaceURI, String systemId);
}
