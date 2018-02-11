/*
 * Copyright (c) 2000, 2016, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.transform;

/**
 * An object that implements this interface contains the information
 * needed to act as source input (XML source or transformation instructions).
 *
 * @since 1.4
 */
public interface Source {

    /**
     * Set the system identifier for this Source.
     *
     * <p>The system identifier is optional if the source does not
     * get its data from a URL, but it may still be useful to provide one.
     * The application can use a system identifier, for example, to resolve
     * relative URIs and to include in error messages and warnings.</p>
     *
     * @param systemId The system identifier as a URL string.
     */
    public void setSystemId(String systemId);

    /**
     * Get the system identifier that was set with setSystemId.
     *
     * @return The system identifier that was set with setSystemId, or null
     * if setSystemId was not called.
     */
    public String getSystemId();

    /**
     * Indicates whether the {@code Source} object is empty. Empty means
     * that there is no input available from this Source.
     *
     * @implSpec The default implementation of this method throws
     * {@link UnsupportedOperationException}.
     *
     * @return true if the {@code Source} object is empty, false otherwise
     */
    default boolean isEmpty() {
        throw new UnsupportedOperationException("The isEmpty method is not supported.");
    }
}
