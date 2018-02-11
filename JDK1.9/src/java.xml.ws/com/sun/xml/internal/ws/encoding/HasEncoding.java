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

package com.sun.xml.internal.ws.encoding;

/**
 * A {@link javax.xml.stream.XMLStreamWriter} doesn't expose any method to
 * give encoding. An implementation of writer may implement
 * this interface to give the encoding with which the writer is created.
 *
 * @author  Jitendra Kotamraju
 * @since JAX-WS RI 2.2.6
 */
public interface HasEncoding {
    public String getEncoding();
}
