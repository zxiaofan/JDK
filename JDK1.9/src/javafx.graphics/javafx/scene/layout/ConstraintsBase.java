/*
 * Copyright (c) 2009, 2016, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.layout;

import java.util.Iterator;

import javafx.scene.Parent;

import com.sun.javafx.util.WeakReferenceQueue;

/**
 * The base class for defining node-specific layout constraints.  Region
 * classes may create extensions of this class if they need to define their own
 * set of layout constraints.
 *
 * @since JavaFX 2.0
 */
public abstract class ConstraintsBase {

    /**
     * If set as max value indicates that the pref value should be used as the max.
     * This allows an application to constrain a resizable node's size, which normally
     * has an unlimited max value, to its preferred size.
     */
    public static final double CONSTRAIN_TO_PREF = Double.NEGATIVE_INFINITY;

    private WeakReferenceQueue nodes = new WeakReferenceQueue();

    ConstraintsBase() {
    }

    void add(Parent node) {
        nodes.add(node);
    }

    void remove(Parent node) {
        nodes.remove(node);
    }

    /**
     * Calls requestLayout on layout parent associated with this constraint object.
     */
    protected void requestLayout() {
        Iterator<Parent> nodeIter = nodes.iterator();

        while (nodeIter.hasNext()) {
            nodeIter.next().requestLayout();
        }
    }
}
