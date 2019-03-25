/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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


package jdk.internal.vm.compiler.word.impl;

import jdk.internal.vm.compiler.word.WordBase;

/**
 * Base class for a factory to create boxed {@link Word} instances. A concrete subclass must
 * initialize {@link #boxFactory}.
 */
public abstract class WordBoxFactory {

    protected static WordBoxFactory boxFactory;

    protected abstract <T extends WordBase> T boxImpl(long val);

    public static <T extends WordBase> T box(long val) {
        return boxFactory.boxImpl(val);
    }
}
