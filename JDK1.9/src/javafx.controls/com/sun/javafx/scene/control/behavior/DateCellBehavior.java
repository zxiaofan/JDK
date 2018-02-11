/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.scene.traversal.Direction;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.DateCell;

import com.sun.javafx.scene.control.DatePickerContent;
import com.sun.javafx.scene.control.inputmap.InputMap;

import java.time.temporal.ChronoUnit;

import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.SPACE;
import static javafx.scene.input.KeyCode.UP;
import static javafx.scene.input.KeyEvent.*;

/**
 * Behaviors for LocalDate based cells types. Simply defines methods
 * that subclasses implement so that CellSkinBase has API to call.
 *
 */
public class DateCellBehavior extends BehaviorBase<DateCell> {

    private final InputMap<DateCell> inputMap;

    public DateCellBehavior(DateCell dateCell) {
        super(dateCell);

        inputMap = createInputMap();
        addDefaultMapping(inputMap,
            new InputMap.KeyMapping(UP,    e -> traverse(dateCell, Direction.UP)),
            new InputMap.KeyMapping(DOWN,  e -> traverse(dateCell, Direction.DOWN)),
            new InputMap.KeyMapping(LEFT,  e -> traverse(dateCell, Direction.LEFT)),
            new InputMap.KeyMapping(RIGHT, e -> traverse(dateCell, Direction.RIGHT)),
            new InputMap.KeyMapping(ENTER, KEY_RELEASED, e -> selectDate()),
            new InputMap.KeyMapping(SPACE, KEY_RELEASED, e -> selectDate())
        );
    }

    @Override public InputMap<DateCell> getInputMap() {
        return inputMap;
    }

    private void selectDate() {
        DateCell cell = getNode();
        DatePickerContent dpc = findDatePickerContent(cell);
        dpc.selectDayCell(cell);
    }

    public void traverse(final DateCell cell, final Direction dir) {
        boolean rtl = (cell.getEffectiveNodeOrientation() == NodeOrientation.RIGHT_TO_LEFT);
        DatePickerContent dpc = findDatePickerContent(cell);
        if (dpc != null) {
            switch (dir) {
                case UP:    dpc.goToDayCell(cell, -1, ChronoUnit.WEEKS, true); break;
                case DOWN:  dpc.goToDayCell(cell, +1, ChronoUnit.WEEKS, true); break;
                case LEFT:  dpc.goToDayCell(cell, rtl ? +1 : -1, ChronoUnit.DAYS,  true); break;
                case RIGHT: dpc.goToDayCell(cell, rtl ? -1 : +1, ChronoUnit.DAYS,  true); break;
                default:
            }
        }
    }

    protected DatePickerContent findDatePickerContent(Node node) {
        Node parent = node;
        while ((parent = parent.getParent()) != null && !(parent instanceof DatePickerContent));
        return (DatePickerContent)parent;
    }
}
