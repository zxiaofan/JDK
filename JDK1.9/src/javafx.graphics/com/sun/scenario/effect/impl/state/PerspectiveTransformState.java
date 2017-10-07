/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.scenario.effect.impl.state;

public class PerspectiveTransformState {

    private float itx[][] = new float[3][3];

    public float[][] getITX() {
        return itx;
    }

    public void updateTx(float[][] tx) {
        // First calculate the matrix inversion
        float det = get3x3Determinant(tx);
        if (Math.abs(det) < 1e-10) {
            itx[0][0] = itx[1][0] = itx[2][0] = 0f;
            itx[0][1] = itx[1][1] = itx[2][1] = 0f;
            itx[0][2] = itx[1][2] = -1f;
            itx[2][2] = 1f;
        } else {
            float invdet = 1.0f / det;
            // Note that we calculate the matrix subdeterminants in
            // row-column order, but we store them into the inverted
            // matrix in column-row order.  This performs the transpose
            // operation needed for matrix inversion as we go.
            itx[0][0] = invdet * (tx[1][1]*tx[2][2] - tx[1][2]*tx[2][1]);
            itx[1][0] = invdet * (tx[1][2]*tx[2][0] - tx[1][0]*tx[2][2]); // flipped sign
            itx[2][0] = invdet * (tx[1][0]*tx[2][1] - tx[1][1]*tx[2][0]);
            itx[0][1] = invdet * (tx[0][2]*tx[2][1] - tx[0][1]*tx[2][2]); // flipped sign
            itx[1][1] = invdet * (tx[0][0]*tx[2][2] - tx[0][2]*tx[2][0]);
            itx[2][1] = invdet * (tx[0][1]*tx[2][0] - tx[0][0]*tx[2][1]); // flipped sign
            itx[0][2] = invdet * (tx[0][1]*tx[1][2] - tx[0][2]*tx[1][1]);
            itx[1][2] = invdet * (tx[0][2]*tx[1][0] - tx[0][0]*tx[1][2]); // flipped sign
            itx[2][2] = invdet * (tx[0][0]*tx[1][1] - tx[0][1]*tx[1][0]);
        }
    }

    private static float get3x3Determinant(float m[][]) {
        return (  (m[0][0] * ((m[1][1] * m[2][2]) - (m[1][2] * m[2][1]))) -
                  (m[0][1] * ((m[1][0] * m[2][2]) - (m[1][2] * m[2][0]))) +
                  (m[0][2] * ((m[1][0] * m[2][1]) - (m[1][1] * m[2][0]))) );
    }
}
