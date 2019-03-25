/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.util;

import jdk.vm.ci.meta.Value;

public abstract class ValueSet<S extends ValueSet<S>> {

    public abstract void put(Value v);

    public abstract void remove(Value v);

    public abstract void putAll(S s);

    public abstract S copy();
}
