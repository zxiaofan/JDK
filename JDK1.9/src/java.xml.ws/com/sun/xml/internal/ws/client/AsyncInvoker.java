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

import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.pipe.Fiber.CompletionCallback;
import com.sun.xml.internal.ws.api.pipe.Tube;

import javax.xml.ws.WebServiceException;

/**
 * Invokes {@link Tube}line asynchronously for the client's async API(for e.g.: Dispatch#invokeAsync}
 * The concrete classes need to call {@link Stub#processAsync(AsyncResponseImpl, Packet, RequestContext, Fiber.CompletionCallback) } in
 * run() method.
 *
 * @author Jitendra Kotamraju
 */
public abstract class AsyncInvoker implements Runnable {
    /**
     * Because of the object instantiation order,
     * we can't take this as a constructor parameter.
     */
    protected AsyncResponseImpl responseImpl;
    protected boolean nonNullAsyncHandlerGiven;

    public void setReceiver(AsyncResponseImpl responseImpl) {
        this.responseImpl = responseImpl;
    }

  public AsyncResponseImpl getResponseImpl() {
    return responseImpl;
  }

  public void setResponseImpl(AsyncResponseImpl responseImpl) {
    this.responseImpl = responseImpl;
  }

  public boolean isNonNullAsyncHandlerGiven() {
    return nonNullAsyncHandlerGiven;
  }

  public void setNonNullAsyncHandlerGiven(boolean nonNullAsyncHandlerGiven) {
    this.nonNullAsyncHandlerGiven = nonNullAsyncHandlerGiven;
  }

  public void run () {
        try {
            do_run();
        }catch(WebServiceException e) {
            throw e;
        }catch(Throwable t) {
            //Wrap it in WebServiceException
            throw new WebServiceException(t);
        }
    }

    public abstract void do_run();
}
