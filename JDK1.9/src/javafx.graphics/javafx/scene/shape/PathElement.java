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

import com.sun.javafx.util.WeakReferenceQueue;
import com.sun.javafx.geom.Path2D;
import com.sun.javafx.scene.shape.PathElementHelper;
import com.sun.javafx.sg.prism.NGPath;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.scene.Node;

import java.util.Iterator;


/**
 * The {@code PathElement} class represents an abstract element
 * of the {@link Path} that can represent any geometric objects
 * like straight lines, arcs, quadratic curves, cubic curves, etc.
 * @since JavaFX 2.0
 */
public abstract class PathElement {
    /*
     * Store the singleton instance of the PathElementHelper subclass corresponding
     * to the subclass of this instance of PathElement
     */
    private PathElementHelper pathElementHelper = null;

    static {
        // This is used by classes in different packages to get access to
        // private and package private methods.
        PathElementHelper.setPathElementAccessor(new PathElementHelper.PathElementAccessor() {
            @Override
            public PathElementHelper getHelper(PathElement pathElement) {
                return pathElement.pathElementHelper;
            }

            @Override
            public void setHelper(PathElement pathElement, PathElementHelper pathElementHelper) {
                pathElement.pathElementHelper = pathElementHelper;
            }
        });
    }

    /**
     * Defines the sequence of {@code Path} objects this path element
     * is attached to.
     */
    WeakReferenceQueue nodes = new WeakReferenceQueue();

    void addNode(final Node n) {
        nodes.add(n);
    }

    void removeNode(final Node n) {
        nodes.remove(n);
    }

    void u() {
        final Iterator iterator = nodes.iterator();
        while (iterator.hasNext()) {
            ((Path) iterator.next()).markPathDirty();
        }
    }

    abstract void addTo(NGPath pgPath);

    /**
     * A flag that indicates whether the path coordinates are absolute or
     * relative. A value of true indicates that the coordinates are absolute
     * values. A value of false indicates that the values in this PathElement
     * are added to the coordinates of the previous PathElement to compute the
     * actual coordinates.
     *
     * @defaultValue true
     */
    private BooleanProperty absolute;


    public final void setAbsolute(boolean value) {
        absoluteProperty().set(value);
    }

    public final boolean isAbsolute() {
        return absolute == null || absolute.get();
    }

    public final BooleanProperty absoluteProperty() {
        if (absolute == null) {
            absolute = new BooleanPropertyBase(true) {
                @Override protected void invalidated() {
                    u();
                }

                @Override
                public Object getBean() {
                    return PathElement.this;
                }

                @Override
                public String getName() {
                    return "absolute";
                }
            };
        }
        return absolute;
    }
}

