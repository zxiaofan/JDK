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
package com.sun.javafx.scene.control;

import com.sun.javafx.collections.NonIterableChange;
import javafx.collections.FXCollections;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;

import java.util.List;

/**
 * A simple read only list structure that maps into the TreeTableView tree
 * structure.
 */
public class TreeTableViewBackingList<T> extends ReadOnlyUnbackedObservableList<TreeItem<T>> {
    private final TreeTableView<T> treeTable;

    private int size = -1;

    public TreeTableViewBackingList(TreeTableView<T> treeTable) {
        this.treeTable = treeTable;
    }

    public void resetSize() {
        int oldSize = size;
        size = -1;

        // TODO we can certainly make this better....but it may not really matter
        callObservers(new NonIterableChange.GenericAddRemoveChange<>(0, oldSize, FXCollections.<TreeItem<T>>emptyObservableList(), this));
    }

    @Override public TreeItem<T> get(int i) {
        return treeTable.getTreeItem(i);
    }

    @Override public int size() {
        if (size == -1) {
            size = treeTable.getExpandedItemCount();
        }
        return size;
    }
}
