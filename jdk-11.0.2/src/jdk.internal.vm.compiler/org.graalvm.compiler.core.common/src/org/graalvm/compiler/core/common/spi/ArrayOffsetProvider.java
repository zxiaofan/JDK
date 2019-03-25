/*
 * Copyright (c) 2018, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.spi;

import jdk.vm.ci.meta.JavaKind;

public interface ArrayOffsetProvider {

    int arrayBaseOffset(JavaKind elementKind);

    int arrayScalingFactor(JavaKind elementKind);
}
