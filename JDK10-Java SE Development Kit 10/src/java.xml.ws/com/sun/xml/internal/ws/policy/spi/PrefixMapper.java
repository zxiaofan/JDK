/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.policy.spi;

import java.util.Map;

/**
 * Maps an XML prefix to a namespace.
 *
 * This class allows policy domains to configure to which XML prefix an XML
 * namespace is mapped.
 *
 * @author Fabian Ritzmann
 */
public interface PrefixMapper {

    /**
     * Returns a map of XML prefixes to namespaces for the domain.
     *
     * The keys of the map must be a name for an XML prefix, e.g. "wsrmp". The
     * values must be the name of an XML namespace, e.g.
     * "http://docs.oasis-open.org/ws-rx/wsrmp/200702".
     *
     * @return A map of XML prefixes to namespaces for the domain.
     */
    Map<String, String> getPrefixMap();
}
