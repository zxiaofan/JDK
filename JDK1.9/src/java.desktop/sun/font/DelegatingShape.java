/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.font;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * To avoid people downcasting Shape to a known mutable subclass and
 * mucking with its internals, we need to interpose a subclass that
 * cannot be mutated or downcasted.
 */
public final class DelegatingShape implements Shape {
    Shape delegate;

    public DelegatingShape(Shape delegate) {
        this.delegate = delegate;
    }

    public Rectangle getBounds() {
        return delegate.getBounds(); // assumes all delegates are immutable via the returned Rectangle
    }

    public Rectangle2D getBounds2D() {
        return delegate.getBounds2D();  // assumes all delegates are immutable via the returned Rectangle2D
    }

    public boolean contains(double x, double y) {
        return delegate.contains(x, y);
    }

    public boolean contains(Point2D p) {
        return delegate.contains(p);
    }

    public boolean intersects(double x, double y, double w, double h) {
        return delegate.intersects(x, y, w, h);
    }

    public boolean intersects(Rectangle2D r) {
        return delegate.intersects(r);
    }

    public boolean contains(double x, double y, double w, double h) {
        return delegate.contains(x, y, w, h);
    }

    public boolean contains(Rectangle2D r) {
        return delegate.contains(r);
    }

    public PathIterator getPathIterator(AffineTransform at) {
        return delegate.getPathIterator(at);
    }

    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return delegate.getPathIterator(at, flatness);
    }
}
