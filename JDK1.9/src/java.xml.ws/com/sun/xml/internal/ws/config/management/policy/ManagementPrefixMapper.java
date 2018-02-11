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

package com.sun.xml.internal.ws.config.management.policy;

import com.sun.xml.internal.ws.policy.PolicyConstants;
import com.sun.xml.internal.ws.policy.spi.PrefixMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Provide the default prefix for the configuration management namespace.
 *
 * @author Fabian Ritzmann
 */
public class ManagementPrefixMapper implements PrefixMapper {

    private static final Map<String, String> prefixMap = new HashMap<String, String>();

    static {
        prefixMap.put(PolicyConstants.SUN_MANAGEMENT_NAMESPACE, "sunman");
    }

    public Map<String, String> getPrefixMap() {
        return prefixMap;
    }

}
