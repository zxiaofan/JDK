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

package com.sun.xml.internal.ws.streaming;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> A prefix factory that caches the prefixes it creates. </p>
 *
 * @author WS Development Team
 */
public class PrefixFactoryImpl implements PrefixFactory {

    public PrefixFactoryImpl(String base) {
        _base = base;
        _next = 1;
    }

    public String getPrefix(String uri) {
        String prefix = null;

        if (_cachedUriToPrefixMap == null) {
            _cachedUriToPrefixMap = new HashMap();
        } else {
            prefix = (String) _cachedUriToPrefixMap.get(uri);
        }

        if (prefix == null) {
            prefix = _base + Integer.toString(_next++);
            _cachedUriToPrefixMap.put(uri, prefix);
        }

        return prefix;
    }

    private String _base;
    private int _next;
    private Map _cachedUriToPrefixMap;
}
