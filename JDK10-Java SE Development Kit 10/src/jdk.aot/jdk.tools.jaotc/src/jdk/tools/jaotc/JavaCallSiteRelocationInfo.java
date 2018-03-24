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

import jdk.vm.ci.code.site.Call;
import jdk.vm.ci.hotspot.HotSpotResolvedJavaMethod;

/**
 * This is a Java call site. Get the Java method name and correct call relocation type. All static
 * Java calls should be direct. All virtual Java calls should be indirect.
 */
final class JavaCallSiteRelocationInfo extends CallSiteRelocationInfo {

    JavaCallSiteRelocationInfo(Call call, HotSpotResolvedJavaMethod callTarget) {
        super(JavaMethodInfo.uniqueMethodName(callTarget), call.direct ? RelocType.JAVA_CALL_DIRECT : RelocType.JAVA_CALL_INDIRECT);
    }

}
