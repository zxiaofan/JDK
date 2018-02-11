/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.geom;

import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.geom.transform.NoninvertibleTransformException;

/**
 * {@code TransformedShape} objects are transformed "views" onto existing
 * {@code Shape} objects.  These objects make no attempt to clone or protect
 * against access to the original {@code Shape} so any modifications to the
 * original {@code Shape} will be immediately reflected in the behaviors
 * and results of this object.
 *
 */
public abstract class TransformedShape extends Shape {
    /**
     * Returns a {@link Shape} object backed by the specified original
     * but with the indicated transform applied to all of its coordinates.
     * The original {@code Shape} is not cloned or copied by this factory
     * method so any changes to the original object will be immediately
     * reflected in the methods of the return value.
     * The original {@code BaseTransform} object is, however, copied since
     * transform objects are far more likely to be scratch objects and a
     * lot less costly to clone.  In addition, the underlying implementation
     * may dig some values out of the transform and then discard the actual
     * object in some cases for optimization purposes.  Since that would
     * make those cases independent of future changes to the transform, we
     * copy the transform so that all return values from this method are
     * independent of further mutations to the transform object.
     *
     * @param original the backing {@code Shape}
     * @param tx the {@code BaseTransform} to apply to all of the
     *           coordinates of the backing {@code Shape} on the fly
     * @return a transformed view of the backing {@code Shape}
     */
    public static TransformedShape transformedShape(Shape original, BaseTransform tx) {
        if (tx.isTranslateOrIdentity()) {
            return translatedShape(original, tx.getMxt(), tx.getMyt());
        }
        return new General(original, tx.copy());
    }

    /**
     * Returns a {@link Shape} object backed by the specified original
     * but with the indicated translation applied to all of its coordinates.
     * The original {@code Shape} is not cloned or copied by this factory
     * method so any changes to the original object will be immediately
     * reflected in the methods of the return value.
     *
     * @param original the backing {@code Shape}
     * @param tx the X coordinate translation to apply to all of the
     *           coordinates of the backing {@code Shape} on the fly
     * @param ty the Y coordinate translation to apply to all of the
     *           coordinates of the backing {@code Shape} on the fly
     * @return a translated view of the backing {@code Shape}
     */
    public static TransformedShape translatedShape(Shape original, double tx, double ty) {
        return new Translate(original, (float) tx, (float) ty);
    }

    final protected Shape delegate;

    protected TransformedShape(Shape delegate) {
        this.delegate = delegate;
    }

    public Shape getDelegateNoClone() {
        return delegate;
    }

    public abstract BaseTransform getTransformNoClone();

    /**
     * Returns a new transform that represents the specified transform with
     * the transform of this {@code TransformedShape} concatenated.
     * @param tx the specified contextual transform
     * @return the concatenated transform
     */
    public abstract BaseTransform adjust(BaseTransform tx);

    protected Point2D untransform(float x, float y) {
        Point2D p = new Point2D(x, y);
        try {
            p = getTransformNoClone().inverseTransform(p, p);
        } catch (NoninvertibleTransformException e) {
            // No point should intersect such a shape in the first place
            // so it is not likely to matter what point we test with...
        }
        return p;
    }

    protected BaseBounds untransformedBounds(float x, float y, float w, float h) {
        RectBounds b = new RectBounds(x, y, x+w, y+h);
        try {
            return getTransformNoClone().inverseTransform(b, b);
        } catch (NoninvertibleTransformException e) {
            return b.makeEmpty();
        }
    }

    @Override
    public RectBounds getBounds() {
        float box[] = new float[4];
        Shape.accumulate(box, delegate, getTransformNoClone());
        return new RectBounds(box[0], box[1], box[2], box[3]);
    }

    // Note that we are not expecting contains() and intersects() to be
    // called very often, if at all, for the generated Shape objects so these
    // implementations are basic (not heavily optimized and generate garbage).
    @Override
    public boolean contains(float x, float y) {
        return delegate.contains(untransform(x, y));
    }

    // intersects(rect) and contains(rect) are especially non-optimal
    // because there is no good way to test if a Shape contains or
    // intersects a transformed rectangle and transforming the rect
    // through any other than a rectilinear transform increases its
    // scope which changes the answer.
    private Shape cachedTransformedShape;
    private Shape getCachedTransformedShape() {
        if (cachedTransformedShape == null) {
            cachedTransformedShape = copy();
        }
        return cachedTransformedShape;
    }

    @Override
    public boolean intersects(float x, float y, float w, float h) {
        // TODO: Could check for rectilinear shapes, if it matters (RT-26884)
        return getCachedTransformedShape().intersects(x, y, w, h);
    }

    @Override
    public boolean contains(float x, float y, float w, float h) {
        // TODO: Could check for rectilinear shapes, if it matters (RT-26884)
        return getCachedTransformedShape().contains(x, y, w, h);
    }

    @Override
    public PathIterator getPathIterator(BaseTransform transform) {
        return delegate.getPathIterator(adjust(transform));
    }

    @Override
    public PathIterator getPathIterator(BaseTransform transform,
                                        float flatness)
    {
        return delegate.getPathIterator(adjust(transform), flatness);
    }

    @Override
    public Shape copy() {
        return getTransformNoClone().createTransformedShape(delegate);
    }

    static final class General extends TransformedShape {
        BaseTransform transform;

        General(Shape delegate, BaseTransform transform) {
            super(delegate);
            this.transform = transform;
        }

        public BaseTransform getTransformNoClone() {
            return transform;
        }

        public BaseTransform adjust(BaseTransform transform) {
            if (transform == null || transform.isIdentity()) {
                return this.transform.copy();
            } else {
                return transform.copy().deriveWithConcatenation(this.transform);
            }
        }
    }

    static final class Translate extends TransformedShape {
        private final float tx, ty;
        private BaseTransform cachedTx;

        public Translate(Shape delegate, float tx, float ty) {
            super(delegate);
            this.tx = tx;
            this.ty = ty;
        }

        @Override
        public BaseTransform getTransformNoClone() {
            if (cachedTx == null) {
                cachedTx = BaseTransform.getTranslateInstance(tx, ty);
            }
            return cachedTx;
        }

        public BaseTransform adjust(BaseTransform transform) {
            if (transform == null || transform.isIdentity()) {
                return BaseTransform.getTranslateInstance(tx, ty);
            } else {
                return transform.copy().deriveWithTranslation(tx, ty);
            }
        }

        @Override
        public RectBounds getBounds() {
            RectBounds rb = delegate.getBounds();
            rb.setBounds(rb.getMinX() + tx, rb.getMinY() + ty,
                         rb.getMaxX() + tx, rb.getMaxY() + ty);

            return rb;
        }

        @Override
        public boolean contains(float x, float y) {
            return delegate.contains(x - tx, y - ty);
        }

        @Override
        public boolean intersects(float x, float y, float w, float h) {
            return delegate.intersects(x - tx, y - ty, w, h);
        }

        @Override
        public boolean contains(float x, float y, float w, float h) {
            return delegate.contains(x - tx, y - ty, w, h);
        }
    }
}
