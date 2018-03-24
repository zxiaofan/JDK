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

/**
 * Represents exception handler information for a specific code position. It includes the catch code
 * position as well as the caught exception type.
 */
public final class ExceptionHandler extends Site {

    public final int handlerPos;

    public ExceptionHandler(int pcOffset, int handlerPos) {
        super(pcOffset);
        this.handlerPos = handlerPos;
    }

    @Override
    public String toString() {
        return String.format("%d[<exception edge to %d>]", pcOffset, handlerPos);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExceptionHandler) {
            ExceptionHandler that = (ExceptionHandler) obj;
            if (this.pcOffset == that.pcOffset && this.handlerPos == that.handlerPos) {
                return true;
            }
        }
        return false;
    }
}
