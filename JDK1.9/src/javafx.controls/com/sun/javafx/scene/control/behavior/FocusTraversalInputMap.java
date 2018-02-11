/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.scene.NodeHelper;
import com.sun.javafx.scene.traversal.Direction;
import javafx.event.EventTarget;
import javafx.scene.Node;
import com.sun.javafx.scene.control.inputmap.InputMap;
import com.sun.javafx.scene.control.inputmap.KeyBinding;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

import static com.sun.javafx.scene.control.inputmap.InputMap.*;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.TAB;
import static javafx.scene.input.KeyCode.UP;

public class FocusTraversalInputMap<N extends Node> {

    private static final List<InputMap.Mapping<?>> mappings = new ArrayList<>();
    static {
        mappings.add(new KeyMapping(UP, e -> traverseUp(e)));
        mappings.add(new KeyMapping(DOWN, e -> traverseDown(e)));
        mappings.add(new KeyMapping(LEFT, e -> traverseLeft(e)));
        mappings.add(new KeyMapping(RIGHT, e -> traverseRight(e)));
        mappings.add(new KeyMapping(TAB, e -> traverseNext(e)));
        mappings.add(new KeyMapping(new KeyBinding(TAB).shift(), e -> traversePrevious(e)));

        mappings.add(new KeyMapping(new KeyBinding(UP).shift().alt().ctrl(), e -> traverseUp(e)));
        mappings.add(new KeyMapping(new KeyBinding(DOWN).shift().alt().ctrl(), e -> traverseDown(e)));
        mappings.add(new KeyMapping(new KeyBinding(LEFT).shift().alt().ctrl(), e -> traverseLeft(e)));
        mappings.add(new KeyMapping(new KeyBinding(RIGHT).shift().alt().ctrl(), e -> traverseRight(e)));
        mappings.add(new KeyMapping(new KeyBinding(TAB).shift().alt().ctrl(), e -> traverseNext(e)));
        mappings.add(new KeyMapping(new KeyBinding(TAB).alt().ctrl(), e -> traversePrevious(e)));
    }

    private FocusTraversalInputMap() {
        // no-op, just forcing use of static method
    }

    public static InputMap.Mapping<?>[] getFocusTraversalMappings() {
        return mappings.toArray(new InputMap.Mapping[mappings.size()]);
    }

    public static <N extends Node> InputMap<N> createInputMap(N node) {
        InputMap<N> inputMap = new InputMap<>(node);
        inputMap.getMappings().addAll(getFocusTraversalMappings());
        return inputMap;
    }



    /***************************************************************************
     * Focus Traversal methods                                                 *
     **************************************************************************/

    /**
     * Called by any of the BehaviorBase traverse methods to actually effect a
     * traversal of the focus. The default behavior of this method is to simply
     * traverse on the given node, passing the given direction. A
     * subclass may override this method.
     *
     * @param node The node to traverse on
     * @param dir The direction to traverse
     */
    public static void traverse(final Node node, final Direction dir) {
        if (node == null) {
            throw new IllegalArgumentException("Attempting to traverse on a null Node. " +
                    "Most probably a KeyEvent has been fired with a null target specified.");
        }
        NodeHelper.traverse(node, dir);
    }

    /**
     * Calls the focus traversal engine and indicates that traversal should
     * go the next focusTraversable Node above the current one.
     */
    public static final void traverseUp(KeyEvent e) {
        traverse(getNode(e), com.sun.javafx.scene.traversal.Direction.UP);
    }

    /**
     * Calls the focus traversal engine and indicates that traversal should
     * go the next focusTraversable Node below the current one.
     */
    public static final void traverseDown(KeyEvent e) {
        traverse(getNode(e), com.sun.javafx.scene.traversal.Direction.DOWN);
    }

    /**
     * Calls the focus traversal engine and indicates that traversal should
     * go the next focusTraversable Node left of the current one.
     */
    public static final void traverseLeft(KeyEvent e) {
        traverse(getNode(e), com.sun.javafx.scene.traversal.Direction.LEFT);
    }

    /**
     * Calls the focus traversal engine and indicates that traversal should
     * go the next focusTraversable Node right of the current one.
     */
    public static final void traverseRight(KeyEvent e) {
        traverse(getNode(e), com.sun.javafx.scene.traversal.Direction.RIGHT);
    }

    /**
     * Calls the focus traversal engine and indicates that traversal should
     * go the next focusTraversable Node in the focus traversal cycle.
     */
    public static final void traverseNext(KeyEvent e) {
        traverse(getNode(e), com.sun.javafx.scene.traversal.Direction.NEXT);
    }

    /**
     * Calls the focus traversal engine and indicates that traversal should
     * go the previous focusTraversable Node in the focus traversal cycle.
     */
    public static final void traversePrevious(KeyEvent e) {
        traverse(getNode(e), com.sun.javafx.scene.traversal.Direction.PREVIOUS);
    }

    private static Node getNode(KeyEvent e) {
        EventTarget target = e.getTarget();
        if (target instanceof Node) {
            return (Node) target;
        }
        return null;
    }
}
