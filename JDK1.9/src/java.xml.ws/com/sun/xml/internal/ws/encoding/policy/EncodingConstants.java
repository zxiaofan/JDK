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

package com.sun.xml.internal.ws.encoding.policy;

import javax.xml.namespace.QName;

/**
 * File holding all encoding constants
 *
 * @author Marek Potociar (marek.potociar at sun.com)
 */
public final class EncodingConstants {
    /** Prevents creation of new EncodingConstants instance */
    private EncodingConstants() {
    }

    public static final String SUN_FI_SERVICE_NS = "http://java.sun.com/xml/ns/wsit/2006/09/policy/fastinfoset/service";
    public static final QName OPTIMIZED_FI_SERIALIZATION_ASSERTION = new QName(SUN_FI_SERVICE_NS, "OptimizedFastInfosetSerialization");

    public static final String SUN_ENCODING_CLIENT_NS = "http://java.sun.com/xml/ns/wsit/2006/09/policy/encoding/client";
    public static final QName SELECT_OPTIMAL_ENCODING_ASSERTION = new QName(SUN_ENCODING_CLIENT_NS, "AutomaticallySelectOptimalEncoding");

    public static final String OPTIMIZED_MIME_NS = "http://schemas.xmlsoap.org/ws/2004/09/policy/optimizedmimeserialization";
    public static final QName OPTIMIZED_MIME_SERIALIZATION_ASSERTION = new QName(OPTIMIZED_MIME_NS, "OptimizedMimeSerialization");

    public static final String ENCODING_NS = "http://schemas.xmlsoap.org/ws/2004/09/policy/encoding";
    public static final QName UTF816FFFE_CHARACTER_ENCODING_ASSERTION = new QName(ENCODING_NS, "Utf816FFFECharacterEncoding");
}
