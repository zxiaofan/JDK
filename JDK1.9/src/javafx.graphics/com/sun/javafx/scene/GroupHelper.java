/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene;

import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.util.Utils;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;

/**
 * Used to access internal methods of Group.
 */
public class GroupHelper extends ParentHelper {

    private static final GroupHelper theInstance;
    private static GroupAccessor groupAccessor;

    static {
        theInstance = new GroupHelper();
        Utils.forceInit(Group.class);
    }

    private static GroupHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Group group) {
        setHelper(group, getInstance());
    }

    @Override
    protected NGNode createPeerImpl(Node node) {
        return super.createPeerImpl(node);
    }

    @Override
    protected Bounds computeLayoutBoundsImpl(Node node) {
        groupAccessor.doComputeLayoutBounds(node);
        return super.computeLayoutBoundsImpl(node);
    }

    public static void setGroupAccessor(final GroupAccessor newAccessor) {
        if (groupAccessor != null) {
            throw new IllegalStateException();
        }

        groupAccessor = newAccessor;
    }

    public interface GroupAccessor {
        Bounds doComputeLayoutBounds(Node node);
    }

}
