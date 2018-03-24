/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.input;

import javafx.beans.NamedArg;
import javafx.event.ActionEvent;
import javafx.scene.Node;

/**
 * This class is used when creating a Mnemonic.
 * The Mnemonic is constructed with a {@link javafx.scene.Node Node} and a {@link KeyCombination}.
 * When a Mnemonic is registered on a {@link javafx.scene.Scene Scene}, and the KeyCombination reaches the Scene unconsumed,
 * then the target Node will be sent an {@link javafx.event.ActionEvent ActionEvent}.
 * <p>
 * Controls should use their MnemonicParsing property when adding Mnemonics.
 * </p>
 * <p>
 * Mnemonics will not be displayed on all platforms, but the api
 * will still be present.
 * </p>
 * @since JavaFX 2.0
 */

public class Mnemonic {

    /**
     * Constructs a {@code Mnemonic} with the specified target {@link javafx.scene.Node Node}
     * and trigger {@link KeyCombination}.
     *
     * @param node the {@link javafx.scene.Node Node} that will receive the {@link javafx.event.ActionEvent ActionEvent}.
     * @param keyCombination the {@link KeyCombination} that will trigger the Mnemonic.
     */
    public Mnemonic(@NamedArg("node") Node node, @NamedArg("keyCombination") KeyCombination keyCombination) {
        this.node = node;
        this.keyCombination = keyCombination;
    }

    private KeyCombination keyCombination;
    /**
     * Returns the {@link KeyCombination}
     * @return the {@code KeyCombination}
     */
    public KeyCombination getKeyCombination() { return keyCombination; }

    /**
     * Sets the {@link KeyCombination}
     * @param keyCombination the {@code KeyCombination}
     */
    public void setKeyCombination(KeyCombination keyCombination) {
        this.keyCombination = keyCombination;
    }

    private Node node;

    /**
     * Returns the {@link javafx.scene.Node Node}
     * @return the {@code Node}
     */
    public Node getNode() { return node; }

    /**
     * Sets the {@link javafx.scene.Node Node}
     * @param node the {@code Node}
     * @since JavaFX 2.2
     */
    public void setNode(Node node) {
        this.node = node;
    }

    /**
     * Fire the {@link javafx.event.ActionEvent ActionEvent}
     */
    public void fire() {
        if (node != null)
            node.fireEvent(new ActionEvent());
    }
}
