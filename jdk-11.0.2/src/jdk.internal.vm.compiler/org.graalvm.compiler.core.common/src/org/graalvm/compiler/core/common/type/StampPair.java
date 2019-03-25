/*
 * Copyright (c) 2016, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.type;

/**
 * A pair of stamp with one being the stamp that can be trusted and the other one being a guess that
 * needs a dynamic check to be used.
 */
public final class StampPair {

    private final Stamp trustedStamp;
    private final Stamp uncheckedStamp;

    private StampPair(Stamp trustedStamp, Stamp uncheckedStamp) {
        assert trustedStamp != null;
        this.trustedStamp = trustedStamp;
        this.uncheckedStamp = uncheckedStamp;
    }

    public static StampPair create(Stamp trustedStamp, Stamp uncheckedStamp) {
        return new StampPair(trustedStamp, uncheckedStamp);
    }

    public static StampPair createSingle(Stamp stamp) {
        return new StampPair(stamp, null);
    }

    public Stamp getUncheckedStamp() {
        return uncheckedStamp;
    }

    public Stamp getTrustedStamp() {
        return trustedStamp;
    }

    @Override
    public String toString() {
        if (uncheckedStamp == null) {
            return trustedStamp.toString();
        } else {
            return trustedStamp + " (unchecked=" + uncheckedStamp + ")";
        }
    }
}
