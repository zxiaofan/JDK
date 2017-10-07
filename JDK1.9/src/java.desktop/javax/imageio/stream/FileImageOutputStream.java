/*
 * Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.imageio.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import com.sun.imageio.stream.CloseableDisposerRecord;
import com.sun.imageio.stream.StreamFinalizer;
import sun.java2d.Disposer;

/**
 * An implementation of {@code ImageOutputStream} that writes its
 * output directly to a {@code File} or
 * {@code RandomAccessFile}.
 *
 */
public class FileImageOutputStream extends ImageOutputStreamImpl {

    private RandomAccessFile raf;

    /** The referent to be registered with the Disposer. */
    private final Object disposerReferent;

    /** The DisposerRecord that closes the underlying RandomAccessFile. */
    private final CloseableDisposerRecord disposerRecord;

    /**
     * Constructs a {@code FileImageOutputStream} that will write
     * to a given {@code File}.
     *
     * @param f a {@code File} to write to.
     *
     * @exception IllegalArgumentException if {@code f} is
     * {@code null}.
     * @exception SecurityException if a security manager exists
     * and does not allow write access to the file.
     * @exception FileNotFoundException if {@code f} does not denote
     * a regular file or it cannot be opened for reading and writing for any
     * other reason.
     * @exception IOException if an I/O error occurs.
     */
    public FileImageOutputStream(File f)
        throws FileNotFoundException, IOException {
        this(f == null ? null : new RandomAccessFile(f, "rw"));
    }

    /**
     * Constructs a {@code FileImageOutputStream} that will write
     * to a given {@code RandomAccessFile}.
     *
     * @param raf a {@code RandomAccessFile} to write to.
     *
     * @exception IllegalArgumentException if {@code raf} is
     * {@code null}.
     */
    public FileImageOutputStream(RandomAccessFile raf) {
        if (raf == null) {
            throw new IllegalArgumentException("raf == null!");
        }
        this.raf = raf;

        disposerRecord = new CloseableDisposerRecord(raf);
        if (getClass() == FileImageOutputStream.class) {
            disposerReferent = new Object();
            Disposer.addRecord(disposerReferent, disposerRecord);
        } else {
            disposerReferent = new StreamFinalizer(this);
        }
    }

    public int read() throws IOException {
        checkClosed();
        bitOffset = 0;
        int val = raf.read();
        if (val != -1) {
            ++streamPos;
        }
        return val;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        checkClosed();
        bitOffset = 0;
        int nbytes = raf.read(b, off, len);
        if (nbytes != -1) {
            streamPos += nbytes;
        }
        return nbytes;
    }

    public void write(int b) throws IOException {
        flushBits(); // this will call checkClosed() for us
        raf.write(b);
        ++streamPos;
    }

    public void write(byte[] b, int off, int len) throws IOException {
        flushBits(); // this will call checkClosed() for us
        raf.write(b, off, len);
        streamPos += len;
    }

    public long length() {
        try {
            checkClosed();
            return raf.length();
        } catch (IOException e) {
            return -1L;
        }
    }

    /**
     * Sets the current stream position and resets the bit offset to
     * 0.  It is legal to seeking past the end of the file; an
     * {@code EOFException} will be thrown only if a read is
     * performed.  The file length will not be increased until a write
     * is performed.
     *
     * @exception IndexOutOfBoundsException if {@code pos} is smaller
     * than the flushed position.
     * @exception IOException if any other I/O error occurs.
     */
    public void seek(long pos) throws IOException {
        checkClosed();
        if (pos < flushedPos) {
            throw new IndexOutOfBoundsException("pos < flushedPos!");
        }
        bitOffset = 0;
        raf.seek(pos);
        streamPos = raf.getFilePointer();
    }

    public void close() throws IOException {
        super.close();
        disposerRecord.dispose(); // this closes the RandomAccessFile
        raf = null;
    }

    /**
     * {@inheritDoc}
     *
     * @deprecated The {@code finalize} method has been deprecated.
     *     Subclasses that override {@code finalize} in order to perform cleanup
     *     should be modified to use alternative cleanup mechanisms and
     *     to remove the overriding {@code finalize} method.
     *     When overriding the {@code finalize} method, its implementation must explicitly
     *     ensure that {@code super.finalize()} is invoked as described in {@link Object#finalize}.
     *     See the specification for {@link Object#finalize()} for further
     *     information about migration options.
     */
    @Deprecated(since="9")
    protected void finalize() throws Throwable {
        // Empty finalizer: for performance reasons we instead use the
        // Disposer mechanism for ensuring that the underlying
        // RandomAccessFile is closed prior to garbage collection
    }
}
