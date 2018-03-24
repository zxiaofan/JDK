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

package javax.print;

import java.net.URI;

/**
 * Interface {@code URIException} is a mixin interface which a subclass of
 * {@link PrintException PrintException} can implement to report an error
 * condition involving a {@code URI} address. The Print Service API does not
 * define any print exception classes that implement interface
 * {@code URIException}, that being left to the Print Service implementor's
 * discretion.
 */
public interface URIException {

    /**
     * Indicates that the printer cannot access the {@code URI} address. For
     * example, the printer might report this error if it goes to get the print
     * data and cannot even establish a connection to the {@code URI} address.
     */
    public static final int URIInaccessible = 1;

    /**
     * Indicates that the printer does not support the {@code URI} scheme
     * ("http", "ftp", etc.) in the {@code URI} address.
     */
    public static final int URISchemeNotSupported = 2;

    /**
     * Indicates any kind of problem not specifically identified by the other
     * reasons.
     */
    public static final int URIOtherProblem = -1;

    /**
     * Returns the {@code URI}.
     *
     * @return the {@code URI} that is the cause of this exception
     */
    public URI getUnsupportedURI();

    /**
     * Returns the reason of this exception.
     *
     * @return one of the predefined reasons enumerated in this interface
     */
    public int getReason();
}
