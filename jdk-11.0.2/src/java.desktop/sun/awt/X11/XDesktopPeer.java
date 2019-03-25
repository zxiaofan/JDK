/*
 * Copyright (c) 2005, 2016, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.X11;


import sun.awt.UNIXToolkit;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import java.awt.Desktop.Action;
import java.awt.peer.DesktopPeer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Concrete implementation of the interface {@code DesktopPeer} for
 * the Gnome desktop on Linux and Unix platforms.
 *
 * @see DesktopPeer
 */
public class XDesktopPeer implements DesktopPeer {

    // supportedActions may be changed from native within an init() call
    private static final List<Action> supportedActions
            = new ArrayList<>(Arrays.asList(Action.OPEN, Action.MAIL, Action.BROWSE));

    private static boolean nativeLibraryLoaded = false;
    private static boolean initExecuted = false;

    private static void initWithLock(){
        XToolkit.awtLock();
        try {
            if (!initExecuted) {
                nativeLibraryLoaded = init(UNIXToolkit.getEnabledGtkVersion()
                        .getNumber(), UNIXToolkit.isGtkVerbose());
            }
        } finally {
            initExecuted = true;
            XToolkit.awtUnlock();
        }
    }

    //package-private
    XDesktopPeer(){
        initWithLock();
    }

    static boolean isDesktopSupported() {
        initWithLock();
        return nativeLibraryLoaded && !supportedActions.isEmpty();
    }

    public boolean isSupported(Action type) {
        return supportedActions.contains(type);
    }

    public void open(File file) throws IOException {
        try {
            launch(file.toURI());
        } catch (MalformedURLException e) {
            throw new IOException(file.toString());
        }
    }

    public void edit(File file) throws IOException {
        throw new UnsupportedOperationException("The current platform " +
            "doesn't support the EDIT action.");
    }

    public void print(File file) throws IOException {
        throw new UnsupportedOperationException("The current platform " +
            "doesn't support the PRINT action.");
    }

    public void mail(URI uri) throws IOException {
        launch(uri);
    }

    public void browse(URI uri) throws IOException {
        launch(uri);
    }

    private void launch(URI uri) throws IOException {
        byte[] uriByteArray = ( uri.toString() + '\0' ).getBytes();
        boolean result = false;
        XToolkit.awtLock();
        try {
            if (!nativeLibraryLoaded) {
                throw new IOException("Failed to load native libraries.");
            }
            result = gnome_url_show(uriByteArray);
        } finally {
            XToolkit.awtUnlock();
        }
        if (!result) {
            throw new IOException("Failed to show URI:" + uri);
        }
    }

    private native boolean gnome_url_show(byte[] url);
    private static native boolean init(int gtkVersion, boolean verbose);
}
