/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.oracle.webservices.internal.api.databinding;

import javax.xml.transform.Result;
import javax.xml.ws.Holder;

/**
 * WSDLResolver is used by WSDLGenerator while generating WSDL and its associated
 * documents. It is used to control what documents need to be generated and what
 * documents need to be picked from metadata. If endpont's document metadata
 * already contains some documents, their systemids may be used for wsdl:import,
 * and schema:import. The suggested filenames are relative urls(for e.g: EchoSchema1.xsd)
 * The Result object systemids are also relative urls(for e.g: AbsWsdl.wsdl).
 *
 * @author Jitendra Kotamraju
 */
public interface WSDLResolver {
    /**
     * Create a Result object into which concrete WSDL is to be generated.
     *
     * @return Result for the concrete WSDL
     */
    public Result getWSDL(String suggestedFilename);

    /**
     * Create a Result object into which abstract WSDL is to be generated. If the the
     * abstract WSDL is already in metadata, it is not generated.
     *
     * Update filename if the suggested filename need to be changed in wsdl:import.
     * This needs to be done if the metadata contains abstract WSDL, and that systemid
     * needs to be reflected in concrete WSDL's wsdl:import
     *
     * @return null if abstract WSDL need not be generated
     */
    public Result getAbstractWSDL(Holder<String> filename);

    /**
     * Create a Result object into which schema doc is to be generated. Typically if
     * there is a schema doc for namespace in metadata, then it is not generated.
     *
     * Update filename if the suggested filename need to be changed in xsd:import. This
     * needs to be done if the metadata contains the document, and that systemid
     * needs to be reflected in some other document's xsd:import
     *
     * @return null if schema need not be generated
     */
    public Result getSchemaOutput(String namespace, Holder<String> filename);

}
