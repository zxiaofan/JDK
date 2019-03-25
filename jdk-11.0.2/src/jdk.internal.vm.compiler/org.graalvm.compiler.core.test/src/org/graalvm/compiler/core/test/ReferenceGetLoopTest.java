/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import org.junit.Test;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.loop.LoopEx;
import org.graalvm.compiler.loop.LoopsData;
import org.graalvm.compiler.nodes.FieldLocationIdentity;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.memory.Access;
import jdk.internal.vm.compiler.word.LocationIdentity;

import jdk.vm.ci.meta.ResolvedJavaField;

public class ReferenceGetLoopTest extends GraalCompilerTest {

    @Override
    protected boolean checkMidTierGraph(StructuredGraph graph) {
        final LoopsData loops = new LoopsData(graph);
        boolean found = false;
        for (LoopEx loop : loops.loops()) {
            for (Node node : loop.inside().nodes()) {
                if (node instanceof Access) {
                    Access access = (Access) node;
                    LocationIdentity location = access.getLocationIdentity();
                    if (location instanceof FieldLocationIdentity) {
                        ResolvedJavaField field = ((FieldLocationIdentity) location).getField();
                        if (field.getName().equals("referent") && field.getDeclaringClass().equals(getMetaAccess().lookupJavaType(Reference.class))) {
                            found = true;
                        }
                    }
                }
            }
        }
        if (!found) {
            assertTrue(false, "Reference.referent not found in loop: " + getCanonicalGraphString(graph, true, false));
        }
        return true;
    }

    public volatile Object referent;
    public final FinalWeakReference<Object> ref;
    public final ReferenceQueue<Object> refQueue;

    /*
     * Ensure that the Reference.get invoke is statically bindable.
     */
    public static final class FinalWeakReference<T> extends WeakReference<T> {
        public FinalWeakReference(T referent, ReferenceQueue<? super T> q) {
            super(referent, q);
        }
    }

    public ReferenceGetLoopTest() {
        referent = new Object();
        refQueue = new ReferenceQueue<>();
        ref = new FinalWeakReference<>(referent, refQueue);
    }

    @Test
    public void test() {
        getCode(getMetaAccess().lookupJavaMethod(getMethod("testSnippet")));
    }

    public void testSnippet() {
        while (ref.get() != null) {
            // burn!
        }
    }
}
