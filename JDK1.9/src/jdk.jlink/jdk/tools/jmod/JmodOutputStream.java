/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jmod;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import jdk.internal.jmod.JmodFile;

import static jdk.internal.jmod.JmodFile.*;

/**
 * Output stream to write to JMOD file
 */
class JmodOutputStream extends OutputStream implements AutoCloseable {
    /**
     * This method creates (or overrides, if exists) the JMOD file,
     * returning the the output stream to write to the JMOD file.
     */
    static JmodOutputStream newOutputStream(Path file) throws IOException {
        OutputStream out = Files.newOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(out);
        return new JmodOutputStream(bos);
    }

    private final ZipOutputStream zos;
    private JmodOutputStream(OutputStream out) {
        this.zos = new ZipOutputStream(out);
        try {
            JmodFile.writeMagicNumber(out);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Writes the input stream to the named entry of the given section.
     */
    public void writeEntry(InputStream in, Section section, String name)
        throws IOException
    {
        ZipEntry ze = newEntry(section, name);
        zos.putNextEntry(ze);
        in.transferTo(zos);
        zos.closeEntry();
    }

    /**
     * Writes the given bytes to the named entry of the given section.
     */
    public void writeEntry(byte[] bytes, Section section, String path)
        throws IOException
    {
        ZipEntry ze = newEntry(section, path);
        zos.putNextEntry(ze);
        zos.write(bytes);
        zos.closeEntry();
    }

    /**
     * Writes the given entry to the given input stream.
     */
    public void writeEntry(InputStream in, Entry e) throws IOException {
        zos.putNextEntry(e.zipEntry());
        zos.write(in.readAllBytes());
        zos.closeEntry();
    }

    private ZipEntry newEntry(Section section, String path) {
        String prefix = section.jmodDir();
        String name = Paths.get(prefix, path).toString()
                           .replace(File.separatorChar, '/');
        return new ZipEntry(name);
    }

    @Override
    public void write(int b) throws IOException {
        zos.write(b);
    }

    @Override
    public void close() throws IOException {
        zos.close();
    }
}

