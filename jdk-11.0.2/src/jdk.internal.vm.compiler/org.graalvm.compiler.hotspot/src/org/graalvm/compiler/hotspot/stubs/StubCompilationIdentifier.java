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


package org.graalvm.compiler.hotspot.stubs;

import java.util.concurrent.atomic.AtomicLong;

import org.graalvm.compiler.core.common.CompilationIdentifier;
import org.graalvm.compiler.debug.GraalError;

/**
 * {@link CompilationIdentifier} for {@linkplain Stub stub compilations}.
 */
public class StubCompilationIdentifier implements CompilationIdentifier {

    private static final AtomicLong uniqueStubIds = new AtomicLong();
    private final long id;
    private final Stub stub;

    public StubCompilationIdentifier(Stub stub) {
        this.id = uniqueStubIds.getAndIncrement();
        this.stub = stub;
    }

    @Override
    public final String toString() {
        return toString(Verbosity.DETAILED);
    }

    @Override
    public String toString(Verbosity verbosity) {
        switch (verbosity) {
            case ID:
                return buildID();
            case NAME:
                return buildName();
            case DETAILED:
                return buildID() + '[' + buildName() + ']';
        }
        throw new GraalError("unknown verbosity: " + verbosity);
    }

    private String buildName() {
        return stub.toString();
    }

    private String buildID() {
        return "StubCompilation-" + id;
    }

}
