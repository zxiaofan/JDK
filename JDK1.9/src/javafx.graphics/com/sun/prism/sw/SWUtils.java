/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.sw;

import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.pisces.Transform6;

final class SWUtils {

    static final int TO_PISCES = 65536;

    static int fastFloor(final float f) {
        final int n = (int)f;
        return ((f < 0) && (f != n)) ? n-1 : n;
    }

    static int fastCeil(final float f) {
        final int n = (int)f;
        return ((f >= 0) && (f != n)) ? n+1 : n;
    }

    static void convertToPiscesTransform(BaseTransform prismTx, Transform6 piscesTx) {
        piscesTx.m00 = (int) (TO_PISCES * prismTx.getMxx());
        piscesTx.m10 = (int) (TO_PISCES * prismTx.getMyx());
        piscesTx.m01 = (int) (TO_PISCES * prismTx.getMxy());
        piscesTx.m11 = (int) (TO_PISCES * prismTx.getMyy());
        piscesTx.m02 = (int) (TO_PISCES * prismTx.getMxt());
        piscesTx.m12 = (int) (TO_PISCES * prismTx.getMyt());
    }
}
