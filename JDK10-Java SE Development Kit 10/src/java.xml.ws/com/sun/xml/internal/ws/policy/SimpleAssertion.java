/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */

package com.sun.xml.internal.ws.policy;

import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;
import java.util.Collection;

/**
 * Simple assertion is an abstract class that serves as a base class for any assertion
 * that <b>MAY NOT</b> contain nested policies.
 *
 * @author Marek Potociar (marek.potociar at sun.com)
 */
public abstract class SimpleAssertion extends PolicyAssertion {
    protected SimpleAssertion() {
        super();
    }

    protected SimpleAssertion(AssertionData data, Collection<? extends PolicyAssertion> assertionParameters) {
        super(data, assertionParameters);
    }

    @Override
    public final boolean hasNestedPolicy() { // TODO: make abstract
        return false;
    }

    @Override
    public final NestedPolicy getNestedPolicy() { // TODO: make abstract
        return null;
    }
}
