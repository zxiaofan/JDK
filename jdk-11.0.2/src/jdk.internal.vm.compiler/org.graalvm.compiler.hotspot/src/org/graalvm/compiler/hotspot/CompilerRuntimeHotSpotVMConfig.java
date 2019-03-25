/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.hotspot.HotSpotVMConfigAccess;
import jdk.vm.ci.hotspot.HotSpotVMConfigStore;

/**
 * Used to access native configuration details for static compilation support.
 */
public class CompilerRuntimeHotSpotVMConfig extends HotSpotVMConfigAccess {

    public CompilerRuntimeHotSpotVMConfig(HotSpotVMConfigStore store) {
        super(store);
    }

    public final long resolveStringBySymbol = getAddress("CompilerRuntime::resolve_string_by_symbol");
    public final long resolveDynamicInvoke = getAddress("CompilerRuntime::resolve_dynamic_invoke");
    public final long resolveKlassBySymbol = getAddress("CompilerRuntime::resolve_klass_by_symbol");
    public final long resolveMethodBySymbolAndLoadCounters = getAddress("CompilerRuntime::resolve_method_by_symbol_and_load_counters");
    public final long initializeKlassBySymbol = getAddress("CompilerRuntime::initialize_klass_by_symbol");
    public final long invocationEvent = getAddress("CompilerRuntime::invocation_event");
    public final long backedgeEvent = getAddress("CompilerRuntime::backedge_event");
}
