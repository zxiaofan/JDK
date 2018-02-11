/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.geom;

public interface PathConsumer2D {
    /**
     * @see java.awt.geom.Path2D.Float#moveTo
     */
    public void moveTo(float x, float y);

    /**
     * @see java.awt.geom.Path2D.Float#lineTo
     */
    public void lineTo(float x, float y);

    /**
     * @see java.awt.geom.Path2D.Float#quadTo
     */
    public void quadTo(float x1, float y1,
                       float x2, float y2);

    /**
     * @see java.awt.geom.Path2D.Float#curveTo
     */
    public void curveTo(float x1, float y1,
                        float x2, float y2,
                        float x3, float y3);

    /**
     * @see java.awt.geom.Path2D.Float#closePath
     */
    public void closePath();

    /**
     * Called after the last segment of the last subpath when the
     * iteration of the path segments is completely done.  This
     * method serves to trigger the end of path processing in the
     * consumer that would normally be triggered when a
     * {@link java.awt.geom.PathIterator PathIterator}
     * returns {@code true} from its {@code done} method.
     */
    public void pathDone();

    /**
     * If a given PathConsumer performs all or most of its work
     * natively then it can return a (non-zero) pointer to a
     * native function vector that defines C functions for all
     * of the above methods.
     * The specific pointer it returns is a pointer to a
     * PathConsumerVec structure as defined in the include file
     * src/share/native/sun/java2d/pipe/PathConsumer2D.h
     * @return a native pointer to a PathConsumerVec structure.
     */
    public long getNativeConsumer();
}
