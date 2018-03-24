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
import jdk.tools.jaotc.binformat.Relocation.RelocType;
import org.graalvm.compiler.hotspot.HotSpotForeignCallLinkage;

import jdk.vm.ci.code.site.Call;

/**
 * This is a foreign call site. This means either a call to the VM or a call to a Graal stub. If
 * it's a call directly to the VM, mangle the name. The call should go through regular .plt used by
 * the system loader, at least for now. If it's a call to a Graal stub, it should always be a direct
 * call, since the Graal stubs are contained within the .so file.
 */
final class ForeignCallSiteRelocationInfo extends CallSiteRelocationInfo {

    ForeignCallSiteRelocationInfo(Call call, HotSpotForeignCallLinkage callTarget) {
        super(getTargetSymbol(call, callTarget), getRelocType(callTarget));
    }

    private static String getTargetSymbol(Call call, HotSpotForeignCallLinkage callTarget) {
        // If it specifies a foreign call linkage, find the symbol corresponding to the address in
        // HotSpotVMConfig's fields.
        final long foreignCallTargetAddress = callTarget.getAddress();

        // Get the C/C++ function name associated with the foreign call target address.
        String functionName = DataBuilder.getVMFunctionNameForAddress(foreignCallTargetAddress);
        if (functionName != null) {
            // Use the known global AOT symbol associated with function name, if one exists
            String aotSymbol = BinaryContainer.getAOTSymbolForVMFunctionName(functionName);
            if (aotSymbol == null) {
                throw new InternalError("no global symbol found for: " + functionName);
            }
            return aotSymbol;
        }

        // Is it a Graal stub we are calling?
        if (callTarget.isCompiledStub()) {
            assert call.direct : "Should always be a direct call to stubs";
            return callTarget.getSymbol();
        }

        throw new InternalError("no symbol found for: " + callTarget);
    }

    private static RelocType getRelocType(HotSpotForeignCallLinkage callTarget) {
        return callTarget.isCompiledStub() ? RelocType.STUB_CALL_DIRECT : RelocType.FOREIGN_CALL_INDIRECT_GOT;
    }

}
