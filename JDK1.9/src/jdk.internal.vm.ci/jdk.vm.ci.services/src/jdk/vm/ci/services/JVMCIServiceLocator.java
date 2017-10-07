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
package jdk.vm.ci.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import jdk.vm.ci.services.internal.ReflectionAccessJDK;

/**
 * Service-provider class for the runtime to locate providers of JVMCI services where the latter are
 * not in packages exported by the JVMCI module. As part of instantiating a
 * {@link JVMCIServiceLocator}, all JVMCI packages will be opened to the module defining the class
 * of the instantiated object.
 *
 * While the {@link #getProvider(Class)} method can be used directly, it's usually easier to use
 * {@link #getProviders(Class)}.
 */
public abstract class JVMCIServiceLocator {

    private static Void checkPermission() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new JVMCIPermission());
        }
        return null;
    }

    @SuppressWarnings("unused")
    private JVMCIServiceLocator(Void ignore) {
    }

    /**
     * Creates a capability for accessing JVMCI. Once successfully instantiated, JVMCI opens all its
     * packages to the module defining the type of this object.
     *
     * @throws SecurityException if a security manager has been installed and it denies
     *             {@link JVMCIPermission}
     */
    protected JVMCIServiceLocator() {
        this(checkPermission());
        Services.checkJVMCIEnabled();
        ReflectionAccessJDK.openJVMCITo(getClass());
    }

    /**
     * Gets the provider of the service defined by {@code service} or {@code null} if this object
     * does not have a provider for {@code service}.
     */
    protected abstract <S> S getProvider(Class<S> service);

    /**
     * Gets the providers of the service defined by {@code service} by querying the available
     * {@link JVMCIServiceLocator} providers.
     *
     * @throws SecurityException if a security manager is present and it denies
     *             {@link JVMCIPermission}
     */
    public static <S> List<S> getProviders(Class<S> service) {
        Services.checkJVMCIEnabled();
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new JVMCIPermission());
        }
        List<S> providers = new ArrayList<>();
        for (JVMCIServiceLocator access : ServiceLoader.load(JVMCIServiceLocator.class, ClassLoader.getSystemClassLoader())) {
            S provider = access.getProvider(service);
            if (provider != null) {
                providers.add(provider);
            }
        }
        return providers;
    }
}
