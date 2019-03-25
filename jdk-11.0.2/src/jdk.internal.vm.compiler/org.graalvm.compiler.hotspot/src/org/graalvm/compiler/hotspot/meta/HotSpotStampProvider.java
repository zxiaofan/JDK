/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.meta;

import org.graalvm.compiler.core.common.type.ObjectStamp;
import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.hotspot.nodes.type.KlassPointerStamp;
import org.graalvm.compiler.hotspot.nodes.type.MethodPointerStamp;
import org.graalvm.compiler.nodes.spi.StampProvider;

public class HotSpotStampProvider implements StampProvider {

    @Override
    public Stamp createHubStamp(ObjectStamp object) {
        return KlassPointerStamp.klassNonNull();
    }

    @Override
    public Stamp createMethodStamp() {
        return MethodPointerStamp.methodNonNull();
    }
}
