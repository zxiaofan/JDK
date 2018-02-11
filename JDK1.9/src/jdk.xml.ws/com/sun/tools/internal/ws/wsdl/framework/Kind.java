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

package com.sun.tools.internal.ws.wsdl.framework;

/**
 * A kind of entity.
 *
 * @author WS Development Team
 */
public final class Kind {

    public Kind(String s) {
        _name = s;
    }

    public String getName() {
        return _name;
    }

    private String _name;
}
