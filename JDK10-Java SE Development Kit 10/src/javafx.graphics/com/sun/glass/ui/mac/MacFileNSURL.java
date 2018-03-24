/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui.mac;

import com.sun.glass.ui.Application;

import java.io.File;

/**
 * A descendant of the {@code File} class that also provides access to the
 * underlying native NSURL object associated with this File instance.
 *
 * Objects of this type are returned as a result of invoking the
 * {@code CommonDialogs.show[File|Folder]Chooser()} methods if
 * the "glass.macosx.enableFileNSURL" system property is {@code true}.
 */
public final class MacFileNSURL extends File {

    private native static void _initIDs();
    static {
        _initIDs();
    }

    /**
     * A pointer to the NSURL object.
     */
    private long ptr;

    private MacFileNSURL(String name, long ptr) {
        super(name);
        this.ptr = ptr;
        Application.checkEventThread();
    }


    // ------------- NSURL --------------

    private void checkNotDisposed() {
        if (ptr == 0L) {
            throw new RuntimeException("The NSURL object has been diposed already");
        }
    }

    native private void _dispose(long ptr);
    /**
     * Releases the underlying NSURL object.
     *
     * An application must call this method after it no longer needs to use
     * this object in order to release native resources associated with it.
     */
    public void dispose() {
        Application.checkEventThread();
        checkNotDisposed();
        _dispose(ptr);
        ptr = 0L;
    }

    native private boolean _startAccessingSecurityScopedResource(long ptr);
    /**
     * Makes the resource pointed to by a security-scoped URL available to the app.
     *
     * The call must be balanced with a corresponding call to {@link stopAccessingSecurityScopedResource}
     * using the try{}finally{} pattern.
     *
     * @return {@code true} if the request to access the resource succeeded; otherwise, {@code false}
     */
    public boolean startAccessingSecurityScopedResource() {
        Application.checkEventThread();
        checkNotDisposed();
        return _startAccessingSecurityScopedResource(ptr);
    }

    native private void _stopAccessingSecurityScopedResource(long ptr);
    /**
     * Revokes access to the resource pointed to by a security-scoped URL.
     */
    public void stopAccessingSecurityScopedResource() {
        Application.checkEventThread();
        checkNotDisposed();
        _stopAccessingSecurityScopedResource(ptr);
    }


    // ------------- Bookmarks --------------

    native private byte[] _getBookmark(long ptr, long baseDocumentPtr);
    /**
     * Returns a byte array representing a persistent bookmark for this URL.
     * An app can store this data, and later re-create the URL with a call
     * to {@link createFromBookmark}.
     *
     * @return bookmark data in a form of byte[]
     */
    public byte[] getBookmark() {
        Application.checkEventThread();
        checkNotDisposed();
        return _getBookmark(ptr, 0L);
    }

    native private static MacFileNSURL _createFromBookmark(byte[] data, long baseDocumentPtr);
    /**
     * Returns an instance of the MacFileNSURL class created from bookmark
     * data stored in the byte array passed as an argument.
     *
     * The glass.macosx.enableFileNSURL system property must be set to {@code
     * true} before calling this method.
     *
     * @return a new instance of MacFileNSURL
     */
    public static MacFileNSURL createFromBookmark(byte[] data) {
        Application.checkEventThread();
        if (data == null) {
            throw new NullPointerException("data must not be null");
        }
        if (!MacCommonDialogs.isFileNSURLEnabled()) {
            throw new RuntimeException("The system property glass.macosx.enableFileNSURL is not 'true'");
        }
        return _createFromBookmark(data, 0L);
    }

    /**
     * Returns a byte array representing a document-scoped bookmark
     * for this URL relative to the {@code baseDocument} URL.
     * An app can store this data, and later re-create the URL with a call
     * to {@link createFromDocumentScopedBookmark}.
     *
     * @throws NullPointerException if baseDocument is {@code null}
     * @return bookmark data in a form of byte[]
     */
    public byte[] getDocumentScopedBookmark(MacFileNSURL baseDocument) {
        Application.checkEventThread();
        checkNotDisposed();
        return _getBookmark(ptr, baseDocument.ptr);
    }

    /**
     * Returns an instance of the MacFileNSURL class created from a
     * document-scoped bookmark data stored in the byte array passed as an
     * argument, relative to the {@code baseDocument} URL.
     *
     * The glass.macosx.enableFileNSURL system property must be set to {@code
     * true} before calling this method.
     *
     * @throws NullPointerException if baseDocument is {@code null}
     * @return a new instance of MacFileNSURL
     */
    public static MacFileNSURL createFromDocumentScopedBookmark(byte[] data, MacFileNSURL baseDocument) {
        Application.checkEventThread();
        if (data == null) {
            throw new NullPointerException("data must not be null");
        }
        if (!MacCommonDialogs.isFileNSURLEnabled()) {
            throw new RuntimeException("The system property glass.macosx.enableFileNSURL is not 'true'");
        }
        return _createFromBookmark(data, baseDocument.ptr);
    }
}

