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

/**
 * {@link Module} that is an HTTP container.
 *
 * @author Kohsuke Kawaguchi
 * @since 2.1 EA3
 */
public abstract class WebModule extends Module {
    /**
     * Gets the host, port, and context path portion of this module.
     *
     * <p>
     * For example, if this is an web appliation running in a servlet
     * container "http://myhost/myapp", then this method should return
     * this URI.
     *
     * <p>
     * This method follows the convention of the {@code HttpServletRequest.getContextPath()},
     * and accepts strings like "http://myhost" (for web applications that are deployed
     * to the root context path), or "http://myhost/foobar" (for web applications
     * that are deployed to context path "/foobar")
     *
     * <p>
     * Notice that this method involves in determining the machine name
     * without relying on HTTP "Host" header.
     */
    public abstract @NotNull String getContextPath();
}
