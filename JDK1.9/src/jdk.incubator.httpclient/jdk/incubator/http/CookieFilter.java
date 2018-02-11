/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.incubator.http;

import java.io.IOException;
import java.net.CookieManager;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jdk.incubator.http.internal.common.HttpHeadersImpl;
import jdk.incubator.http.internal.common.Log;

class CookieFilter implements HeaderFilter {

    public CookieFilter() {
    }

    @Override
    public void request(HttpRequestImpl r, MultiExchange<?,?> e) throws IOException {
        HttpClientImpl client = e.client();
        Optional<CookieManager> cookieManOpt = client.cookieManager();
        if (cookieManOpt.isPresent()) {
            CookieManager cookieMan = cookieManOpt.get();
            Map<String,List<String>> userheaders = r.getUserHeaders().map();
            Map<String,List<String>> cookies = cookieMan.get(r.uri(), userheaders);

            // add the returned cookies
            HttpHeadersImpl systemHeaders = r.getSystemHeaders();
            if (cookies.isEmpty()) {
                Log.logTrace("Request: no cookie to add for {0}",
                             r.uri());
            } else {
                Log.logTrace("Request: adding cookies for {0}",
                             r.uri());
            }
            for (String hdrname : cookies.keySet()) {
                List<String> vals = cookies.get(hdrname);
                for (String val : vals) {
                    systemHeaders.addHeader(hdrname, val);
                }
            }
        } else {
            Log.logTrace("Request: No cookie manager found for {0}",
                         r.uri());
        }
    }

    @Override
    public HttpRequestImpl response(Response r) throws IOException {
        HttpHeaders hdrs = r.headers();
        HttpRequestImpl request = r.request();
        Exchange<?> e = r.exchange;
        Log.logTrace("Response: processing cookies for {0}", request.uri());
        Optional<CookieManager> cookieManOpt = e.client().cookieManager();
        if (cookieManOpt.isPresent()) {
            CookieManager cookieMan = cookieManOpt.get();
            Log.logTrace("Response: parsing cookies from {0}", hdrs.map());
            cookieMan.put(request.uri(), hdrs.map());
        } else {
            Log.logTrace("Response: No cookie manager found for {0}",
                         request.uri());
        }
        return null;
    }
}
