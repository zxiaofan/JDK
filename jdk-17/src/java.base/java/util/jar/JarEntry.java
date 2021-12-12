/*
 * Copyright (c) 1997, 2019, Oracle and/or its affiliates. All rights reserved.
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

package java.util.jar;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.security.CodeSigner;
import java.security.cert.Certificate;

/**
 * This class is used to represent a JAR file entry.
 *
 * @since 1.2
 */
public class JarEntry extends ZipEntry {
    Attributes attr;
    Certificate[] certs;
    CodeSigner[] signers;

    /**
     * Creates a new {@code JarEntry} for the specified JAR file
     * entry name.
     *
     * @param name the JAR file entry name
     * @throws    NullPointerException if the entry name is {@code null}
     * @throws    IllegalArgumentException if the entry name is longer than
     *            0xFFFF bytes.
     */
    public JarEntry(String name) {
        super(name);
    }

    /**
     * Creates a new {@code JarEntry} with fields taken from the
     * specified {@code ZipEntry} object.
     * @param ze the {@code ZipEntry} object to create the
     *           {@code JarEntry} from
     */
    public JarEntry(ZipEntry ze) {
        super(ze);
    }

    /**
     * Creates a new {@code JarEntry} with fields taken from the
     * specified {@code JarEntry} object.
     *
     * @param je the {@code JarEntry} to copy
     */
    public JarEntry(JarEntry je) {
        this((ZipEntry)je);
        this.attr = je.attr;
        this.certs = je.certs;
        this.signers = je.signers;
    }

    /**
     * Returns the {@code Manifest} {@code Attributes} for this
     * entry, or {@code null} if none.
     *
     * @return the {@code Manifest} {@code Attributes} for this
     * entry, or {@code null} if none
     * @throws IOException  if an I/O error has occurred
     */
    public Attributes getAttributes() throws IOException {
        return attr;
    }

    /**
     * Returns the {@code Certificate} objects for this entry, or
     * {@code null} if none. This method can only be called once
     * the {@code JarEntry} has been completely verified by reading
     * from the entry input stream until the end of the stream has been
     * reached. Otherwise, this method will return {@code null}.
     *
     * <p>The returned certificate array comprises all the signer certificates
     * that were used to verify this entry. Each signer certificate is
     * followed by its supporting certificate chain (which may be empty).
     * Each signer certificate and its supporting certificate chain are ordered
     * bottom-to-top (i.e., with the signer certificate first and the (root)
     * certificate authority last).
     *
     * @return the {@code Certificate} objects for this entry, or
     * {@code null} if none.
     */
    public Certificate[] getCertificates() {
        return certs == null ? null : certs.clone();
    }

    /**
     * Returns the {@code CodeSigner} objects for this entry, or
     * {@code null} if none. This method can only be called once
     * the {@code JarEntry} has been completely verified by reading
     * from the entry input stream until the end of the stream has been
     * reached. Otherwise, this method will return {@code null}.
     *
     * <p>The returned array comprises all the code signers that have signed
     * this entry.
     *
     * @return the {@code CodeSigner} objects for this entry, or
     * {@code null} if none.
     *
     * @since 1.5
     */
    public CodeSigner[] getCodeSigners() {
        return signers == null ? null : signers.clone();
    }

    /**
     * Returns the real name of this {@code JarEntry}.
     *
     * If this {@code JarEntry} is an entry of a
     * <a href="JarFile.html#multirelease">multi-release jar file</a> and the
     * {@code JarFile} is configured to be processed as such, the name returned
     * by this method is the path name of the versioned entry that the
     * {@code JarEntry} represents, rather than the path name of the base entry
     * that {@link #getName()} returns. If the {@code JarEntry} does not represent
     * a versioned entry of a multi-release {@code JarFile} or the {@code JarFile}
     * is not configured for processing a multi-release jar file, this method
     * returns the same name that {@link #getName()} returns.
     *
     * @return the real name of the JarEntry
     *
     * @since 10
     */
    public String getRealName() {
        return super.getName();
    }
}
