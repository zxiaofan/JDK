/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.invoke;

/**
 * Base class for memory access var handle implementations.
 */
abstract class MemoryAccessVarHandleBase extends VarHandle {

    /** endianness **/
    final boolean be;

    /** access size (in bytes, computed from var handle carrier type) **/
    final long length;

    /** alignment constraint (in bytes, expressed as a bit mask) **/
    final long alignmentMask;

    /** if true, only the base part of the address will be checked for alignment **/
    final boolean skipAlignmentMaskCheck;

    MemoryAccessVarHandleBase(VarForm form, boolean skipAlignmentMaskCheck, boolean be, long length, long alignmentMask, boolean exact) {
        super(form, exact);
        this.skipAlignmentMaskCheck = skipAlignmentMaskCheck;
        this.be = be;
        this.length = length;
        this.alignmentMask = alignmentMask;
    }

    static IllegalStateException newIllegalStateExceptionForMisalignedAccess(long address) {
        return new IllegalStateException("Misaligned access at address: " + address);
    }
}
