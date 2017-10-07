/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.control.behavior;

import javafx.scene.control.Pagination;
import com.sun.javafx.scene.control.inputmap.InputMap;
import javafx.scene.input.MouseEvent;

import static javafx.scene.input.KeyCode.*;
import static com.sun.javafx.scene.control.inputmap.InputMap.KeyMapping;
import static com.sun.javafx.scene.control.inputmap.InputMap.MouseMapping;

public class PaginationBehavior extends BehaviorBase<Pagination> {

    private final InputMap<Pagination> paginationInputMap;

    public PaginationBehavior(Pagination pagination) {
        super(pagination);

        // create a map for paginiation-specific mappings (this reuses the default
        // InputMap installed on the control, if it is non-null, allowing us to pick up any user-specified mappings)
        paginationInputMap = createInputMap();

        // then button-specific mappings for key and mouse input
        addDefaultMapping(paginationInputMap,
            new KeyMapping(LEFT, e -> rtl(pagination, this::right, this::left)),
            new KeyMapping(RIGHT, e -> rtl(pagination, this::left, this::right)),
            new MouseMapping(MouseEvent.MOUSE_PRESSED, this::mousePressed)
        );
    }

    @Override public InputMap<Pagination> getInputMap() {
        return paginationInputMap;
    }

    public void mousePressed(MouseEvent e) {
        getNode().requestFocus();
    }

    private void left() {
        movePage(-1);
    }

    private void right() {
        movePage(1);
    }

    private void movePage(int delta) {
        final Pagination pagination = getNode();
        final int currentPageIndex = pagination.getCurrentPageIndex();
        pagination.setCurrentPageIndex(currentPageIndex + delta);
    }
}
