/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.shape;

import com.sun.javafx.geom.Path2D;
import com.sun.javafx.scene.shape.ClosePathHelper;
import com.sun.javafx.sg.prism.NGPath;

/**
 * A path element which closes the current path.
 *
 * <p>For more information on path elements see the {@link Path} and
 * {@link PathElement} classes.
 * @since JavaFX 2.0
 */
public class ClosePath extends PathElement {
    static {
        ClosePathHelper.setClosePathAccessor(new ClosePathHelper.ClosePathAccessor() {
            @Override
            public void doAddTo(PathElement pathElement, Path2D path) {
                ((ClosePath) pathElement).doAddTo(path);
            }
        });
    }

    /**
     * Creates an empty instance of ClosePath.
     */
    public ClosePath() {
        ClosePathHelper.initHelper(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addTo(NGPath pgPath) {
        pgPath.addClosePath();
    }

    /*
     * Note: This method MUST only be called via its accessor method.
     */
    private void doAddTo(Path2D path) {
        path.closePath();
    }

    /**
     * Returns a string representation of this {@code ArcTo} object.
     * @return a string representation of this {@code ArcTo} object.
     */
    @Override
    public String toString() {
        return "ClosePath";
    }
}
