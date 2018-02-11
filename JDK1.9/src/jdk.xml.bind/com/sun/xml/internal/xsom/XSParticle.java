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

package com.sun.xml.internal.xsom;

import java.math.*;

/**
 * Particle schema component.
 *
 * @author
 *  Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface XSParticle extends XSContentType
{
    BigInteger getMinOccurs();
    /**
     * Gets the max occurs property.
     *
     * @return
     *      {@link UNBOUNDED} will be returned if the value
     *      is "unbounded".
     */
    BigInteger getMaxOccurs();

    /**
     * True if the maxOccurs is neither 0 or 1.
     */
    boolean isRepeated();

    public static final int UNBOUNDED = -1;

    XSTerm getTerm();
}
