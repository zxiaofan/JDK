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

package com.sun.xml.internal.ws.api.server;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Resolves relative references among {@link SDDocument}s.
 *
 * <p>
 * This interface is implemented by the caller of
 * {@link SDDocument#writeTo} method so
 * that the {@link SDDocument} can correctly produce references
 * to other documents.
 *
 * <p>
 * This mechanism allows the user of {@link WSEndpoint} to
 * assign logical URLs to each {@link SDDocument} (which is often
 * necessarily done in a transport-dependent way), and then
 * serve description documents.
 *
 *
 *
 * <h2>Usage Example 1</h2>
 * <p>
 * HTTP servlet transport chose to expose those metadata documents
 * to HTTP GET requests where each {@link SDDocument} is identified
 * by a simple query string "?<i>ID</i>". (HTTP servlet transport
 * assigns such IDs by itself.)
 *
 * <p>
 * In this nameing scheme, when {@link SDDocument} X refers to
 * {@link SDDocument} Y, it can put a reference as "?<i>IDofY</i>".
 * By implementing {@link DocumentAddressResolver} it can do so.
 *
 * @author Kohsuke Kawaguchi
 */
public interface DocumentAddressResolver {
    /**
     * Produces a relative reference from one document to another.
     *
     * @param current
     *      The document that is being generated.
     * @param referenced
     *      The document that is referenced.
     * @return
     *      The reference to be put inside {@code current} to refer to
     *      {@code referenced}. This can be a relative URL as well as
     *      an absolute. If null is returned, then the {@link SDDocument}
     *      will produce a "implicit reference" (for example, &lt;xs:import>
     *      without the @schemaLocation attribute, etc).
     */
    @Nullable String getRelativeAddressFor(@NotNull SDDocument current, @NotNull SDDocument referenced);
}
