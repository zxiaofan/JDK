/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package java.io;

import jdk.internal.access.JavaIOFileDescriptorAccess;
import jdk.internal.access.SharedSecrets;
import jdk.internal.ref.CleanerFactory;
import jdk.internal.ref.PhantomCleanable;

import java.lang.ref.Cleaner;

/**
 * Cleanable for a FileDescriptor when it becomes phantom reachable.
 * For regular fds on Unix and regular handles on Windows
 * register a cleanup if fd != -1 or handle != -1.
 * <p>
 * Subclassed from {@code PhantomCleanable} so that {@code clear} can be
 * called to disable the cleanup when the handle is closed by any means other
 * than calling {@link FileDescriptor#close}.
 * Otherwise, it might incorrectly close the handle after it has been reused.
 */
final class FileCleanable extends PhantomCleanable<FileDescriptor> {

    // Access to FileDescriptor private fields;
    // avoids making fd and handle package private
    private static final JavaIOFileDescriptorAccess fdAccess =
            SharedSecrets.getJavaIOFileDescriptorAccess();

    /*
     * Raw close of the file fd and/or handle.
     * Used only for last chance cleanup.
     */
    private static native void cleanupClose0(int fd, long handle) throws IOException;

    // The raw fd to close
    private final int fd;

    // The handle to close
    private final long handle;

    /**
     * Register a Cleanable with the FileDescriptor
     * if the FileDescriptor is non-null and valid.
     * @implNote
     * A exception (OutOfMemoryException) will leave the FileDescriptor
     * having allocated resources and leak the fd/handle.
     *
     * @param fdo the FileDescriptor; may be null
     */
    static void register(FileDescriptor fdo) {
        if (fdo != null && fdo.valid()) {
            int fd = fdAccess.get(fdo);
            long handle = fdAccess.getHandle(fdo);
            fdo.registerCleanup(new FileCleanable(fdo, CleanerFactory.cleaner(), fd, handle));
        }
    }

    /**
     * Unregister a Cleanable from the FileDescriptor.
     * @param fdo the FileDescriptor; may be null
     */
    static void unregister(FileDescriptor fdo) {
        if (fdo != null) {
            fdo.unregisterCleanup();
        }
    }

    /**
     * Constructor for a phantom cleanable reference.
     *
     * @param obj     the object to monitor
     * @param cleaner the cleaner
     * @param fd      file descriptor to close
     * @param handle  handle to close
     */
    private FileCleanable(FileDescriptor obj, Cleaner cleaner, int fd, long handle) {
        super(obj, cleaner);
        this.fd = fd;
        this.handle = handle;
    }

    /**
     * Close the native handle or fd.
     */
    @Override
    protected void performCleanup() {
        try {
            cleanupClose0(fd, handle);
        } catch (IOException ioe) {
            throw new UncheckedIOException("close", ioe);
        }
    }
}
