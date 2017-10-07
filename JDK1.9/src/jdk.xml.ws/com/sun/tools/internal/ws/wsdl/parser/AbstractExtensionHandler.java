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

package com.sun.tools.internal.ws.wsdl.parser;

import com.sun.tools.internal.ws.api.wsdl.TWSDLExtensible;
import com.sun.tools.internal.ws.api.wsdl.TWSDLExtensionHandler;
import com.sun.tools.internal.ws.api.wsdl.TWSDLParserContext;
import com.sun.tools.internal.ws.wsdl.document.mime.MIMEConstants;
import org.w3c.dom.Element;

import java.util.Collections;
import java.util.Map;

/**
 * An abstract implementation class of {@link TWSDLExtensionHandler}
 *
 * @author Vivek Pandey
 */
public abstract class AbstractExtensionHandler extends TWSDLExtensionHandler {
    private final Map<String, AbstractExtensionHandler> extensionHandlers;
    private final Map<String, AbstractExtensionHandler> unmodExtenHandlers;

    public AbstractExtensionHandler(Map<String, AbstractExtensionHandler> extensionHandlerMap) {
        this.extensionHandlers = extensionHandlerMap;
        this.unmodExtenHandlers = Collections.unmodifiableMap(extensionHandlers);
    }

    public Map<String, AbstractExtensionHandler> getExtensionHandlers(){
        return unmodExtenHandlers;
    }

    /**
     * Callback that gets called by the WSDL parser or any other extension handler on finding an extensibility element
     * that it can't understand.
     *
     * @param parent  The Parent element within which the extensibility element is defined
     * @param e       The extensibility elemenet
     * @return false if there was some error during the extension handling otherwise returns true. If returned false
     *         then the WSDL parser can abort if the wsdl extensibility element had <code>required</code> attribute set to true
     */
    public boolean doHandleExtension(TWSDLParserContext context, TWSDLExtensible parent, Element e) {
        if (parent.getWSDLElementName().equals(MIMEConstants.QNAME_PART)) {
            return handleMIMEPartExtension(context, parent, e);
        } else {
            return super.doHandleExtension(context, parent, e);
        }
    }

    /**
     * Callback for <code>wsdl:mime</code>
     *
     * @param context Parser context that will be passed on by the wsdl parser
     * @param parent  The Parent element within which the extensibility element is defined
     * @param e       The extensibility elemenet
     * @return false if there was some error during the extension handling otherwise returns true. If returned false
     *         then the WSDL parser can abort if the wsdl extensibility element had <code>required</code> attribute set to true
     */
    protected boolean handleMIMEPartExtension(TWSDLParserContext context, TWSDLExtensible parent, Element e){
        return false;
    }
}
