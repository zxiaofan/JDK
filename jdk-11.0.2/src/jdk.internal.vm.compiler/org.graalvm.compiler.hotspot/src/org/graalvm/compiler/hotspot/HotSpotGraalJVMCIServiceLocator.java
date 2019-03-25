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

import org.graalvm.compiler.serviceprovider.ServiceProvider;

import jdk.vm.ci.hotspot.HotSpotVMEventListener;
import jdk.vm.ci.runtime.JVMCICompilerFactory;
import jdk.vm.ci.services.JVMCIServiceLocator;

@ServiceProvider(JVMCIServiceLocator.class)
public final class HotSpotGraalJVMCIServiceLocator extends JVMCIServiceLocator {

    /**
     * Holds the state shared between all {@link HotSpotGraalJVMCIServiceLocator} instances. This is
     * necessary as a service provider instance is created each time the service is loaded.
     */
    private static final class Shared {
        static final Shared SINGLETON = new Shared();

        <T> T getProvider(Class<T> service, HotSpotGraalJVMCIServiceLocator locator) {
            if (service == JVMCICompilerFactory.class) {
                return service.cast(new HotSpotGraalCompilerFactory(locator));
            } else if (service == HotSpotVMEventListener.class) {
                if (graalRuntime != null) {
                    return service.cast(new HotSpotGraalVMEventListener(graalRuntime));
                }
            }
            return null;
        }

        private HotSpotGraalRuntime graalRuntime;

        /**
         * Notifies this object of the compiler created via {@link HotSpotGraalJVMCIServiceLocator}.
         */
        void onCompilerCreation(HotSpotGraalCompiler compiler) {
            assert this.graalRuntime == null : "only expect a single JVMCICompiler to be created";
            this.graalRuntime = (HotSpotGraalRuntime) compiler.getGraalRuntime();
        }
    }

    @Override
    public <T> T getProvider(Class<T> service) {
        return Shared.SINGLETON.getProvider(service, this);
    }

    /**
     * Notifies this object of the compiler created via {@link HotSpotGraalJVMCIServiceLocator}.
     */
    @SuppressWarnings("static-method")
    void onCompilerCreation(HotSpotGraalCompiler compiler) {
        Shared.SINGLETON.onCompilerCreation(compiler);
    }
}
