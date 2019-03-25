/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ValueKind;

/**
 * Can be implemented by compilers to create custom {@link ValueKind} subclasses.
 */
public interface ValueKindFactory<K extends ValueKind<K>> {

    K getValueKind(JavaKind javaKind);
}
