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

import jdk.tools.jaotc.binformat.Relocation.RelocType;

/**
 * Describes a call site relocation. Contains a name of the callee and a relocation type, describing
 * which relocation to use at the call site.
 */
abstract class CallSiteRelocationInfo {

    final String targetSymbol;
    final RelocType type;

    CallSiteRelocationInfo(String targetSymbol, RelocType type) {
        this.targetSymbol = targetSymbol;
        this.type = type;
    }

}
