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

package com.sun.xml.internal.bind.v2.schemagen;

import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;

import com.sun.xml.internal.bind.Util;

/**
 * {@link SchemaOutputResolver} that wraps the user-specified resolver
 * and makes sure that it's following the contract.
 *
 * <p>
 * This protects the rest of the {@link XmlSchemaGenerator} from client programming
 * error.
 */
final class FoolProofResolver extends SchemaOutputResolver {
    private static final Logger logger = Util.getClassLogger();
    private final SchemaOutputResolver resolver;

    public FoolProofResolver(SchemaOutputResolver resolver) {
        assert resolver!=null;
        this.resolver = resolver;
    }

    public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
        logger.entering(getClass().getName(),"createOutput",new Object[]{namespaceUri,suggestedFileName});
        Result r = resolver.createOutput(namespaceUri,suggestedFileName);
        if(r!=null) {
            String sysId = r.getSystemId();
            logger.finer("system ID = "+sysId);
            if(sysId!=null) {
                // TODO: make sure that the system Id is absolute

                // don't use java.net.URI, because it doesn't allow some characters (like SP)
                // which can legally used as file names.

                // but don't use java.net.URL either, because it doesn't allow a made-up URI
                // like kohsuke://foo/bar/zot
            } else
                throw new AssertionError("system ID cannot be null");
        }
        logger.exiting(getClass().getName(),"createOutput",r);
        return r;
    }
}
