/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http;

import java.net.ConnectException;
import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpTimeoutException;
import jdk.internal.net.http.common.Logger;
import jdk.internal.net.http.common.Utils;

public class ResponseTimerEvent extends TimeoutEvent {
    private static final Logger debug =
            Utils.getDebugLogger("ResponseTimerEvent"::toString, Utils.DEBUG);

    private final MultiExchange<?> multiExchange;

    static ResponseTimerEvent of(MultiExchange<?> exchange) {
        return new ResponseTimerEvent(exchange);
    }

    private ResponseTimerEvent(MultiExchange<?> multiExchange) {
        super(multiExchange.exchange.request.timeout().get());
        this.multiExchange = multiExchange;
    }

    @Override
    public void handle() {
        if (debug.on()) {
            debug.log("Cancelling MultiExchange due to timeout for request %s",
                      multiExchange.exchange.request);
        }
        HttpTimeoutException t = null;

        // more specific, "request timed out", message when connected
        Exchange<?> exchange = multiExchange.getExchange();
        if (exchange != null) {
            ExchangeImpl<?> exchangeImpl = exchange.exchImpl;
            if (exchangeImpl != null) {
                if (exchangeImpl.connection().connected()) {
                    t = new HttpTimeoutException("request timed out");
                }
            }
        }
        if (t == null) {
            t = new HttpConnectTimeoutException("HTTP connect timed out");
            t.initCause(new ConnectException("HTTP connect timed out"));
        }
        multiExchange.cancel(t);
    }

    @Override
    public String toString() {
        return "ResponseTimerEvent[" + super.toString() + "]";
    }
}
