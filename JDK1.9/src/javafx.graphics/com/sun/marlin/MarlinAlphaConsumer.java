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
 *
 *
 */

package com.sun.marlin;

import com.sun.openpisces.AlphaConsumer;

public interface MarlinAlphaConsumer extends AlphaConsumer {

    public boolean supportBlockFlags();

    public void clearAlphas(final int pix_y);

    public void setAndClearRelativeAlphas(int[] blkFlags, int alphaDeltas[], int pix_y,
                                          int firstdelta, int lastdelta);
}
