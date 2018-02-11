/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.model;

import com.sun.xml.internal.ws.api.model.ParameterBinding;
import com.sun.xml.internal.ws.binding.WebServiceFeatureList;

import javax.jws.WebParam.Mode;
import javax.xml.namespace.QName;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Creates SOAP specific RuntimeModel
 *
 * @author Vivek Pandey
 */
public class SOAPSEIModel extends AbstractSEIModelImpl {

        private final Lock lock = new ReentrantLock();

    public SOAPSEIModel(WebServiceFeatureList features) {
        super(features);
    }

    @Override
    protected void populateMaps() {
        int emptyBodyCount = 0;
        for(JavaMethodImpl jm : getJavaMethods()){
            put(jm.getMethod(), jm);
            boolean bodyFound = false;
            for(ParameterImpl p:jm.getRequestParameters()){
                ParameterBinding binding = p.getBinding();
                if(binding.isBody()){
                    put(p.getName(), jm);
                    bodyFound = true;
                }
            }
            if(!bodyFound){
                put(emptyBodyName, jm);
//                System.out.println("added empty body for: "+jm.getMethod().getName());
                emptyBodyCount++;
            }
        }
        if(emptyBodyCount > 1){
            //TODO throw exception
//            System.out.println("Error: Unqiue signature violation - more than 1 empty body!");
        }
    }

    public Set<QName> getKnownHeaders() {
        Set<QName> headers = new HashSet<QName>();

        try{
                lock.lock();
            for (JavaMethodImpl method : getJavaMethods()) {
             // fill in request headers
             Iterator<ParameterImpl> params = method.getRequestParameters().iterator();
             fillHeaders(params, headers, Mode.IN);

            // fill in response headers
             params = method.getResponseParameters().iterator();
             fillHeaders(params, headers, Mode.OUT);
                          }
        }finally
        {
                lock.unlock();
         }
        return headers;
    }

    /**
     * @param params
     * @param headers
     */
    private void fillHeaders(Iterator<ParameterImpl> params, Set<QName> headers, Mode mode) {
        while (params.hasNext()) {
            ParameterImpl param = params.next();
            ParameterBinding binding = (mode == Mode.IN)?param.getInBinding():param.getOutBinding();
            QName name = param.getName();
            if (binding.isHeader() && !headers.contains(name)) {
                headers.add(name);
            }
        }
    }
}
