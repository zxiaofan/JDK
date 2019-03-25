/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.microbenchmarks.graal.util;

import org.graalvm.compiler.api.test.Graal;
import org.graalvm.compiler.core.target.Backend;
import org.graalvm.compiler.debug.DebugHandlersFactory;
import org.graalvm.compiler.debug.DebugContext;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.phases.util.Providers;
import org.graalvm.compiler.runtime.RuntimeProvider;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import jdk.vm.ci.meta.MetaAccessProvider;

/**
 * Read-only, thread-local state providing Graal runtime context. This has to be thread-local due to
 * requirements that {@link DebugContext} objects be single threaded in their usage.
 */
@State(Scope.Thread)
public class GraalState {

    public final OptionValues options;
    public final DebugContext debug;
    public final Backend backend;
    public final Providers providers;
    public final MetaAccessProvider metaAccess;

    public GraalState() {
        options = Graal.getRequiredCapability(OptionValues.class);
        debug = DebugContext.create(options, DebugHandlersFactory.LOADER);
        backend = Graal.getRequiredCapability(RuntimeProvider.class).getHostBackend();
        providers = backend.getProviders();
        metaAccess = providers.getMetaAccess();
    }
}
