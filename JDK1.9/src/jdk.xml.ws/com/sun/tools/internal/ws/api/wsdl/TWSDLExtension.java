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

package com.sun.tools.internal.ws.api.wsdl;

/**
 * A WSDL extension
 *
 * @author Vivek Pandey
 * @deprecated This interface is deprecated, will be removed in JAX-WS 2.2 RI.
 */
public interface TWSDLExtension {
    /**
     * Gives Parent {@link TWSDLExtensible} element
     */
    TWSDLExtensible getParent();
}
