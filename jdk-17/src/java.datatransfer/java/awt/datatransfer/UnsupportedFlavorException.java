/*
 * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.datatransfer;

import java.io.Serial;

/**
 * Signals that the requested data is not supported in this flavor.
 *
 * @author Amy Fowler
 * @see Transferable#getTransferData
 * @since 1.1
 */
public class UnsupportedFlavorException extends Exception {

    /**
     * Use serialVersionUID from JDK 1.1 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 5383814944251665601L;

    /**
     * Constructs an UnsupportedFlavorException.
     *
     * @param  flavor the flavor object which caused the exception. May be
     *         {@code null}.
     */
    public UnsupportedFlavorException(DataFlavor flavor) {
        super((flavor != null) ? flavor.getHumanPresentableName() : null);
    }
}
