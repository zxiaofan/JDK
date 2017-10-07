/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.client;

import java.io.IOException;

public class PortFileInaccessibleException extends IOException {

    private static final long serialVersionUID = -4755261881545398973L;

    public PortFileInaccessibleException(Throwable cause) {
        super(cause);
    }
}
