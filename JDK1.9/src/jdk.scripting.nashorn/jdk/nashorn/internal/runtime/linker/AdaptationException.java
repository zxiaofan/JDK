/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.runtime.linker;

@SuppressWarnings("serial")
final class AdaptationException extends Exception {
    private final AdaptationResult adaptationResult;

    AdaptationException(final AdaptationResult.Outcome outcome, final String classList) {
        super(null, null, false, false);
        this.adaptationResult = new AdaptationResult(outcome, classList);
    }

    AdaptationResult getAdaptationResult() {
        return adaptationResult;
    }
}
