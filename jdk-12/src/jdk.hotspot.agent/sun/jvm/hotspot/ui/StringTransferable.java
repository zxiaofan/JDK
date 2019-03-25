/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.ui;

import java.awt.datatransfer.*;
import java.io.IOException;

/** String transferable for drag-and-drop.

    @author Shannon Hickey
*/

class StringTransferable implements Transferable {

    private static final DataFlavor[] supported = {DataFlavor.stringFlavor};

    private String str;

    public StringTransferable(String str) {
        this.str = str;
    }

    public DataFlavor[] getTransferDataFlavors() {
        return supported;
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return DataFlavor.stringFlavor.equals(flavor);
    }

    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (!isDataFlavorSupported(flavor)) {
            throw new UnsupportedFlavorException(flavor);
        }
        return str;
    }

}
