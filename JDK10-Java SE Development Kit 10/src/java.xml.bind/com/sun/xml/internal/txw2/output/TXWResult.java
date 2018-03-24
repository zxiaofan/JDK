/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.txw2.output;

import com.sun.xml.internal.txw2.TypedXmlWriter;

import javax.xml.transform.Result;

/**
 * Allow you to wrap {@link TypedXmlWriter} into a {@link Result}
 * so that it can be passed to {@link ResultFactory}.
 *
 * <p>
 * This class doesn't extend from known {@link Result} type,
 * so it won't work elsewhere.
 *
 * @author Kohsuke Kawaguchi
 */
public class TXWResult implements Result {
    private String systemId;

    private TypedXmlWriter writer;

    public TXWResult(TypedXmlWriter writer) {
        this.writer = writer;
    }

    public TypedXmlWriter getWriter() {
        return writer;
    }

    public void setWriter(TypedXmlWriter writer) {
        this.writer = writer;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
}
