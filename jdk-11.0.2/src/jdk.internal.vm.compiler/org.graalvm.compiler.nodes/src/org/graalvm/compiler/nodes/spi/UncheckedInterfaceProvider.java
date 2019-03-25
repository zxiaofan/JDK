/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.nodes.spi;

import org.graalvm.compiler.core.common.type.Stamp;

public interface UncheckedInterfaceProvider {
    /**
     * Returns a stamp containing information about interface types that has not been verified or
     * null if no such stamp is available. A type check is needed before using informations from
     * this stamp.
     */
    Stamp uncheckedStamp();
}
