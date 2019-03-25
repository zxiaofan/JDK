/*
 * Copyright (c) 2008, 2016, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.fs;

import java.nio.file.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.*;
import java.io.IOException;
import static sun.nio.fs.UnixNativeDispatcher.*;

/**
 * Unix implementation of java.nio.file.DirectoryStream
 */

class UnixDirectoryStream
    implements DirectoryStream<Path>
{
    // path to directory when originally opened
    private final UnixPath dir;

    // directory pointer (returned by opendir)
    private final long dp;

    // filter (may be null)
    private final DirectoryStream.Filter<? super Path> filter;

    // used to coordinate closing of directory stream
    private final ReentrantReadWriteLock streamLock =
        new ReentrantReadWriteLock(true);

    // indicates if directory stream is open (synchronize on closeLock)
    private volatile boolean isClosed;

    // directory iterator
    private Iterator<Path> iterator;

    /**
     * Initializes a new instance
     */
    UnixDirectoryStream(UnixPath dir, long dp, DirectoryStream.Filter<? super Path> filter) {
        this.dir = dir;
        this.dp = dp;
        this.filter = filter;
    }

    protected final UnixPath directory() {
        return dir;
    }

    protected final Lock readLock() {
        return streamLock.readLock();
    }

    protected final Lock writeLock() {
        return streamLock.writeLock();
    }

    protected final boolean isOpen() {
        return !isClosed;
    }

    protected final boolean closeImpl() throws IOException {
        if (!isClosed) {
            isClosed = true;
            try {
                closedir(dp);
            } catch (UnixException x) {
                throw new IOException(x.errorString());
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void close()
        throws IOException
    {
        writeLock().lock();
        try {
            closeImpl();
        } finally {
            writeLock().unlock();
        }
    }

    protected final Iterator<Path> iterator(DirectoryStream<Path> ds) {
        if (isClosed) {
            throw new IllegalStateException("Directory stream is closed");
        }
        synchronized (this) {
            if (iterator != null)
                throw new IllegalStateException("Iterator already obtained");
            iterator = new UnixDirectoryIterator();
            return iterator;
        }
    }

    @Override
    public Iterator<Path> iterator() {
        return iterator(this);
    }

    /**
     * Iterator implementation
     */
    private class UnixDirectoryIterator implements Iterator<Path> {
        // true when at EOF
        private boolean atEof;

        // next entry to return
        private Path nextEntry;

        UnixDirectoryIterator() {
            atEof = false;
        }

        // Return true if file name is "." or ".."
        private boolean isSelfOrParent(byte[] nameAsBytes) {
            if (nameAsBytes[0] == '.') {
                if ((nameAsBytes.length == 1) ||
                    (nameAsBytes.length == 2 && nameAsBytes[1] == '.')) {
                    return true;
                }
            }
            return false;
        }

        // Returns next entry (or null)
        private Path readNextEntry() {
            assert Thread.holdsLock(this);

            for (;;) {
                byte[] nameAsBytes = null;

                // prevent close while reading
                readLock().lock();
                try {
                    if (isOpen()) {
                        nameAsBytes = readdir(dp);
                    }
                } catch (UnixException x) {
                    IOException ioe = x.asIOException(dir);
                    throw new DirectoryIteratorException(ioe);
                } finally {
                    readLock().unlock();
                }

                // EOF
                if (nameAsBytes == null) {
                    atEof = true;
                    return null;
                }

                // ignore "." and ".."
                if (!isSelfOrParent(nameAsBytes)) {
                    Path entry = dir.resolve(nameAsBytes);

                    // return entry if no filter or filter accepts it
                    try {
                        if (filter == null || filter.accept(entry))
                            return entry;
                    } catch (IOException ioe) {
                        throw new DirectoryIteratorException(ioe);
                    }
                }
            }
        }

        @Override
        public synchronized boolean hasNext() {
            if (nextEntry == null && !atEof)
                nextEntry = readNextEntry();
            return nextEntry != null;
        }

        @Override
        public synchronized Path next() {
            Path result;
            if (nextEntry == null && !atEof) {
                result = readNextEntry();
            } else {
                result = nextEntry;
                nextEntry = null;
            }
            if (result == null)
                throw new NoSuchElementException();
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
