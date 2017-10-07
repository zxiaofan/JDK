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
 * An interface implemented by entities which can be defined in a target namespace.
 *
 * @author WS Development Team
 */
public interface GloballyKnown extends Elemental {
    public String getName();
    public Kind getKind();
    public Defining getDefining();
}
