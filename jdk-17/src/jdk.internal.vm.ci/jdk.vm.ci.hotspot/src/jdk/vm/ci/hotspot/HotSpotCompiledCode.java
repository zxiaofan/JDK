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

import jdk.vm.ci.code.BytecodeFrame;
import jdk.vm.ci.code.CompiledCode;
import jdk.vm.ci.code.StackSlot;
import jdk.vm.ci.code.VirtualObject;
import jdk.vm.ci.code.site.DataPatch;
import jdk.vm.ci.code.site.Infopoint;
import jdk.vm.ci.code.site.Site;
import jdk.vm.ci.meta.Assumptions.Assumption;
import jdk.vm.ci.meta.ResolvedJavaField;
import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * A {@link CompiledCode} with additional HotSpot-specific information required for installing the
 * code in HotSpot's code cache.
 */
public class HotSpotCompiledCode implements CompiledCode {

    /**
     * The name of this compilation unit.
     */
    protected final String name;

    /**
     * The buffer containing the emitted machine code.
     */
    protected final byte[] targetCode;

    /**
     * The leading number of bytes in {@link #targetCode} containing the emitted machine code.
     */
    protected final int targetCodeSize;

    /**
     * A list of code annotations describing special sites in {@link #targetCode}.
     */
    protected final Site[] sites;

    /**
     * A list of {@link Assumption} this code relies on.
     */
    protected final Assumption[] assumptions;

    /**
     * The list of the methods whose bytecodes were used as input to the compilation. If
     * {@code null}, then the compilation did not record method dependencies. Otherwise, the first
     * element of this array is the root method of the compilation.
     */
    protected final ResolvedJavaMethod[] methods;

    /**
     * A list of comments that will be included in code dumps.
     */
    protected final Comment[] comments;

    /**
     * The data section containing serialized constants for the emitted machine code.
     */
    protected final byte[] dataSection;

    /**
     * The minimum alignment of the data section.
     */
    protected final int dataSectionAlignment;

    /**
     * A list of relocations in the {@link #dataSection}.
     */
    protected final DataPatch[] dataSectionPatches;

    /**
     * A flag determining whether this code is immutable and position independent.
     */
    protected final boolean isImmutablePIC;

    /**
     * The total size of the stack frame of this compiled method.
     */
    protected final int totalFrameSize;

    /**
     * The deopt rescue slot. Must be non-null if there is a safepoint in the method.
     */
    protected final StackSlot deoptRescueSlot;

    public static class Comment {

        public final String text;
        public final int pcOffset;

        public Comment(int pcOffset, String text) {
            this.text = text;
            this.pcOffset = pcOffset;
        }
    }

    @SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "caller transfers ownership of `sites`, `targetCode`, `comments`, `methods`, `dataSection`, `dataSectionPatches` and `assumptions`")
    public HotSpotCompiledCode(String name, byte[] targetCode, int targetCodeSize, Site[] sites, Assumption[] assumptions, ResolvedJavaMethod[] methods, Comment[] comments, byte[] dataSection,
                    int dataSectionAlignment, DataPatch[] dataSectionPatches, boolean isImmutablePIC, int totalFrameSize, StackSlot deoptRescueSlot) {
        this.name = name;
        this.targetCode = targetCode;
        this.targetCodeSize = targetCodeSize;
        this.sites = sites;
        this.assumptions = assumptions;
        this.methods = methods;

        this.comments = comments;
        this.dataSection = dataSection;
        this.dataSectionAlignment = dataSectionAlignment;
        this.dataSectionPatches = dataSectionPatches;
        this.isImmutablePIC = isImmutablePIC;
        this.totalFrameSize = totalFrameSize;
        this.deoptRescueSlot = deoptRescueSlot;

        assert validateFrames();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Ensure that all the frames passed into the VM are properly formatted with an empty or illegal
     * slot following double word slots.
     */
    private boolean validateFrames() {
        for (Site site : sites) {
            if (site instanceof Infopoint) {
                Infopoint info = (Infopoint) site;
                if (info.debugInfo != null) {
                    BytecodeFrame frame = info.debugInfo.frame();
                    assert frame == null || frame.validateFormat();
                    if (info.debugInfo.getVirtualObjectMapping() != null) {
                        for (VirtualObject v : info.debugInfo.getVirtualObjectMapping()) {
                            verifyVirtualObject(v);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void verifyVirtualObject(VirtualObject v) {
        v.verifyLayout(new VirtualObject.LayoutVerifier() {
            @Override
            public int getOffset(ResolvedJavaField field) {
                return field.getOffset();
            }
        });
    }
}
