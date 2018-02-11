/*
 * Copyright (c) 1996, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.windows;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Map;

import sun.awt.datatransfer.DataTransferer;
import sun.awt.datatransfer.SunClipboard;


/**
 * A class which interfaces with the Windows clipboard in order to support
 * data transfer via Clipboard operations. Most of the work is provided by
 * sun.awt.datatransfer.DataTransferer.
 *
 * @author Tom Ball
 * @author David Mendenhall
 * @author Danila Sinopalnikov
 * @author Alexander Gerasimov
 *
 * @since 1.1
 */
final class WClipboard extends SunClipboard {

    private boolean isClipboardViewerRegistered;

    WClipboard() {
        super("System");
    }

    @Override
    public long getID() {
        return 0;
    }

    @Override
    protected void setContentsNative(Transferable contents) {
        // Don't use delayed Clipboard rendering for the Transferable's data.
        // If we did that, we would call Transferable.getTransferData on
        // the Toolkit thread, which is a security hole.
        //
        // Get all of the target formats into which the Transferable can be
        // translated. Then, for each format, translate the data and post
        // it to the Clipboard.
        Map <Long, DataFlavor> formatMap = WDataTransferer.getInstance().
            getFormatsForTransferable(contents, getDefaultFlavorTable());

        openClipboard(this);

        try {
            for (Long format : formatMap.keySet()) {
                DataFlavor flavor = formatMap.get(format);

                try {
                    byte[] bytes = WDataTransferer.getInstance().
                        translateTransferable(contents, flavor, format);
                    publishClipboardData(format, bytes);
                } catch (IOException e) {
                    // Fix 4696186: don't print exception if data with
                    // javaJVMLocalObjectMimeType failed to serialize.
                    // May remove this if-check when 5078787 is fixed.
                    if (!(flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType) &&
                          e instanceof java.io.NotSerializableException)) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            closeClipboard();
        }
    }

    private void lostSelectionOwnershipImpl() {
        lostOwnershipImpl();
    }

    /**
     * Currently delayed data rendering is not used for the Windows clipboard,
     * so there is no native context to clear.
     */
    @Override
    protected void clearNativeContext() {}

    /**
     * Call the Win32 OpenClipboard function. If newOwner is non-null,
     * we also call EmptyClipboard and take ownership.
     *
     * @throws IllegalStateException if the clipboard has not been opened
     */
    @Override
    public native void openClipboard(SunClipboard newOwner) throws IllegalStateException;
    /**
     * Call the Win32 CloseClipboard function if we have clipboard ownership,
     * does nothing if we have not ownership.
     */
    @Override
    public native void closeClipboard();
    /**
     * Call the Win32 SetClipboardData function.
     */
    private native void publishClipboardData(long format, byte[] bytes);

    private static native void init();
    static {
        init();
    }

    @Override
    protected native long[] getClipboardFormats();
    @Override
    protected native byte[] getClipboardData(long format) throws IOException;

    @Override
    protected void registerClipboardViewerChecked() {
        if (!isClipboardViewerRegistered) {
            registerClipboardViewer();
            isClipboardViewerRegistered = true;
        }
    }

    private native void registerClipboardViewer();

    /**
     * The clipboard viewer (it's the toolkit window) is not unregistered
     * until the toolkit window disposing since MSDN suggests removing
     * the window from the clipboard viewer chain just before it is destroyed.
     */
    @Override
    protected void unregisterClipboardViewerChecked() {}

    /**
     * Upcall from native code.
     */
    private void handleContentsChanged() {
        if (!areFlavorListenersRegistered()) {
            return;
        }

        long[] formats = null;
        try {
            openClipboard(null);
            formats = getClipboardFormats();
        } catch (IllegalStateException exc) {
            // do nothing to handle the exception, call checkChange(null)
        } finally {
            closeClipboard();
        }
        checkChange(formats);
    }

    /**
     * The clipboard must be opened.
     *
     * @since 1.5
     */
    @Override
    protected Transferable createLocaleTransferable(long[] formats) throws IOException {
        boolean found = false;
        for (int i = 0; i < formats.length; i++) {
            if (formats[i] == WDataTransferer.CF_LOCALE) {
                found = true;
                break;
            }
        }
        if (!found) {
            return null;
        }

        byte[] localeData = null;
        try {
            localeData = getClipboardData(WDataTransferer.CF_LOCALE);
        } catch (IOException ioexc) {
            return null;
        }

        final byte[] localeDataFinal = localeData;

        return new Transferable() {
                @Override
                public DataFlavor[] getTransferDataFlavors() {
                    return new DataFlavor[] { DataTransferer.javaTextEncodingFlavor };
                }
                @Override
                public boolean isDataFlavorSupported(DataFlavor flavor) {
                    return flavor.equals(DataTransferer.javaTextEncodingFlavor);
                }
                @Override
                public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
                    if (isDataFlavorSupported(flavor)) {
                        return localeDataFinal;
                    }
                    throw new UnsupportedFlavorException(flavor);
                }
            };
    }
}
