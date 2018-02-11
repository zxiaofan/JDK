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

package javafx.scene.transform;

/**
 * Specifies type of transformation matrix.
 * @since JavaFX 8.0
 */
public enum MatrixType {
    /**
     * A 2D affine transformation matrix of 2 rows and 3 columns containing
     * the following values:
     * <pre>
     * mxx, mxy, tx,
     * myx, myy, ty
     * </pre>
     */
    MT_2D_2x3(2, 3),

    /**
     * A 2D transformation matrix of 3 rows and 3 columns. For affine transforms
     * the last line is constant, so the matrix contains the following values:
     * <pre>
     * mxx, mxy, tx,
     * myx, myy, ty,
     *   0,   0,  1
     * </pre>
     */
    MT_2D_3x3(3, 3),

    /**
     * A 3D affine transformation matrix of 3 rows and 4 columns containing
     * the following values:
     * <pre>
     * mxx, mxy, mxz, tx,
     * myx, myy, myz, ty,
     * mzx, mzy, mzz, tz
     * </pre>
     */
    MT_3D_3x4(3, 4),

    /**
     * A 3D transformation matrix of 4 rows and 4 columns. For affine transforms
     * the last line is constant, so the matrix contains the following values:
     * <pre>
     * mxx, mxy, mxz, tx,
     * myx, myy, myz, ty,
     * mzx, mzy, mzz, tz,
     *   0,   0,   0,  1
     * </pre>
     */
    MT_3D_4x4(4, 4);

    private int rows;
    private int cols;

    private MatrixType(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * Returns the number of elements in the matrix of this type.
     * @return the number of elements in the matrix of this type
     */
    public int elements() {
        return rows * cols;
    }

    /**
     * Returns the number of rows in the matrix of this type.
     * @return the number of rows in the matrix of this type
     */
    public int rows() {
        return rows;
    }

    /**
     * Returns the number of columns in the matrix of this type.
     * @return the number of columns in the matrix of this type
     */
    public int columns() {
        return cols;
    }

    /**
     * Specifies if this is a 2D transformation matrix
     * @return true if this is a 2D transformation matrix, false if this
     *         is a 3D transformation matrix
     */
    public boolean is2D() {
        return this == MT_2D_2x3 || this == MT_2D_3x3;
    }
}
