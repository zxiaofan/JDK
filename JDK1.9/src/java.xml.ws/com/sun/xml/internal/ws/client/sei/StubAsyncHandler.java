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

package com.sun.xml.internal.ws.client.sei;

import java.util.List;

import javax.jws.soap.SOAPBinding.Style;

import com.sun.xml.internal.ws.api.message.MessageContextFactory;
import com.sun.xml.internal.ws.model.JavaMethodImpl;
import com.sun.xml.internal.ws.model.ParameterImpl;
import com.sun.xml.internal.ws.model.WrapperParameter;

public class StubAsyncHandler extends StubHandler {

    private final Class asyncBeanClass;

        public StubAsyncHandler(JavaMethodImpl jm, JavaMethodImpl sync, MessageContextFactory mcf) {
        super(sync, mcf);

        List<ParameterImpl> rp = sync.getResponseParameters();
        int size = 0;
        for( ParameterImpl param : rp ) {
            if (param.isWrapperStyle()) {
                WrapperParameter wrapParam = (WrapperParameter)param;
                size += wrapParam.getWrapperChildren().size();
                if (sync.getBinding().getStyle() == Style.DOCUMENT) {
                    // doc/asyncBeanClass - asyncBeanClass bean is in async signature
                    // Add 2 or more so that it is considered as async bean case
                    size += 2;
                }
            } else {
                ++size;
            }
        }

        Class tempWrap = null;
        if (size > 1) {
            rp = jm.getResponseParameters();
            for(ParameterImpl param : rp) {
                if (param.isWrapperStyle()) {
                    WrapperParameter wrapParam = (WrapperParameter)param;
                    if (sync.getBinding().getStyle() == Style.DOCUMENT) {
                        // doc/asyncBeanClass style
                        tempWrap = (Class)wrapParam.getTypeInfo().type;
                        break;
                    }
                    for(ParameterImpl p : wrapParam.getWrapperChildren()) {
                        if (p.getIndex() == -1) {
                            tempWrap = (Class)p.getTypeInfo().type;
                            break;
                        }
                    }
                    if (tempWrap != null) {
                        break;
                    }
                } else {
                    if (param.getIndex() == -1) {
                        tempWrap = (Class)param.getTypeInfo().type;
                        break;
                    }
                }
            }
        }
        asyncBeanClass = tempWrap;

        switch(size) {
            case 0 :
                responseBuilder = buildResponseBuilder(sync, ValueSetterFactory.NONE);
                break;
            case 1 :
                responseBuilder = buildResponseBuilder(sync, ValueSetterFactory.SINGLE);
                break;
            default :
                responseBuilder = buildResponseBuilder(sync, new ValueSetterFactory.AsyncBeanValueSetterFactory(asyncBeanClass));
        }

    }

        protected void initArgs(Object[] args) throws Exception {
        if (asyncBeanClass != null) {
            args[0] = asyncBeanClass.newInstance();
        }
        }

    ValueGetterFactory getValueGetterFactory() {
        return ValueGetterFactory.ASYNC;
    }
}
