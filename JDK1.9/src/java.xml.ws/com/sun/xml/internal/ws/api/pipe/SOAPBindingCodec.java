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

package com.sun.xml.internal.ws.api.pipe;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.message.Message;

import javax.xml.stream.XMLStreamReader;

/**
 *
 *
 * @see com.sun.xml.internal.ws.api.pipe.Codecs
 * @author Jitendra Kotamraju
 */
public interface SOAPBindingCodec extends Codec {
    StreamSOAPCodec getXMLCodec();
}
