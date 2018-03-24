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

package com.sun.xml.internal.ws.client.sei;

import com.sun.xml.internal.ws.api.databinding.ClientCallBridge;
import com.sun.xml.internal.ws.model.JavaMethodImpl;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.WebServiceException;

import java.lang.reflect.Method;
import java.util.concurrent.Future;

/**
 * {@link MethodHandler} that uses {@link AsyncHandler}.
 *
 * @author Kohsuke Kawaguchi
 */
final class CallbackMethodHandler extends AsyncMethodHandler {

    /**
     * Position of the argument that takes {@link AsyncHandler}.
     */
    private final int handlerPos;

    CallbackMethodHandler(SEIStub owner, Method m, int handlerPos) {
        super(owner, m);
        this.handlerPos = handlerPos;
    }

//    CallbackMethodHandler(SEIStub owner, JavaMethodImpl jm, JavaMethodImpl core, int handlerPos) {
//        super(owner,jm,core);
//        this.handlerPos = handlerPos;
//    }

    Future<?> invoke(Object proxy, Object[] args) throws WebServiceException {
        // the spec requires the last argument
        final AsyncHandler handler = (AsyncHandler)args[handlerPos];

        return doInvoke(proxy, args, handler);
    }
}
