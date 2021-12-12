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
package jdk.vm.ci.code.site;

/**
 * Represents some external data that is referenced by the code.
 */
public abstract class Reference {

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);
}
