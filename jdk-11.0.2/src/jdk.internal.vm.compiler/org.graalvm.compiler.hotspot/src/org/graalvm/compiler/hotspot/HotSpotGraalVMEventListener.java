/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot;

import java.util.ArrayList;
import java.util.List;

import org.graalvm.compiler.code.CompilationResult;
import org.graalvm.compiler.debug.DebugContext;
import org.graalvm.compiler.debug.DebugOptions;
import org.graalvm.compiler.serviceprovider.GraalServices;

import jdk.vm.ci.code.CompiledCode;
import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.hotspot.HotSpotCodeCacheProvider;
import jdk.vm.ci.hotspot.HotSpotVMEventListener;

public class HotSpotGraalVMEventListener implements HotSpotVMEventListener {

    private final HotSpotGraalRuntime runtime;
    private List<HotSpotCodeCacheListener> listeners;

    HotSpotGraalVMEventListener(HotSpotGraalRuntime runtime) {
        this.runtime = runtime;
        listeners = new ArrayList<>();
        for (HotSpotCodeCacheListener listener : GraalServices.load(HotSpotCodeCacheListener.class)) {
            listeners.add(listener);
        }
    }

    @Override
    public void notifyShutdown() {
        runtime.shutdown();
    }

    @Override
    public void notifyInstall(HotSpotCodeCacheProvider codeCache, InstalledCode installedCode, CompiledCode compiledCode) {
        DebugContext debug = DebugContext.forCurrentThread();
        if (debug.isDumpEnabled(DebugContext.BASIC_LEVEL)) {
            CompilationResult compResult = debug.contextLookup(CompilationResult.class);
            assert compResult != null : "can't dump installed code properly without CompilationResult";
            debug.dump(DebugContext.BASIC_LEVEL, installedCode, "After code installation");
        }
        if (debug.isLogEnabled()) {
            debug.log("%s", codeCache.disassemble(installedCode));
        }
        for (HotSpotCodeCacheListener listener : listeners) {
            listener.notifyInstall(codeCache, installedCode, compiledCode);
        }
    }

    @Override
    public void notifyBootstrapFinished() {
        runtime.notifyBootstrapFinished();
        if (DebugOptions.ClearMetricsAfterBootstrap.getValue(runtime.getOptions())) {
            runtime.clearMetrics();
        }
    }
}
