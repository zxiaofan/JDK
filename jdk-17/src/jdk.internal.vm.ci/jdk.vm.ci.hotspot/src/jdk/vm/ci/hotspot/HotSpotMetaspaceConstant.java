/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.meta.VMConstant;

public interface HotSpotMetaspaceConstant extends HotSpotConstant, VMConstant {

    HotSpotResolvedObjectType asResolvedJavaType();

    HotSpotResolvedJavaMethod asResolvedJavaMethod();
}
