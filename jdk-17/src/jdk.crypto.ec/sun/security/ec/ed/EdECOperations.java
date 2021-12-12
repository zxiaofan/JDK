/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.ec.ed;

import sun.security.ec.point.*;
import sun.security.util.math.IntegerModuloP;
import sun.security.util.math.MutableIntegerModuloP;

import java.util.function.Function;

/*
 * Base class for Edwards curve ECC implementations.
 */
public abstract class EdECOperations {

    // Curve-specific base point multiplication.
    public abstract Point basePointMultiply(byte[] s);

    // Decode curve-specifics to the affinePoint
    public abstract <T extends Throwable>
    AffinePoint decodeAffinePoint(Function<String, T> exception,
                                  int xLSB, IntegerModuloP y) throws T;

    // Curve specific point from an X,Y point
    public abstract ImmutablePoint of(AffinePoint p);

    /*
     * Generic method for taking two classes implementing MutablePoint to be
     * called by the curve-specific setSum()
     */
    public MutablePoint setSum(MutablePoint p1, MutablePoint p2) {
        MutableIntegerModuloP t1 = p2.getField().get1().mutable();
        MutableIntegerModuloP t2 = p2.getField().get1().mutable();
        MutableIntegerModuloP t3 = p2.getField().get1().mutable();
        return setSum(p1, p2, t1, t2, t3);
    }

    /*
     * Generic method for taking a class implementing MutablePoint with a
     * scalar to returning the point product using curve-specific methods.
     */
    public MutablePoint setProduct(MutablePoint p1, byte[] s) {
        MutablePoint p = p1.mutable();
        p1.setValue(getNeutral());
        MutablePoint addResult = getNeutral().mutable();
        MutableIntegerModuloP t1 = p.getField().get0().mutable();
        MutableIntegerModuloP t2 = p.getField().get0().mutable();
        MutableIntegerModuloP t3 = p.getField().get0().mutable();

        for (int i = 0; i < s.length * 8; i++) {
            addResult.setValue(p1);
            setSum(addResult, p, t1, t2, t3);
            int swap = bitAt(s, i);
            p1.conditionalSet(addResult, swap);
            setDouble(p, t1, t2);
        }

        return p1;
    }

    // Abstract method for constructing the neutral point on the curve
    protected abstract ImmutablePoint getNeutral();


    // Abstract method for Curve-specific point addition
    protected abstract MutablePoint setSum(MutablePoint p1, MutablePoint p2,
                                           MutableIntegerModuloP t1,
                                           MutableIntegerModuloP t2,
                                           MutableIntegerModuloP t3);
    // Abstract method for Curve-specific point doubling
    protected abstract MutablePoint setDouble(MutablePoint p,
                                              MutableIntegerModuloP t1,
                                              MutableIntegerModuloP t2);

    private static int bitAt(byte[] arr, int index) {
        int byteIndex = index / 8;
        int bitIndex = index % 8;
        return (arr[byteIndex] & (1 << bitIndex)) >> bitIndex;
    }
}
