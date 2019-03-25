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
package jdk.vm.ci.code.site;

import java.util.Objects;

import jdk.vm.ci.code.DebugInfo;
import jdk.vm.ci.meta.InvokeTarget;

/**
 * Represents a call in the code.
 */
public final class Call extends Infopoint {

    /**
     * The target of the call.
     */
    public final InvokeTarget target;

    /**
     * The size of the call instruction.
     */
    public final int size;

    /**
     * Specifies if this call is direct or indirect. A direct call has an immediate operand encoding
     * the absolute or relative (to the call itself) address of the target. An indirect call has a
     * register or memory operand specifying the target address of the call.
     */
    public final boolean direct;

    public Call(InvokeTarget target, int pcOffset, int size, boolean direct, DebugInfo debugInfo) {
        super(pcOffset, debugInfo, InfopointReason.CALL);
        this.size = size;
        this.target = target;
        this.direct = direct;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Call && super.equals(obj)) {
            Call that = (Call) obj;
            if (this.size == that.size && this.direct == that.direct && Objects.equals(this.target, that.target)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(pcOffset);
        sb.append('[');
        sb.append(target);
        sb.append(']');

        if (debugInfo != null) {
            appendDebugInfo(sb, debugInfo);
        }

        return sb.toString();
    }
}
