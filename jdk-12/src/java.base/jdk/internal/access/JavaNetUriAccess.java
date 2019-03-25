/*
 * Copyright (c) 2006, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.access;

import java.net.URI;

public interface JavaNetUriAccess {
    /**
     * Create a URI of pre-validated scheme and path.
     */
    URI create(String scheme, String path);
}
