/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.runtime.unmarshaller;



/**
 * {@link Loader} implementation that discards the whole sub-tree.
 *
 * Mostly used for recovering fom errors.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public final class Discarder extends Loader {
    public static final Loader INSTANCE = new Discarder();

    private Discarder() {
        super(false);
    }

    @Override
    public void childElement(UnmarshallingContext.State state, TagName ea) {
        state.setTarget(null);
        // registering this allows the discarder to process the whole subtree.
        state.setLoader(this);
    }
}
