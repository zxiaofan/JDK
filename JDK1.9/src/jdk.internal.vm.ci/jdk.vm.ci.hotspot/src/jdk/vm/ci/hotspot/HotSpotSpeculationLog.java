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
package jdk.vm.ci.hotspot;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.SpeculationLog;

public class HotSpotSpeculationLog implements SpeculationLog {

    /** Written by the C++ code that performs deoptimization. */
    private volatile Object lastFailed;

    /** All speculations that have caused a deoptimization. */
    private Set<SpeculationReason> failedSpeculations;

    /** Strong references to all reasons embedded in the current nmethod. */
    private volatile Collection<SpeculationReason> speculations;

    @Override
    public synchronized void collectFailedSpeculations() {
        if (lastFailed != null) {
            if (failedSpeculations == null) {
                failedSpeculations = new HashSet<>(2);
            }
            failedSpeculations.add((SpeculationReason) lastFailed);
            lastFailed = null;
            speculations = null;
        }
    }

    @Override
    public synchronized boolean maySpeculate(SpeculationReason reason) {
        if (failedSpeculations != null && failedSpeculations.contains(reason)) {
            return false;
        }
        return true;
    }

    @Override
    public JavaConstant speculate(SpeculationReason reason) {
        assert maySpeculate(reason);

        /*
         * Objects referenced from nmethods are weak references. We need a strong reference to the
         * reason objects that are embedded in nmethods, so we add them to the speculations
         * collection.
         */
        if (speculations == null) {
            synchronized (this) {
                if (speculations == null) {
                    speculations = new ConcurrentLinkedQueue<>();
                }
            }
        }
        speculations.add(reason);

        return HotSpotObjectConstantImpl.forObject(reason);
    }

    @Override
    public synchronized boolean hasSpeculations() {
        return speculations != null && !speculations.isEmpty();
    }
}
