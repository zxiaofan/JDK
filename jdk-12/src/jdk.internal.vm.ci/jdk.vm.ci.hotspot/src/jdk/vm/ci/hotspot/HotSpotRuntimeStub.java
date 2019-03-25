/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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
 * Implementation of {@link InstalledCode} for code installed as a RuntimeStub.
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
