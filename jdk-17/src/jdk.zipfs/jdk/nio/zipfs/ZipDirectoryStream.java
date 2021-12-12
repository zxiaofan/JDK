/*
 * Copyright (c) 2009, 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nio.zipfs;

import java.io.IOException;
import java.nio.file.ClosedDirectoryStreamException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Xueming Shen, Rajendra Gutupalli, Jaya Hangal
 */
class ZipDirectoryStream implements DirectoryStream<Path> {

    private final ZipFileSystem zipfs;
    private final ZipPath dir;
    private final DirectoryStream.Filter<? super Path> filter;
    private volatile boolean isClosed;
    private volatile Iterator<Path> itr;

    ZipDirectoryStream(ZipPath dir,
                       DirectoryStream.Filter<? super java.nio.file.Path> filter)
        throws IOException
    {
        this.zipfs = dir.getFileSystem();
        this.dir = dir;
        this.filter = filter;
        // sanity check
        if (!zipfs.isDirectory(dir.getResolvedPath()))
            throw new NotDirectoryException(dir.toString());
    }

    @Override
    public synchronized Iterator<Path> iterator() {
        if (isClosed)
            throw new ClosedDirectoryStreamException();
        if (itr != null)
            throw new IllegalStateException("Iterator has already been returned");

        try {
            itr = zipfs.iteratorOf(dir, filter);
        } catch (IOException e) {
            throw new DirectoryIteratorException(e);
        }

        return new Iterator<Path>() {
            @Override
            public boolean hasNext() {
                if (isClosed)
                    return false;
                return itr.hasNext();
            }

            @Override
            public synchronized Path next() {
                if (isClosed)
                    throw new NoSuchElementException();
                return itr.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public synchronized void close() throws IOException {
        isClosed = true;
    }
}
