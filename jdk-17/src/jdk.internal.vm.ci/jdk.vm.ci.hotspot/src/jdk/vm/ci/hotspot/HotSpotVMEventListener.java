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
package jdk.vm.ci.hotspot;

import jdk.vm.ci.code.CompiledCode;
import jdk.vm.ci.code.InstalledCode;

/**
 * Listener for responding to VM events.
 */
public interface HotSpotVMEventListener {

    /**
     * Notifies this client that the VM is shutting down.
     */
    default void notifyShutdown() {
    }

    /**
     * Notify on successful install into the code cache.
     *
     * @param hotSpotCodeCacheProvider the code cache into which the code was installed
     * @param installedCode the code that was installed
     * @param compiledCode the compiled code from which {@code installedCode} was produced
     */
    default void notifyInstall(HotSpotCodeCacheProvider hotSpotCodeCacheProvider, InstalledCode installedCode, CompiledCode compiledCode) {
    }

    /**
     * Notify on completion of a bootstrap.
     */
    default void notifyBootstrapFinished() {
    }
}
