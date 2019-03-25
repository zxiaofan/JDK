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


package org.graalvm.compiler.hotspot;

import org.graalvm.compiler.core.common.CompilationIdentifier;
import org.graalvm.compiler.core.common.CompilationRequestIdentifier;
import org.graalvm.compiler.debug.GraalError;

import jdk.vm.ci.hotspot.HotSpotCompilationRequest;
import jdk.vm.ci.runtime.JVMCICompiler;

/**
 * {@link CompilationIdentifier} for a {@linkplain HotSpotCompilationRequest hotspot compilation
 * request}.
 */
public class HotSpotCompilationIdentifier implements CompilationRequestIdentifier {
    private final HotSpotCompilationRequest request;

    public HotSpotCompilationIdentifier(HotSpotCompilationRequest request) {
        this.request = request;
    }

    public boolean isOsrCompilation() {
        return request.getEntryBCI() != JVMCICompiler.INVOCATION_ENTRY_BCI;
    }

    @Override
    public final String toString() {
        return toString(Verbosity.DETAILED);
    }

    @Override
    public String toString(Verbosity verbosity) {
        return buildString(new StringBuilder(), verbosity).toString();
    }

    protected StringBuilder buildString(StringBuilder sb, Verbosity verbosity) {
        switch (verbosity) {
            case ID:
                buildID(sb);
                break;
            case NAME:
                buildName(sb);
                break;
            case DETAILED:
                buildID(sb);
                sb.append('[');
                buildName(sb);
                if (isOsrCompilation()) {
                    sb.append("@");
                    sb.append(request.getEntryBCI());
                }
                sb.append(']');
                break;
            default:
                throw new GraalError("unknown verbosity: " + verbosity);
        }
        return sb;
    }

    protected StringBuilder buildName(StringBuilder sb) {
        return sb.append(request.getMethod().format("%H.%n(%p)"));
    }

    protected StringBuilder buildID(StringBuilder sb) {
        if (isOsrCompilation()) {
            sb.append("HotSpotOSRCompilation-");
        } else {
            sb.append("HotSpotCompilation-");
        }
        return sb.append(request.getId());
    }

    @Override
    public HotSpotCompilationRequest getRequest() {
        return request;
    }

}
