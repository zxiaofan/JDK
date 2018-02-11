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

package com.sun.xml.internal.ws.client;

import com.sun.xml.internal.ws.api.WSBinding;
import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLPort;
import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.sun.xml.internal.ws.api.pipe.Tube;
import com.sun.xml.internal.ws.api.pipe.TubeCloner;
import com.sun.xml.internal.ws.api.pipe.helper.AbstractTubeImpl;
import com.sun.xml.internal.ws.api.server.SDDocument;
import com.sun.xml.internal.ws.util.MetadataUtil;
import com.sun.xml.internal.ws.util.pipe.AbstractSchemaValidationTube;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import javax.xml.ws.WebServiceException;
import java.util.Map;
import java.util.logging.Logger;

/**
 * {@link Tube} that does the schema validation on the client side.
 *
 * @author Jitendra Kotamraju
 */
public class ClientSchemaValidationTube extends AbstractSchemaValidationTube {

    private static final Logger LOGGER = Logger.getLogger(ClientSchemaValidationTube.class.getName());

    private final Schema schema;
    private final Validator validator;
    private final boolean noValidation;
    private final WSDLPort port;

    public ClientSchemaValidationTube(WSBinding binding, WSDLPort port, Tube next) {
        super(binding, next);
        this.port = port;
        if (port != null) {
            String primaryWsdl = port.getOwner().getParent().getLocation().getSystemId();
            MetadataResolverImpl mdresolver = new MetadataResolverImpl();
            Map<String, SDDocument> docs = MetadataUtil.getMetadataClosure(primaryWsdl, mdresolver, true);
            mdresolver = new MetadataResolverImpl(docs.values());
            Source[] sources = getSchemaSources(docs.values(), mdresolver);
            for(Source source : sources) {
                LOGGER.fine("Constructing client validation schema from = "+source.getSystemId());
                //printDOM((DOMSource)source);
            }
            if (sources.length != 0) {
                noValidation = false;
                sf.setResourceResolver(mdresolver);
                try {
                    schema = sf.newSchema(sources);
                } catch(SAXException e) {
                    throw new WebServiceException(e);
                }
                validator = schema.newValidator();
                return;
            }
        }
        noValidation = true;
        schema = null;
        validator = null;
    }

    protected Validator getValidator() {
        return validator;
    }

    protected boolean isNoValidation() {
        return noValidation;
    }

    protected ClientSchemaValidationTube(ClientSchemaValidationTube that, TubeCloner cloner) {
        super(that,cloner);
        this.port = that.port;
        this.schema = that.schema;
        this.validator = schema.newValidator();
        this.noValidation = that.noValidation;
    }

    public AbstractTubeImpl copy(TubeCloner cloner) {
        return new ClientSchemaValidationTube(this,cloner);
    }

    @Override
    public NextAction processRequest(Packet request) {
        if (isNoValidation() || !feature.isOutbound() || !request.getMessage().hasPayload() || request.getMessage().isFault()) {
            return super.processRequest(request);
        }
        try {
            doProcess(request);
        } catch(SAXException se) {
            throw new WebServiceException(se);
        }
        return super.processRequest(request);
    }

    @Override
    public NextAction processResponse(Packet response) {
        if (isNoValidation() || !feature.isInbound() || response.getMessage() == null || !response.getMessage().hasPayload() || response.getMessage().isFault()) {
            return super.processResponse(response);
        }
        try {
            doProcess(response);
        } catch(SAXException se) {
            throw new WebServiceException(se);
        }
        return super.processResponse(response);
    }

}
