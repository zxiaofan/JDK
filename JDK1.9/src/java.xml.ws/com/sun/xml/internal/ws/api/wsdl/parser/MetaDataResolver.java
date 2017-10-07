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
import com.sun.istack.internal.Nullable;

import java.net.URI;

/**
 * Resolves metadata such as WSDL/schema. This serves as extensibile plugin point which a wsdl parser can use to
 * get the metadata from an endpoint.
 *
 * @author Vivek Pandey
 */
public abstract class MetaDataResolver {
    /**
     * Gives {@link com.sun.xml.internal.ws.api.wsdl.parser.ServiceDescriptor} resolved from the given location.
     *
     * TODO: Does this method need to propogate errors?
     *
     * @param location metadata location
     * @return {@link com.sun.xml.internal.ws.api.wsdl.parser.ServiceDescriptor} resolved from the location. It may be null in the cases when MetadataResolver
     *         can get the metada associated with the metadata loction.
     */
    public abstract @Nullable ServiceDescriptor resolve(@NotNull URI location);
}
