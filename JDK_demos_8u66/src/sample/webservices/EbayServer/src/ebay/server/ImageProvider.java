package sample.webservices.EbayServer.src.ebay.server;
/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */


import java.io.StringReader;
import javax.xml.ws.WebServiceContext;
import java.io.ByteArrayInputStream;
import javax.xml.ws.Provider;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.handler.MessageContext;
import javax.annotation.Resource;
import javax.xml.ws.http.HTTPException;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import javax.xml.ws.WebServiceException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.activation.DataHandler;
import javax.jws.HandlerChain;
import javax.activation.DataSource;
import java.io.OutputStream;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.BindingType;

@WebServiceProvider
@BindingType(HTTPBinding.HTTP_BINDING)
@ServiceMode(value=Service.Mode.MESSAGE)
public class ImageProvider implements Provider<DataSource> {

    @Resource
    protected WebServiceContext wsContext;

    public DataSource invoke(DataSource ds) {
        MessageContext mc = wsContext.getMessageContext();
        String method = (String)mc.get(MessageContext.HTTP_REQUEST_METHOD);
        if (method.equals("GET")) {
            return get(ds, mc);
                }
        HTTPException ex = new HTTPException(404);
        throw ex;
    }


    private DataSource get(DataSource source, MessageContext mc) {
        final String image;
        String path = (String)mc.get(MessageContext.PATH_INFO);
//        System.out.println("PathInfo = "+path);
        if (path != null && path.equals("/sun_blade_1000_h400px.jpg")) {
            image = "images/sun_blade_1000_h400px.jpg";
        }else if(path != null && path.equals("/Sun_Fire_E20K_Server.jpg")) {
            image = "images/Sun_Fire_E20K_Server.jpg";
        } else if (path != null && path.equals("/8d_2.jpg")) {
            image = "images/8d_2.jpg";
        } else {
            HTTPException ex = new HTTPException(404);
            throw ex;
        }
            return new DataSource() {
                                public InputStream getInputStream() {
                                        return this.getClass().getClassLoader().
getResourceAsStream(
                                                image);
                                }
                                public OutputStream getOutputStream() {
                                        return null;
                                }
                                public String getContentType() {
                                        return "image/jpeg";
                                }
                                public String getName() {
                                        return "";
                                }
                        };
        }
}
