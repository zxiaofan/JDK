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

package com.sun.xml.internal.ws.api.wsdl.writer;

import com.sun.xml.internal.txw2.TypedXmlWriter;
import com.sun.xml.internal.ws.api.model.SEIModel;
import com.sun.xml.internal.ws.api.WSBinding;
import com.sun.xml.internal.ws.api.server.Container;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * WSDLGeneatorContext provides a context for the WSDLGeneratorExtension and is used in
 * {@link WSDLGeneratorExtension#start(WSDLGenExtnContext)}. This context consists of TXW, {@link SEIModel},
 * {@link WSBinding}, {@link Container}, and implementation class. WSDL extensions are used to
 * extend the generated WSDL by adding implementation specific extensions.
 *
 * @author Jitendra Kotamraju
 */
public class WSDLGenExtnContext {
    private final TypedXmlWriter root;
    private final SEIModel model;
    private final WSBinding binding;
    private final Container container;
    private final Class endpointClass;

    /**
     * Constructs WSDL Generation context for the extensions
     *
     * @param root      This is the root element of the generated WSDL.
     * @param model     WSDL is being generated from this {@link SEIModel}.
     * @param binding   The binding for which we generate WSDL. the binding {@link WSBinding} represents a particular
     *                  configuration of JAXWS. This can be typically be overriden by
     * @param container The entry point to the external environment.
     *                  If this extension is used at the runtime to generate WSDL, you get a {@link Container}
     *                  that was given to {@link com.sun.xml.internal.ws.api.server.WSEndpoint#create}.
     */
    public WSDLGenExtnContext(@NotNull TypedXmlWriter root, @NotNull SEIModel model, @NotNull WSBinding binding,
                              @Nullable Container container, @NotNull Class endpointClass) {
        this.root = root;
        this.model = model;
        this.binding = binding;
        this.container = container;
        this.endpointClass = endpointClass;
    }

    public TypedXmlWriter getRoot() {
        return root;
    }

    public SEIModel getModel() {
        return model;
    }

    public WSBinding getBinding() {
        return binding;
    }

    public Container getContainer() {
        return container;
    }

    public Class getEndpointClass() {
        return endpointClass;
    }

}
