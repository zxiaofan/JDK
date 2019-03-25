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
import jdk.tools.jaotc.binformat.Symbol.Binding;
import jdk.tools.jaotc.binformat.Symbol.Kind;

/**
 * Native function call, symbol is to a VM method.
 */
final class ForeignCallSiteRelocationSymbol extends CallSiteRelocationSymbol {

    ForeignCallSiteRelocationSymbol(CallSiteRelocationInfo callSiteRelocation, BinaryContainer binaryContainer) {
        super(binaryContainer.createSymbol(0, Kind.NATIVE_FUNCTION, Binding.GLOBAL, 0, callSiteRelocation.targetSymbol));
    }

}
