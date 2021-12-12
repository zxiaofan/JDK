/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */
package jdk.vm.ci.code.site;

import jdk.vm.ci.code.DebugInfo;

/**
 * Represents an implicit exception dispatch in the code. Implicit exception dispatch is a
 * platform-specific optimization that makes use of an operating system's trap mechanism, to turn
 * specific branches into sequential code with implicit traps. Information contained in this class
 * will be used by the runtime to register implicit exception dispatch, i.e., a mapping from an
 * exceptional PC offset to a continuation PC offset.
 */
public final class ImplicitExceptionDispatch extends Infopoint {

    public final int dispatchOffset;

    /**
     * Construct an implicit exception dispatch.
     *
     * @param pcOffset the exceptional PC offset
     * @param dispatchOffset the continuation PC offset
     * @param debugInfo debugging information at the exceptional PC
     */
    public ImplicitExceptionDispatch(int pcOffset, int dispatchOffset, DebugInfo debugInfo) {
        super(pcOffset, debugInfo, InfopointReason.IMPLICIT_EXCEPTION);
        this.dispatchOffset = dispatchOffset;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImplicitExceptionDispatch && super.equals(obj)) {
            ImplicitExceptionDispatch that = (ImplicitExceptionDispatch) obj;
            if (this.dispatchOffset == that.dispatchOffset) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(pcOffset);
        sb.append("->");
        sb.append(dispatchOffset);

        if (debugInfo != null) {
            appendDebugInfo(sb, debugInfo);
        }

        return sb.toString();
    }
}
