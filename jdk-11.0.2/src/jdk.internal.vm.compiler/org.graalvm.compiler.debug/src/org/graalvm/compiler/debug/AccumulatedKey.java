/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.debug;

abstract class AccumulatedKey extends AbstractKey {
    protected final AbstractKey flat;

    static final String ACCUMULATED_KEY_SUFFIX = "_Accm";
    static final String FLAT_KEY_SUFFIX = "_Flat";

    protected AccumulatedKey(AbstractKey flat, String nameFormat, Object nameArg1, Object nameArg2) {
        super(nameFormat, nameArg1, nameArg2);
        this.flat = flat;
    }

    @Override
    protected String createName(String format, Object arg1, Object arg2) {
        return super.createName(format, arg1, arg2) + ACCUMULATED_KEY_SUFFIX;
    }

    @Override
    public String getDocName() {
        String name = getName();
        return name.substring(0, name.length() - ACCUMULATED_KEY_SUFFIX.length());
    }
}
