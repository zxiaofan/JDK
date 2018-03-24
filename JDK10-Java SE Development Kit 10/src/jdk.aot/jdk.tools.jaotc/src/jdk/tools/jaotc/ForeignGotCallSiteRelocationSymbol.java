/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jaotc;

import jdk.tools.jaotc.binformat.BinaryContainer;
import jdk.tools.jaotc.binformat.Symbol;

import jdk.vm.ci.code.site.Call;

final class ForeignGotCallSiteRelocationSymbol extends CallSiteRelocationSymbol {

    ForeignGotCallSiteRelocationSymbol(CompiledMethodInfo mi, Call call, CallSiteRelocationInfo callSiteRelocation, DataBuilder dataBuilder) {
        super(createPltSymbol(dataBuilder, mi, call, callSiteRelocation));
    }

    private static Symbol createPltSymbol(DataBuilder dataBuilder, CompiledMethodInfo mi, Call call, CallSiteRelocationInfo callSiteRelocation) {
        BinaryContainer binaryContainer = dataBuilder.getBinaryContainer();
        String vmSymbolName = callSiteRelocation.targetSymbol;

        // Add relocation to GOT cell for call resolution jump.
        String pltSymbolName = "plt." + vmSymbolName;
        Symbol pltSymbol = binaryContainer.getSymbol(pltSymbolName);

        if (pltSymbol == null) {
            String gotSymbolName = "got." + vmSymbolName;
            Symbol gotSymbol = binaryContainer.getGotSymbol(gotSymbolName);
            assert gotSymbol != null : "undefined VM got symbol '" + gotSymbolName + "' for call at " + call.pcOffset + " in " + mi.getMethodInfo().getSymbolName();

            // Generate PLT jump (do it only once).
            final int pltStartOffset = binaryContainer.getCodeContainer().getByteStreamSize();
            final int pltEndOffset = pltStartOffset + addPltJump(dataBuilder);

            // Link GOT cell to PLT jump.
            pltSymbol = createCodeContainerSymbol(binaryContainer, pltSymbolName, pltStartOffset);
            addExternalPltToGotRelocation(binaryContainer, gotSymbol, pltEndOffset);
        }

        return pltSymbol;
    }

    private static int addPltJump(DataBuilder dataBuilder) {
        ELFMacroAssembler masm = ELFMacroAssembler.getELFMacroAssembler(dataBuilder.getBackend().getTarget());
        byte[] code = masm.getPLTJumpCode(); // It includes alignment nops.
        int size = masm.currentEndOfInstruction();
        dataBuilder.getBinaryContainer().appendCodeBytes(code, 0, code.length);
        return size;
    }

}
