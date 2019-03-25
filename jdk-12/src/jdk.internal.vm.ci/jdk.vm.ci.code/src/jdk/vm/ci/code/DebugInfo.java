/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.code;

import java.util.Objects;

/**
 * Represents the debugging information for a particular point of execution. This information
 * includes:
 * <ul>
 * <li>a {@linkplain #getBytecodePosition() bytecode position}</li>
 * <li>a reference map for registers and stack slots in the current frame</li>
 * <li>a map from bytecode locals and operand stack slots to their values or locations from which
 * their values can be read</li>
 * <li>a map from the registers (in the caller's frame) to the slots where they are saved in the
 * current frame</li>
 * </ul>
 */
public final class DebugInfo {

    private final BytecodePosition bytecodePosition;
    private ReferenceMap referenceMap;
    private final VirtualObject[] virtualObjectMapping;
    private RegisterSaveLayout calleeSaveInfo;

    /**
     * Creates a new {@link DebugInfo} from the given values.
     *
     * @param codePos the {@linkplain BytecodePosition code position} or {@linkplain BytecodeFrame
     *            frame} info
     * @param virtualObjectMapping the mapping of {@link VirtualObject}s to their real values. This
     *            array is now owned by this object and must not be mutated by the caller.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "caller transfers ownership of `virtualObjectMapping`")
    public DebugInfo(BytecodePosition codePos, VirtualObject[] virtualObjectMapping) {
        this.bytecodePosition = codePos;
        this.virtualObjectMapping = virtualObjectMapping;
    }

    public DebugInfo(BytecodePosition codePos) {
        this(codePos, null);
    }

    public void setReferenceMap(ReferenceMap referenceMap) {
        this.referenceMap = referenceMap;
    }

    /**
     * @return {@code true} if this debug information has a frame
     */
    public boolean hasFrame() {
        return getBytecodePosition() instanceof BytecodeFrame;
    }

    /**
     * Gets the deoptimization information for each inlined frame (if available).
     *
     * @return {@code null} if no frame de-opt info is {@linkplain #hasFrame() available}
     */
    public BytecodeFrame frame() {
        if (hasFrame()) {
            return (BytecodeFrame) getBytecodePosition();
        }
        return null;
    }

    @Override
    public String toString() {
        return CodeUtil.append(new StringBuilder(100), this, null).toString();
    }

    /**
     * @return The code position (including all inlined methods) of this debug info. If this is a
     *         {@link BytecodeFrame} instance, then it is also the deoptimization information for
     *         each inlined frame.
     */
    public BytecodePosition getBytecodePosition() {
        return bytecodePosition;
    }

    public ReferenceMap getReferenceMap() {
        return referenceMap;
    }

    public VirtualObject[] getVirtualObjectMapping() {
        return virtualObjectMapping;
    }

    /**
     * Sets the map from the registers (in the caller's frame) to the slots where they are saved in
     * the current frame.
     */
    public void setCalleeSaveInfo(RegisterSaveLayout calleeSaveInfo) {
        this.calleeSaveInfo = calleeSaveInfo;
    }

    /**
     * Gets the map from the registers (in the caller's frame) to the slots where they are saved in
     * the current frame. If no such information is available, {@code null} is returned.
     */
    public RegisterSaveLayout getCalleeSaveInfo() {
        return calleeSaveInfo;
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("hashCode");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DebugInfo) {
            DebugInfo that = (DebugInfo) obj;
            if (Objects.equals(this.bytecodePosition, that.bytecodePosition) && Objects.equals(this.calleeSaveInfo, that.calleeSaveInfo) && Objects.equals(this.referenceMap, that.referenceMap)) {
                return true;
            }
        }
        return false;
    }
}
