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

package com.sun.xml.internal.ws.api.wsdl.parser;

import com.sun.istack.internal.NotNull;

import javax.xml.transform.Source;
import java.util.List;

/**
 * Abstraction over WSDL and Schema metadata
 *
 * @author Vivek Pandey
 */
public abstract class ServiceDescriptor {
    /**
     * Gives list of wsdls
     * @return List of WSDL documents as {@link Source}.
     * {@link javax.xml.transform.Source#getSystemId()} must be Non-null
     */
    public abstract @NotNull List<? extends Source> getWSDLs();

    /**
     * Gives list of schemas.
     * @return List of XML schema documents as {@link Source}. {@link javax.xml.transform.Source#getSystemId()} must be Non-null.
     *
     */
    public abstract @NotNull List<? extends Source> getSchemas();
}
