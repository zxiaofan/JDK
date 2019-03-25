/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.replacements;

import org.graalvm.compiler.api.replacements.ClassSubstitution;
import org.graalvm.compiler.api.replacements.MethodSubstitution;
import org.graalvm.compiler.core.common.spi.ForeignCallDescriptor;
import org.graalvm.compiler.hotspot.meta.HotSpotHostForeignCallsProvider;
import org.graalvm.compiler.graph.Node.ConstantNodeParameter;
import org.graalvm.compiler.graph.Node.NodeIntrinsic;
import org.graalvm.compiler.nodes.extended.ForeignCallNode;

// JaCoCo Exclude

/**
 * Substitutions for {@link java.lang.Object} methods.
 */
@ClassSubstitution(Object.class)
public class ObjectSubstitutions {

    @MethodSubstitution(isStatic = false)
    public static int hashCode(final Object thisObj) {
        return IdentityHashCodeNode.identityHashCode(thisObj);
    }

    @MethodSubstitution(isStatic = false)
    public static void notify(final Object thisObj) {
        if (!fastNotifyStub(HotSpotHostForeignCallsProvider.NOTIFY, thisObj)) {
            notify(thisObj);
        }
    }

    @MethodSubstitution(isStatic = false)
    public static void notifyAll(final Object thisObj) {
        if (!fastNotifyStub(HotSpotHostForeignCallsProvider.NOTIFY_ALL, thisObj)) {
            notifyAll(thisObj);
        }
    }

    @NodeIntrinsic(ForeignCallNode.class)
    public static native boolean fastNotifyStub(@ConstantNodeParameter ForeignCallDescriptor descriptor, Object o);
}
