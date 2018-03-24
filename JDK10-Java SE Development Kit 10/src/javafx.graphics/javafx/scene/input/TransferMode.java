/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Describes the mode of data transfer with respect
 * to a drag and drop gesture.
 * @since JavaFX 2.0
 */
public enum
        TransferMode {

    /**
     * Indicates copying of data is supported or intended.
     */
    COPY,

    /**
     * Indicates moving of data is supported or intended.
     */
    MOVE,

    /**
     * Indicates linking of data is supported or intended.
     */
    LINK;


    /**
     * Array containing all transfer modes. This is a convenience constant
     * intended to be used in {@code startDragAndDrop} and
     * {@code DragEvent.acceptTransferModes()} calls.
     */
    public static final TransferMode[] ANY = { COPY, MOVE, LINK };

    /**
     * Array containing transfer modes COPY and MOVE. This is a convenience
     * constant intended to be used in {@code startDragAndDrop} and
     * {@code DragEvent.acceptTransferModes()} calls.
     */
    public static final TransferMode[] COPY_OR_MOVE = { COPY, MOVE };

    /**
     * Empty array of transfer modes. This is a convenience constant
     * intended to be used in {@code startDragAndDrop} and
     * {@code DragEvent.acceptTransferModes()} calls.
     */
    public static final TransferMode[] NONE = { };
}
