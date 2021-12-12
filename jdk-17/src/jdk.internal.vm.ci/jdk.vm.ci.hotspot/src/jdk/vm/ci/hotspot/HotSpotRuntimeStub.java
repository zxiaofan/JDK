/*
 * Copyright (c) 2011, 2019, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.code.InvalidInstalledCodeException;
import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Implementation of {@link InstalledCode} for code installed as a {@code RuntimeStub}. The address
 * of the {@code RuntimeStub} is stored in {@link InstalledCode#address} and the value of
 * {@code RuntimeStub::entry_point()} is in {@link InstalledCode#entryPoint}.
 */
public class HotSpotRuntimeStub extends HotSpotInstalledCode {

    public HotSpotRuntimeStub(String name) {
        super(name);
    }

    public ResolvedJavaMethod getMethod() {
        return null;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void invalidate() {
    }

    @Override
    public String toString() {
        return String.format("InstalledRuntimeStub[stub=%s, codeBlob=0x%x]", name, getAddress());
    }

    @Override
    public Object executeVarargs(Object... args) throws InvalidInstalledCodeException {
        throw new InternalError("Cannot call stub " + name);
    }
}
